package fr.gtm.proxibanque.webservice;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController
{

	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IConseillerDao conseillerDao;
	
	@Autowired
	private ICompteDao compteDao;

	@RequestMapping(value = "conseiller/{login}/clients", method = RequestMethod.GET, produces = "application/json")
	public Collection<Client> getAll(@PathVariable("login") String login) {
		return clientDao.findByConseiller_login(login);
	}

	@RequestMapping(value = "conseiller/{login}/clients/{id}", method = RequestMethod.GET, produces = "application/json")
	public Client getById(@PathVariable("id") int id, @PathVariable("login") String login) {
		return clientDao.findByIdAndConseiller_login(id, login);
	}
	
	@RequestMapping(value = "conseiller/{login}/creationClient", method = RequestMethod.POST, produces = "application/json")
	public Client creerClient(@PathVariable("login") String login, @RequestBody Client client) {
		
		Client clientRetourne = null;
		//try {
			//Attribution du conseiller qui a demandé la création
			Conseiller conseiller = conseillerDao.findByLogin(login);
			client.setConseiller(conseiller);
			
			//Sauvegarde du client
			clientRetourne = clientDao.save(client);			
			
			//Attribution d'un compte courant au client
			Date dateOuverture = new Date();
			CompteCourant cc = new CompteCourant(0,dateOuverture,500);
			cc.setClient(client);
			compteDao.save(cc);
			
			client.setCompteCourant(cc);
			
			//Sauvegarde du client
			clientRetourne = clientDao.save(client);
			
		//} catch (Exception e) {
		//	System.out.println("Erreur lors de la création du client.");
		//	e.printStackTrace();
		//}
		return clientRetourne;
	}
	
}
