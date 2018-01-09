package fr.gtm.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Conseiller;


/**
 * 
 * @author HLLRS
 * 
 * L'interface IConseillerDao hérite de l'interface JpaRepository. En conséquence, une implémentation est automatiquement générée par SpringBoot qui lui 
 * associe un bean disponible dans le conteneur. Les différentes méthodes présentes dans cette classe permettent la manipulation d'instances 
 * de la classe Conseiller au travers d'un dialogue avec la base de données.
 * 
 * Il est important de noter que les méthodes doivent respecter une convention de nommage afin d'être fonctionnel.
 * ex: findByLogin renvoie un conseiller grâce à son attribut "login".
 * 
 * @see JpaRepository
 *
 */
public interface IConseillerDao extends JpaRepository<Conseiller, String>
{
	
	/**
	 * 
	 * La méthode findByLogin renvoie un conseiller récupéré en base grâce à son login.
	 * 
	 * @param login
	 * @return un objet Conseiller,
	 */
	public Conseiller findByLogin(String login);
	
	

	/**
	 * La méthode findAll renvoie la liste de tous les conseillers de la banque. Elle est utile au gérant.
	 */
	
	public List<Conseiller> findAll();
}
