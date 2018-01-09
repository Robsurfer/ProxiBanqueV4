package fr.gtm.proxibanque.webservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	@RequestMapping(value = "conseiller/audit/{date1}/{date2}", method = RequestMethod.GET, produces = "application/json")
	public List<Virement> Audit(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
		 DateFormat input = new SimpleDateFormat("ddMMyyyy");
		 DateFormat output = new SimpleDateFormat("dd/MM/yyyy");

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
		
	@RequestMapping(value = "conseiller/{login}/virements", method = RequestMethod.GET, produces = "application/json")
	public Collection<Virement> getAll(@PathVariable("login") String login) {
		return virementDao.findAllByConseiller_login(login);
	}
}
