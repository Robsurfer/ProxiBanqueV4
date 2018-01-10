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

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteCourant;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * @author adminl Ce RestController gère toutes les méthodes des webservices
 *         relatives aux Clients : retourner une liste de clients, modifier un
 *         client, créer un client...
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class ClientController {

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private IConseillerDao conseillerDao;

	@Autowired
	private ICompteDao compteDao;

	/**
	 * Ce webservice permet de retourner la liste des clients d'un conseiller donné.
	 * 
	 * @param login,
	 *            le login du conseiller
	 * @return Collection<Client>, tous les clients du conseiller
	 */
	@RequestMapping(value = "conseiller/{login}/clients", method = RequestMethod.GET, produces = "application/json")
	public Collection<Client> getAll(@PathVariable("login") String login) {
		return clientDao.findByConseiller_login(login);
	}

	/**
	 * Ce webservice permet d'extraire de la base de données un client en
	 * connaissant son id et son conseiller.
	 * 
	 * @param id,
	 *            l'id du client demandé
	 * @param login,
	 *            le login du conseiller à l'origine de la demande
	 * @return Client
	 */
	@RequestMapping(value = "conseiller/{login}/clients/{id}", method = RequestMethod.GET, produces = "application/json")
	public Client getById(@PathVariable("id") int id, @PathVariable("login") String login) {
		return clientDao.findByIdAndConseiller_login(id, login);
	}

	/**
	 * Ce web service reçoit un Client en format JSON, ainsi que le login du
	 * conseiller à l'origine de la requête http (déduit à partir de l'URL). La
	 * méthode ajoute au client reçu un conseiller, ainsi qu'un compte courant
	 * (puisque la création d'un client engendre obligatoirement la création d'un
	 * compte courant), et enfin persiste le tout en base de données.
	 * 
	 * @param login,
	 *            le login du conseiller à l'origine de la demande de création
	 * @param client,
	 *            le client à créer dans la base de données
	 * @return client, le client modifié
	 */
	@RequestMapping(value = "conseiller/{login}/creationClient", method = RequestMethod.POST, produces = "application/json")
	public Client creerClient(@PathVariable("login") String login, @RequestBody Client client) {

		Client clientRetourne = null;

		// Attribution du conseiller qui a demandé la création
		Conseiller conseiller = conseillerDao.findByLogin(login);
		client.setConseiller(conseiller);

		// Sauvegarde du client
		clientRetourne = clientDao.save(client);

		// Attribution d'un compte courant au client
		Date dateOuverture = new Date();
		CompteCourant cc = new CompteCourant(0, dateOuverture, -500);
		cc.setClient(client);
		compteDao.save(cc);

		client.setCompteCourant(cc);

		// Sauvegarde du client
		try {
			clientRetourne = clientDao.save(client);
		} catch (Exception e) {
			System.out.println("Erreur lors de la création du client.");
		}
		return clientRetourne;
	}

	/**
	 * Ce webservice permet de
	 * 
	 * @param login,
	 *            le login du conseiller à l'origine de la modification
	 * @param clientFormulaire,
	 *            le client créé par le Front à partir des données du formulaire
	 * @return Client, le client modifié
	 */
	@RequestMapping(value = "conseiller/{login}/modifClient", method = RequestMethod.POST, produces = "application/json")
	public Client modifClient(@PathVariable("login") String login, @RequestBody Client clientFormulaire) {

		Client client;
		Client clientRetourne = null;

		// Récupération du client
		client = clientDao.findById(clientFormulaire.getId());

		// Set des valeurs
		if (clientFormulaire.getNom() != null) {
			client.setNom(clientFormulaire.getNom());
		}
		if (clientFormulaire.getPrenom() != null) {
			client.setPrenom(clientFormulaire.getPrenom());
		}
		if (clientFormulaire.getAdresse() != null) {
			client.setAdresse(clientFormulaire.getAdresse());
		}
		if (clientFormulaire.getCodePostal() != null) {
			client.setCodePostal(clientFormulaire.getCodePostal());
		}
		if (clientFormulaire.getVille() != null) {
			client.setVille(clientFormulaire.getVille());
		}
		if (clientFormulaire.getMail() != null) {
			client.setMail(clientFormulaire.getMail());
		}
		if (clientFormulaire.getTelephone() != null) {
			client.setTelephone(clientFormulaire.getTelephone());
		}

		// Update du client
		clientRetourne = clientDao.save(client);

		// Sauvegarde du client
		try {
			clientRetourne = clientDao.save(client);
		} catch (Exception e) {
			System.out.println("Erreur lors de la modification du client.");
		}
		return clientRetourne;
	}

}
