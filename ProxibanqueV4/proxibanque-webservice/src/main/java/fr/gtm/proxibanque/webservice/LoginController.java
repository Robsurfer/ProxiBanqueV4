
package fr.gtm.proxibanque.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IEmployeDao;
import fr.gtm.proxibanque.domaine.Employe;
import fr.gtm.proxibanque.domaine.Identifiants;

/**
 * @author Loriane Ce RestController permet la gestion des webservices relatifs
 *         à l'authentification. Il comprend une méthode authent qui est
 *         responsable de l'authentification.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8081" })
public class LoginController {

	@Autowired
	private IEmployeDao employeDao;

	/**
	 * Ce webservice permet l'authentification d'un conseiller ou du gérant sur
	 * l'application. Cette méthode reçoit un employe avec les login et mot de passe
	 * rentrés, puis compare ces données avec les informations de la base de
	 * données. Si les identifiants sont incorrects, la méthode renvoit un employe
	 * null. Sinon, elle renvoit un employe correspondant aux identifiants, avec
	 * toutes ses informations.
	 * 
	 * @param employe,
	 *            un employe avec les identifiants rentrés à analyser
	 * @return employe, l'employé correspondant aux identifiants rentrés, avec
	 *         toutes ses données, ou null si les identifiants n'ont pas été
	 *         reconnus.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Employe authent(@RequestBody Identifiants identifiants) {

		String loginInsere = identifiants.getLogin();
		String passwordInsere = identifiants.getPassword();
		Employe employeAuthentifie = null;

		Employe employeAChercher = employeDao.findEmployeByLogin(loginInsere);

		if (employeAChercher == null) {
			// On n'a pas trouvé d'employé avec ce login. On ne fait rien.
		}

		else {
			if (employeAChercher.getPassword() != null && employeAChercher.getPassword().equals(passwordInsere)) {
				employeAuthentifie = employeAChercher;
			}
		}

		// Retour de la réponse, un employé, null si l'authentification n'est pas
		// acceptée.
		return employeAuthentifie;

	}

}
