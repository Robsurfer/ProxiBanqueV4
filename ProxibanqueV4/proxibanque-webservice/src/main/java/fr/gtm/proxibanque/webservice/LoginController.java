
package fr.gtm.proxibanque.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * @author Loriane Ce RestController permet la gestion des webservices relatifs
 *         à l'authentification. Il comprend une méthode authent qui est
 *         responsable de l'authentification.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private IConseillerDao conseillerDao;

	/**
	 * Ce webservice permet l'authentification d'un conseiller ou du gérant sur
	 * l'application. Cette méthode reçoit un conseiller avec les login et mot de
	 * passe rentrés, puis compare ces données avec les informations de la base de
	 * données. Si les identifiants sont incorrects, la méthode renvoit un
	 * conseiller null. Sinon, elle renvoit un conseiller correspondant aux
	 * identifiants, avec toutes ses informations.
	 * 
	 * @param cons,
	 *            un conseiller avec les identifiants rentrés à analyser
	 * @return cons, le conseiller correspondant aux identifiants rentrés, avec
	 *         toutes ses données, ou null si les identifiants n'ont pas été
	 *         reconnus.
	 */
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
