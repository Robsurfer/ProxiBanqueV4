package fr.gtm.proxibanque.domaine;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Loriane & Hattmann
 * Cette classe permettra l'instanciation d'un objet de type Conseiller, caract�ris� par ses attributs :
 * - un login, loginCons
 * - un mot de passe, password
 * - un nom, nomCons
 * - un prenom, prenomCons
 * - listeCli, la liste de tous les clients sous sa responsabilit�.
 *
 */
@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Employe
{

	@OneToMany(mappedBy = "conseiller", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private List<Client> listeClients;

	public Conseiller()
	{
		super();
	}

	public Conseiller(String login)
	{
		super(login);
	}

	public List<Client> getListeClients()
	{
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients)
	{
		this.listeClients = listeClients;
	}

	@Override
	public String toString()
	{
		return "Conseiller [Nom=" + getNom() + ", Prenom=" + getPrenom() + "]";
	}

}
