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
 * Cette classe repertorie les methodes des webservices relatifs au conseiller
 * qui vont chercher des informations en base de données. Ces derniers vont
 * permettre de recuperer un certain nombre de JSON utiles pour la partie front
 * office.
 * 
 * @author HLLRS
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConseillerController {

	@Autowired
	private IConseillerDao conseillerDao;
	@Autowired
	private IVirementDao virementDao;

	/**
	 * Ce webservice permet de retourner la liste des conseillers de l'agence. Il ne
	 * prend rien en paramètre d'entree et renvoit un JSON contenant la liste des
	 * conseillers de l'agence.
	 * 
	 * @return List<Conseiller>, la liste des conseillers de l'agence
	 */
	@RequestMapping(value = "/listeConseillers", method = RequestMethod.GET, produces = "application/json")
	public List<Conseiller> getAll() {
		return conseillerDao.findAll();
	}

	/**
	 * Ce webservice permet de retourner la liste des virements d'un conseiller
	 * donné. Il renvoit donc un JSON contenant la liste des virements associes a un
	 * conseiller
	 * 
	 * @param login
	 *            , l'id du conseiller identifie
	 * @return Collection<Virement>, la liste de tout les virements qu'un conseiller
	 *         a realise
	 */
	@RequestMapping(value = "conseiller/{login}/virements", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAllVir(@PathVariable("login") String login) {
		return virementDao.findAllByConseiller_login(login);
	}
}
