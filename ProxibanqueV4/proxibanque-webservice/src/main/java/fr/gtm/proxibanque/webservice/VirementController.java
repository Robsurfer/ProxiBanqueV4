package fr.gtm.proxibanque.webservice;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;
import fr.gtm.proxibanque.domaine.VirementFormulaire;

/**
 * @author Loriane Ce RestController permet la gestion des webservices relatifs
 *         aux virements. Il comprend une méthode virement qui réalise le
 *         virement donné par le Front et le persiste en base de données.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class VirementController extends BaseController{

	@Autowired
	private IVirementDao virementDao;

	@Autowired
	private ICompteDao compteDao;

	@Autowired
	private IConseillerDao conseillerDao;

	/**
	 * Ce webservice permet de réaliser un virement avec les données reçues. Il
	 * renvoie un message d'échec si le virement est impossible (si le solde est
	 * insuffisant), et un message de succès si le virement est réalisé.
	 * 
	 * @param login,
	 *            le login du conseiller
	 * @param virementForm,
	 *            les données du virement issues du formulaire en Front
	 * @return String, la réponse (échec ou succès)
	 */
	@RequestMapping(value = "conseiller/{login}/virement", method = RequestMethod.POST, produces = "text/plain")
	public String virement(@PathVariable("login") String login, @RequestBody VirementFormulaire virementForm) {

		String reponse;

		// Récupération des comptes dans la BDD à partir des numéros fournis par le JSON
		Compte compteEmetteurBDD = compteDao.findByNumero(virementForm.getNumCompteEmetteur());
		Compte compteCibleBDD = compteDao.findByNumero(virementForm.getNumCompteCible());

		double soldeCompteEmetteur = compteEmetteurBDD.getSolde();
		double soldeCompteCible = compteCibleBDD.getSolde();
		double montant = virementForm.getMontant();

		if (montant > soldeCompteEmetteur) {
			reponse = "Le solde du compte émetteur est insuffisant pour le virement du compte n°"
					+ compteEmetteurBDD.getNumero() + " au compte n°" + compteCibleBDD.getNumero() + " d'un montant de "
					+ virementForm.getMontant() + " €.";
		} else {

			double newSoldeCompteEmetteur = soldeCompteEmetteur - montant;
			double newSoldeCompteCible = soldeCompteCible + montant;

			// Actualisation du solde des comptes
			compteEmetteurBDD.setSolde(newSoldeCompteEmetteur);
			compteCibleBDD.setSolde(newSoldeCompteCible);

			// Sauvegarde des comptes en base de données
			compteDao.save(compteEmetteurBDD);
			compteDao.save(compteCibleBDD);

			// Création du virement
			Virement virement = new Virement();
			virement.setCompteCible(compteCibleBDD);
			virement.setCompteEmetteur(compteEmetteurBDD);
			virement.setLibelle(virementForm.getLibelle());
			virement.setDateVirement(new Date());
			virement.setMontant(montant);

			// Assignation du conseiller au virement
			Conseiller conseiller = conseillerDao.findByLogin(login);
			virement.setConseiller(conseiller);

			// Sauvegarde du virement
			virementDao.save(virement);
			reponse = "Le virement du compte n°" + compteEmetteurBDD.getNumero() + " au compte n°"
					+ compteCibleBDD.getNumero() + " d'un montant de " + virementForm.getMontant()
					+ " € a été réalisé avec succès.";

		}

		return reponse;
	}

	/**
	 * Ce webservice permet de retourner la liste des virements d'un conseiller
	 * donné.
	 * 
	 * @param login
	 *            , l'id du conseiller identifie
	 * @return Collection<Virement>, la liste de tout les virements que le
	 *         conseiller a realise
	 */
	@RequestMapping(value = "conseiller/{login}/virement/liste", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAllVir(@PathVariable("login") String login) {
		return virementDao.findAllByConseiller_login(login);
	}

	/**
	 * Ce webservice permet de retourner la liste des virements associés à un compte donné
	 * donné.
	 * 
	 * @param login
	 *            , l'id du conseiller identifie
	 * @return Collection<Virement>, la liste de tout les virements que le
	 *         conseiller a realise
	 */
	@RequestMapping(value = "comptes/{numero}/virement/liste_debit", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAllVirByCompteEmetteur(@PathVariable("numero") int numero) {
		return virementDao.findAllByCompteEmetteur_numero(numero);
	}
	
	/**
	 * Ce webservice permet de retourner la liste des virements associés à un compte donné
	 * donné.
	 * 
	 * @param login
	 *            , l'id du conseiller identifie
	 * @return Collection<Virement>, la liste de tout les virements que le
	 *         conseiller a realise
	 */
	@RequestMapping(value = "comptes/{numero}/virement/liste_credit", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAllVirByCompteCible(@PathVariable("numero") int numero) {
		return virementDao.findAllByCompteCible_numero(numero);
	}
	
}
