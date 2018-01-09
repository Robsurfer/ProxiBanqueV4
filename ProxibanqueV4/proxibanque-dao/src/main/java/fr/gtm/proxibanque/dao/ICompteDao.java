package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Client;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author HLLRS
 * 
 * L'interface ICompteDao hérite de l'interface JpaRepository. En conséquence, une implémentation est automatiquement générée par SpringBoot qui lui 
 * associe un bean disponible dans le conteneur. Les différentes méthodes présentes dans cette classe permettent la manipulation d'instances 
 * de la classe Compte au travers d'un dialogue avec la base de données.
 * 
 * Il est important de noter que les méthodes doivent respecter une convention de nommage afin d'être fonctionnel.
 * ex: findByClient renvoie un compte grâce aux informations du client qu'il a en attribut.
 * 
 * @see JpaRepository
 *
 */

public interface ICompteDao extends JpaRepository<Compte, Integer>
{
	/**
	 * 
	 * La méthode findByClient permet d'obtenir une liste de comptes associée à un client. 
	 * 
	 * @param client, une instance de la classe Client,
	 * @return une collection de comptes
	 */
	
	public Collection<Compte> findByClient(Client client);
	
	/**
	 * 
	 * La méthode findByClient_id renvoie une liste de comptes associée à un client grâce à son id. 
	 * 
	 * @param id du client recherché
	 * @return une collection de comptes
	 */
	
	public Collection<Compte> findByClient_id(int id);

	/**
	 * 
	 * La méthode findByNumero renvoie un compte récupéré en base grâce au numéro de compte associé.
	 * 
	 * @param numero
	 * @return
	 */
	
	public Compte findByNumero(int numero);
	
	/**
	 * La méthode findAll renvoie la liste de tous les comptes de la banque.
	 */

	public List<Compte> findAll();

	/**
	 * 
	 * La méthode findAllByClient_Conseiller permet de récupérer une liste de comptes à partir d'un conseiller et ce, en deux phases:
	 * 
	 * 1. On récupère la liste des clients associées à un conseiller donné,
	 * 2. On récupère la liste des comptes des clients de la précédente liste.
	 * 
	 * @param conseiller
	 * @return liste de comptes
	 */
	
	public List<Compte> findAllByClient_Conseiller(Conseiller conseiller);
	
	/**
	 * 
	 * La méthode findAllByClient_Conseiller permet de récupérer une liste de comptes à partir du login d'un conseiller et ce, en deux phases:
	 * 
	 * 1. On récupère la liste des clients associées à un conseiller donné grâce à son login,
	 * 2. On récupère la liste des comptes des clients de la précédente liste.
	 * 
	 * @param login
	 * @return liste de comptes
	 */
	
	public List<Compte> findAllByClient_Conseiller_login(String login);
	
	/**
	 * 
	 * La méthode findByClient_idAndClient_Conseiller_login permet de faire une requête avec jointure. Elle peut se décomposer en plusieurs phases:
	 * 
	 * 1. On récupère une liste de clients associés à un conseiller grâce à son login,
	 * 2. On recupère un client de la précédente liste grâce à son id,
	 * 3. On récupère la liste de comptes du conseiller précédemment récupéré.
	 * 
	 * De ce fait, la présente méthode considère deux paramètres d'entrée.
	 * 
	 * @param id du client dont on veut les comptes
	 * @param login du conseiller dont on veut la liste de clients
	 * @return une liste de comptes
	 */
	public List<Compte> findByClient_idAndClient_Conseiller_login(int id, String login);
	


}
