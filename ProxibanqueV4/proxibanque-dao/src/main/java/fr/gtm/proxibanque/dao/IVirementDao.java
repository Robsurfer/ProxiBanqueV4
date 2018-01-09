package fr.gtm.proxibanque.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

/**
 * 
 * @author HLLRS
 * 
 * L'interface IVirementDao hérite de l'interface JpaRepository. En conséquence, une implémentation est automatiquement générée par SpringBoot qui lui 
 * associe un bean disponible dans le conteneur. Les différentes méthodes présentes dans cette classe permettent la manipulation d'instances 
 * de la classe Virement au travers d'un dialogue avec la base de données.
 * 
 * Il est important de noter que les méthodes doivent respecter une convention de nommage afin d'être fonctionnel.
 * ex: findAllByConseiller renvoie une liste de virements caractérisés par leur attribut "Conseiller" (ayant réalisé les dits virements).
 * 
 * @see JpaRepository
 *
 */


public interface IVirementDao extends JpaRepository<Virement, Integer>
{

	/**
	 * 
	 * La méthode findAllByConseiller renvoie une liste de virements réalisés par un conseiller donné fourni
	 * en paramètre.
	 * 
	 * @param conseiller
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByConseiller(Conseiller conseiller);
		
	/**
	 * 
	 * La méthode findAllByConseiller_login renvoie une liste de virements réalisés par un conseiller donné et obtenue grâce
	 * au login de ce dernier.
	 * 
	 * @param login
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByConseiller_login(String login);

	
	/**
	 * 
	 * La méthode findAllByCompteEmetteur renvoie une liste de virements associés à un compte émetteur (ie. débiteur).
	 * 
	 * @param compteEmetteur
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByCompteEmetteur(Compte compteEmetteur);
	
	/**
	 * 
	 * La méthode findAllByCompteEmetteur renvoie une liste de virements associés à un compte émetteur (ie. débiteur) 
	 * identifié par son numéro de compte.
	 * 
	 * @param numero
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByCompteEmetteur_numero(String numero);
	
	/**
	 * 
	 * La méthode findAllByCompteCible renvoie une liste de virements associés à un compte cible (ie. créditeur) 
	 * identifié par son numéro de compte.
	 * 
	 * @param numero
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByCompteCible(Compte compteCible);
	
	/**
	 * 
	 * La méthode findAllByCompteCible renvoie une liste de virements associés à un compte cible (ie. débiteur).
	 * 
	 * @param compteCible
	 * @return une liste de virements
	 */
	public Collection<Virement> findAllByCompteCible_numero(String numero);
	
	
	/**
	 * 
	 * La méthode findByDateVirementBeforeAndDateVirementAfter renvoie une liste de virements dont la date de réalisation
	 * se situe entre deux dates fournies en paramètre.
	 * 
	 * @param date1
	 * @param date2
	 * @return une liste de virements réalisée entre ces deux dates
	 */
	
	public List<Virement> findByDateVirementBeforeAndDateVirementAfter(Date date1, Date date2);

}