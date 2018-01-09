package fr.gtm.proxibanque.webservice;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VirementController {

	@Autowired
	private IVirementDao virementDao;

	@Autowired
	private ICompteDao compteDao;

	@Autowired
	private IConseillerDao conseillerDao;

	@RequestMapping(value = "/conseiller/{login}/virement", method = RequestMethod.POST, produces = "text/plain")
	public String virement(@PathVariable("login") String login, @RequestBody VirementFormulaire virementForm) {

		String reponse;

		// Récupération des comptes dans la BDD à partir des numéros fournis par le JSON
		Compte compteEmetteurBDD = compteDao.findByNumero(virementForm.getNumCompteEmetteur());
		Compte compteCibleBDD = compteDao.findByNumero(virementForm.getNumCompteCible());

		double soldeCompteEmetteur = compteEmetteurBDD.getSolde();
		double soldeCompteCible = compteCibleBDD.getSolde();
		double montant = virementForm.getMontant();

		if (montant > soldeCompteEmetteur) {
			reponse = "Le solde du compte émetteur est insuffisant.";
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
			reponse = "Le virement a été réalisé avec succès.";

		}

		return reponse;
	}

}
