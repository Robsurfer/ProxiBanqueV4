package fr.gtm.proxibanque.domaine;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * @author Loriane & Hattmann La classe Compte est la classe-m�re des classes
 * CompteCourant et CompteEpargne. Un objet Compte a pour attributs un
 * num�ro de compte, un solde, une date d'ouverture, et est reli� � un
 * Client.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE")
@Table(name = "COMPTE")
public abstract class Compte
{

	@Id
	@SequenceGenerator(name = "generatorCompte", sequenceName = "seq_compte", initialValue = 729000, allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCompte")
	private String numero;
	private float solde;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OUVERTURE")
	private Date dateOuverture;
	@JoinColumn(name = "CLIENT", referencedColumnName = "ID")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Client client;
	@OneToMany(mappedBy = "compteEmetteur", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore // Pour éviter les références circulaires
	private List<Virement> listeVirement;
	@Transient
	@Column(name = "TYPE_COMPTE")
	private String type;

	//Constructeur
	public Compte()
	{
		super();
	}

	public Compte(String numero)
	{
		super();
		this.numero = numero;
	}

	public Compte(String numero, float solde, Date dateOuverture)
	{
		super();
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;

	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public float getSolde()
	{
		return solde;
	}

	public void setSolde(float solde)
	{
		this.solde = solde;
	}

	public Date getDateOuverture()
	{
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture)
	{
		this.dateOuverture = dateOuverture;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public List<Virement> getListeVirement()
	{
		return listeVirement;
	}

	public void setListeVirement(List<Virement> listeVirement)
	{
		this.listeVirement = listeVirement;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

}
