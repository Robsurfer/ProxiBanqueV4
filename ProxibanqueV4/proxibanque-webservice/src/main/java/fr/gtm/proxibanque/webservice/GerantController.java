package fr.gtm.proxibanque.webservice;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Virement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GerantController {
	
	@Autowired
	private IVirementDao virementDao;

	@RequestMapping(value = "/audit", method = RequestMethod.GET, produces = "application/json")
	public List<Virement> Audit(@PathVariable("date1") Date date1, @PathVariable("date2") Date date2) {
		return virementDao.findByDateVirementBeforeAndDateVirementAfter(date1, date2);
	}
	
	//public Collection<Virement> findAllByConseiller_login(String login);
	
	@RequestMapping(value = "conseiller/{login}/virements", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAll(@PathVariable("login") String login) {
		return virementDao.findAllByConseiller_login(login);
	}
}
