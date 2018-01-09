package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Client;

/**
 * 
 * @author HLLRS
 * 
 * L'interface IClientDao hérite de l'interface JpaRepository. En conséquence, une implémentation est automatiquement générée par SpringBoot qui lui 
 * associe un bean disponible dans le conteneur. Les différentes méthodes présentes dans cette classe permettent la manipulation d'instances 
 * de la classe Client au travers d'un dialogue avec la base de données.
 * 
 * Il est important de noter que les méthodes doivent respecter une convention de nommage afin d'être fonctionnel.
 * ex: findByConseiller renvoie un client grâce aux informations du conseiller qu'il a en attribut.
 * 
 * @see JpaRepository
 *
 */

public interface IClientDao extends JpaRepository<Client, Integer> {
	
	/**
	 * La méthode findByConseiller_login permet de récupérer de la base une liste de clients associée à un conseiller et ce, grâce à son login.
	 * 
	 * @param login du conseiller
	 * @return une liste d'objets Client
	 */

	public Collection<Client> findByConseiller_login(String login);

	/**
	 * 
	 * La méthode findById permet d'obtenir un client présent en base grâce à son id.
	 * 
	 * @param id
	 * @return un objet Client
	 */
	
	public Client findById(int id);
	
	/**
	 * 
	 * La méthode findByIdAndConseiller_login permet de faire une requête avec jointure. Elle peut se décomposer en deux phases:
	 * 
	 * 1. On récupère une liste de clients associés à un conseiller grâce à son login,
	 * 2. On recupère un client de la précédente liste grâce à son id.
	 * 
	 * De ce fait, la présente méthode considère deux paramètres d'entrée.
	 * 
	 * @param id
	 * @param login
	 * @return un objet Client
	 */
	
	public Client findByIdAndConseiller_login(int id, String login);

	/**
	 * La méthode deleteById permet de supprimer un client de la base grâce à son id.
	 * @param id
	 */
	
	void deleteById(int id);
}
