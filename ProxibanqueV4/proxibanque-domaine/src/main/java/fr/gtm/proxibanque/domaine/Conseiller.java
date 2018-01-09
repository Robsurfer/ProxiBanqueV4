package fr.gtm.proxibanque.domaine;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Loriane & Hattmann
 * Cette classe permettra l'instanciation d'un objet de type Conseiller, caract�ris� par ses attributs :
 * - un login
 * - un mot de passe
 * - un nom
 * - un prenom
 * - listeCli, la liste de tous les clients sous sa responsabilit�.
 *
 */
@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Employe
{
	@JsonIgnore
	@OneToMany(mappedBy = "conseiller", cascade = CascadeType.REFRESH)
	private List<Client> listeClients;

	public Conseiller()
	{
		super();
		super.setRole("conseiller");
	}

	public Conseiller(String login)
	{
		super(login);
		super.setRole("conseiller");
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
