package fr.gtm.proxibanque.webservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Conseiller;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConseillerController {

	@Autowired
	private IConseillerDao conseillerDao;

	@RequestMapping(value = "/listeConseillers", method = RequestMethod.GET, produces = "application/json")
	public List<Conseiller> getAll() {
		return conseillerDao.findAll();
	}

}
