
package fr.gtm.proxibanque.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Conseiller;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private IConseillerDao conseillerDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Conseiller authent(@RequestBody Conseiller cons) {

		System.out.println(cons);
		Conseiller conseillerAuthentifie = null;

		String passwordInsere = cons.getPassword();
		String loginInsere = cons.getLogin();

		Conseiller consAChercher = conseillerDao.findByLogin(loginInsere);

		if (consAChercher == null) {
			// Aller chercher dans la table des gérants
		} else {
			if (consAChercher.getPassword() != null && consAChercher.getPassword().equals(passwordInsere)) {
				conseillerAuthentifie = consAChercher;
			}
		}

		// Retour de la réponse, un conseiller, null si l'authentification n'est pas
		// acceptée.
		return conseillerAuthentifie;

	}

}
