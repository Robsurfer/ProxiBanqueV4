package fr.gtm.proxibanque.webservice;

<<<<<<< HEAD
import java.util.Collection;
=======
import java.util.List;
>>>>>>> WebServices

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.domaine.Compte;

<<<<<<< HEAD
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {
	
	@Autowired
	private ICompteDao compteDao;
	
	@RequestMapping(value = "conseiller/{login}/clients/{id}/comptes", method = RequestMethod.GET, produces="application/json")
	public Collection<Compte> getAll(@PathVariable("id") int id, @PathVariable("login") String login)
	{
		return compteDao.findByClient_id(id);
	}

=======

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {

	@Autowired
	private ICompteDao compteDao;
	
	@RequestMapping(value = "conseiller/{login}/clients/comptes", method = RequestMethod.GET, produces = "application/json")
	public List<Compte> getAll(@PathVariable("login") String login) {
		return compteDao.findAllByClient_Conseiller_login(login);
	}
	
	@RequestMapping(value = "conseiller/{login}/clients/comptes/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Compte> getById(@PathVariable("id") int id, @PathVariable("login") String login) {
		return compteDao.findByClient_idAndClient_Conseiller_login(id, login);
	}
>>>>>>> WebServices
}
