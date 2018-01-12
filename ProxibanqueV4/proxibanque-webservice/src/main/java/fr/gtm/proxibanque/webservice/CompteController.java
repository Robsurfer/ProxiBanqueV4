package fr.gtm.proxibanque.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.domaine.Compte;

/**
 * Cette classe repertorie les methodes des webservices relatifs aux comptes
 * bancaire qui vont chercher des informations en base de données. Ces derniers
 * vont permettre de recuperer un certain nombre de JSON utiles pour la partie
 * front office.
 * 
 * @author HLLRS
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class CompteController extends BaseController{
	@Autowired
	private ICompteDao compteDao;

	/**
	 * Ce webservice permet de retourner la liste des comptes des clients
	 * del'agence. Il ne prend un login en paramètre d'entree
	 * 
	 * @param login
	 * @return List<Compte>, la liste des comptes des clients de l'agence
	 */
	@RequestMapping(value = "comptes", method = RequestMethod.GET, produces = "application/json")
	public List<Compte> getAllAgence() {
		return compteDao.findAll();
	}

	/**
	 * Ce webservice permet de retourner un compte à partir de son numéro
	 * 
	 * @param numero
	 *            : le numero du compte demandé
	 * @return Compte, le compte associé au numéro
	 */
	@RequestMapping(value = "comptes/{numero}", method = RequestMethod.GET, produces = "application/json")
	public Compte getCompteByNumero(@PathVariable("numero") int numero) {
		return compteDao.findByNumero(numero);
	}

	/**
	 * Ce webservice permet de retourner la liste des comptes des clients d'un
	 * conseiller identifie. Il ne prend un login en paramètre d'entree
	 * 
	 * @param login
	 * @return List<Compte>, la liste des comptes des clients associes à un
	 *         conseiller
	 */
	@RequestMapping(value = "conseiller/{login}/comptes", method = RequestMethod.GET, produces = "application/json")
	public List<Compte> getAll(@PathVariable("login") String login) {
		return compteDao.findAllByClient_Conseiller_login(login);
	}

	/**
	 * Ce webservice permet de retourner la liste des comptes d'un client d'un
	 * conseiller identifie. Il ne prend un login de conseiller et un id de client
	 * en paramètres d'entree
	 * 
	 * @param id
	 * @param login
	 * @return List<Compte>, la liste des comptes d'un client associe à un
	 *         conseiller
	 */
	@RequestMapping(value = "conseiller/{login}/comptes/client/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Compte> getById(@PathVariable("id") int id, @PathVariable("login") String login) {

		// Récupération de la liste
		List<Compte> listeComptesClient = compteDao.findByClient_idAndClient_Conseiller_login(id, login);

		// traitement sur la date
		for (Compte compte : listeComptesClient) {
			compte.getDateOuverture();
			System.out.println(compte.getDateOuverture());
		}
		return listeComptesClient;
	}
}
