package fr.gtm.proxibanque.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * @author adminl Ce RestController gère tous les webservices liés à l'alerte de
 *         clients à découvert. Il permet de retourner des listes de clients à
 *         découvert selon le profil de l'utilisateur.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class DecouvertController extends BaseController{

	@Autowired
	private IConseillerDao conseillerDao;

	@Autowired
	private IClientDao clientDao;

	/**
	 * Ce webservice retourne la liste des clients à découvert pour un conseiller
	 * donné.
	 * 
	 * @param login,
	 *            le login du conseiller
	 * @return une liste de clients à découvert
	 */
	@RequestMapping(value = "conseiller/{login}/decouvert", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getComptesDecouvert(@PathVariable("login") String login) {

		List<Client> listeClientsDecouvert = new ArrayList<>();

		// Récupération du conseiller
		Conseiller conseiller = conseillerDao.findByLogin(login);
		List<Client> listeClientsConseiller = conseiller.getListeClients();

		// On parcourt la liste des clients du conseiller
		for (Client client : listeClientsConseiller) {
			if (client.getCompteCourant() != null && client.getCompteCourant().getSolde() < 0) {
				listeClientsDecouvert.add(client);
			} else if (client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() < 0) {
				listeClientsDecouvert.add(client);
			}
		}

		return listeClientsDecouvert;

	}

	/**
	 * Ce webservice retourne la liste des clients à découvert sur toute l'agence, à
	 * l'intention du gérant.
	 * 
	 * @return la liste de clients à découvert de l'agence
	 */
	@RequestMapping(value = "gerant/decouvert", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getComptesDecouvert() {

		List<Client> listeClientsDecouvert = new ArrayList<>();

		// Récupération de la liste de tous les clients de l'agence
		List<Client> listeClients = clientDao.findAll();

		// On parcourt la liste des clients du conseiller
		for (Client client : listeClients) {
			if (client.getCompteCourant() != null && client.getCompteCourant().getSolde() < 0) {
				listeClientsDecouvert.add(client);
			} else if (client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() < 0) {
				listeClientsDecouvert.add(client);
			}
		}

		return listeClientsDecouvert;

	}

}
