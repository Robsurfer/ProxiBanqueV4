package fr.gtm.proxibanque.domaine;

/**
 * Cette classe permet l'instanciation d'objets Identifiants, qui est l'objet récupéré du Front
 * lors de l'opération d'authentification.
 * @author adminl
 *
 */
public class Identifiants {
	
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
