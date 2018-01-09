package fr.gtm.proxibanque.webservice;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

/**
 * @author HLLRS
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConseillerController {

	@Autowired
	private IConseillerDao conseillerDao;

	/**
	 * Ce webservice permet de retourner la liste des virements de l'agence
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listeConseillers", method = RequestMethod.GET, produces = "application/json")
	public List<Conseiller> getAll() {
		return conseillerDao.findAll();
	}

	@Autowired
	private IVirementDao virementDao;

	/**
	 * Ce webservice permet de retourner la liste des virements d'un conseiller
	 * donné.
	 * 
	 * @param login
	 * @return Collection<Virement>, la liste de tout les virements que le
	 *         conseiller a realise
	 */
	@RequestMapping(value = "conseiller/{login}/virements", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAllVir(@PathVariable("login") String login) {
		return virementDao.findAllByConseiller_login(login);
	}
}
