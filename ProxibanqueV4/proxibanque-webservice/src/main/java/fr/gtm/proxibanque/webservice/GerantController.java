package fr.gtm.proxibanque.webservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Virement;

/**
 * Cette classe repertorie les methodes des webservices relatifs au gerant
 * permettant l'audit de l'agence: recuperer la synthèse des virements effectues
 * au sein de l'agence et afficher la liste des conseillers de l'agence. Ils
 * seront integrés au front office.
 * 
 * @author HLLRS
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class GerantController {

	@Autowired
	private IVirementDao virementDao;

	/**
	 * Ce webservice permet de retourner la liste des virements de l'agence. Il
	 * prend en parametres d'entree des dates et produit un JSON contenant la liste
	 * des virements pour une periode definie
	 * 
	 * @param date1,
	 *            date la plus récente de l'intervalle de recherche
	 * @param date2,
	 *            date la plus ancienne de l'intervalle de recherche
	 * @return List<Virement>, la liste des virements de l'agence observable par le
	 *         gerant entre deux dates
	 */
	@RequestMapping(value = "gerant/audit/{date1}/{date2}", method = RequestMethod.GET, produces = "application/json")
	public List<Virement> Audit(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
		DateFormat input = new SimpleDateFormat("ddMMyyyy");

		Date dateForm1 = new Date();
		Date dateForm2 = new Date();
		try {

			dateForm1 = input.parse(date1);
			dateForm2 = input.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return virementDao.findByDateVirementBeforeAndDateVirementAfter(dateForm1, dateForm2);
	}

}
