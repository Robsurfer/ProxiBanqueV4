package fr.gtm.proxibanque.domaine;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author HLLRS
 * Cette classe hérite de la classe Employe. En particulier, un objet Conseiller détient une liste de clients en attribut.
 * Cela est caractéristique du fait que chaque conseiller est censé géré un liste de clients particuliers lui étant associée.
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
