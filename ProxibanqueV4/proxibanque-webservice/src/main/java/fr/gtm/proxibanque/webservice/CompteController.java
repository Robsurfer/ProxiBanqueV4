package fr.gtm.proxibanque.webservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.domaine.Compte;

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

}
