package fr.gtm.proxibanque.webservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private IConseillerDao conseillerDao;

	@RequestMapping(value = "/loginConseiller", method = RequestMethod.POST, produces = "application/json")
	public String authent(Conseiller cons) {

		String resultat = "NON";

		String passwordInsere = cons.getPassword();
		String loginInsere = cons.getLogin();

		Conseiller cons2 = conseillerDao.findByLogin(loginInsere);

		if (cons2 == null || cons2.getPassword() == null) {
			resultat = "NOK";
		} else {
			if (cons2.getPassword() != null && cons2.getPassword().equals(passwordInsere)) {
				resultat = "OK";
			}
		}

		// Retour de la réponse, un texte.
		return resultat;
	}

}
