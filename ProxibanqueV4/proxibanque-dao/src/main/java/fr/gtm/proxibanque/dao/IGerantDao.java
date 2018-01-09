package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author HLLRS
 * 
 * L'interface IGerantDao hérite de l'interface JpaRepository. En conséquence, une implémentation est automatiquement générée par SpringBoot qui lui 
 * associe un bean disponible dans le conteneur. Les différentes méthodes présentes dans cette classe permettent la manipulation d'instances 
 * de la classe Gerant au travers d'un dialogue avec la base de données.
 * 
 * Il est important de noter que les méthodes doivent respecter une convention de nommage afin d'être fonctionnel.
 * ex: findByLogin renvoie un gérant grâce à son attribut "login".
 * 
 * @see JpaRepository
 *
 */

public interface IGerantDao extends JpaRepository<Gerant, String>
{
	
	/**
	 * 
	 * La méthode findByLogin renvoie un gérant récupéré en base grâce à son login.
	 * 
	 * @param login
	 * @return un objet Gérant,
	 */
	
    public Gerant findByLogin(String login);
}
