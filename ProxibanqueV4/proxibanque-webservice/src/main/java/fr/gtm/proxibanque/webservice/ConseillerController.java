package fr.gtm.proxibanque.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * @author HLLRS
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class ConseillerController {

	@Autowired
	private IConseillerDao conseillerDao;
	@Autowired
	private IVirementDao virementDao;

	/**
	 * Ce webservice permet de retourner la liste des conseillers de l'agence. Il ne
	 * prend rien en paramètre d'entree
	 * 
	 * @return List<Conseiller>, la liste des conseillers de l'agence
	 */
	@RequestMapping(value = "/listeConseillers", method = RequestMethod.GET, produces = "application/json")
	public List<Conseiller> getAll() {
		return conseillerDao.findAll();
	}

}
