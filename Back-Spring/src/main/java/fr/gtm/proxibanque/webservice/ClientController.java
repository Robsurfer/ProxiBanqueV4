package fr.gtm.proxibanque.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.domaine.Client;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

	@Autowired
	private IClientDao clientDao;

	@RequestMapping(value = "/listeClients", method = RequestMethod.GET, produces = "application/json")
	public Collection<Client> getAll() {
		return clientDao.findAll();
	}

	@RequestMapping(value = "/listeClients/{id}", method = RequestMethod.GET, produces = "application/json")
	public Client getById(@PathVariable("id") int id) {
		return clientDao.findByIdClient(id);
	}
}
