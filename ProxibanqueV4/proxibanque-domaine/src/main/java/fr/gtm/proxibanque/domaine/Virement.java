package fr.gtm.proxibanque.domaine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Loriane & Hattmann
 * Cette classe permettra l'instanciation d'un objet de type Virement, caract�ris� par ses attributs :
 * - un conseiller (celui qui a r�alis� le virement)
 * - un compte �metteur
 * - un compte r�cepteur
 * - une date de virement
 * - un libell�
 *
 */
@Entity
public class Virement
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "virement_generator")
	@SequenceGenerator(name = "virement_generator", sequenceName = "sequencevir", initialValue = 1, allocationSize = 1)
	private int id;
	@JoinColumn(name = "CONSEILLER", referencedColumnName = "LOGIN")
	@ManyToOne
	private Conseiller conseiller;
	@JoinColumn(name = "COMPTE_EMETTEUR", referencedColumnName = "NUMERO")
	@ManyToOne
	private Compte compteEmetteur;
	@JoinColumn(name = "COMPTE_CIBLE", referencedColumnName = "NUMERO")
	@ManyToOne
	private Compte compteCible;
	private float montant;
	@Column(name = "DATE_VIREMENT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateVirement;
	private String libelle;

	//Constructeur
	public Virement()
	{
		super();
	}

	public Virement(int id)
	{
		super();
		this.id = id;
	}

	public Virement(Compte compteEmetteur, Compte compteCible, float montant, Date dateVirement, String libelle)
	{
		super();
		this.compteEmetteur = compteEmetteur;
		this.compteCible = compteCible;
		this.montant = montant;
		this.dateVirement = dateVirement;
		this.libelle = libelle;
	}

	public int getId()
	{
		return id;
	}

	public Conseiller getConseiller()
	{
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller)
	{
		this.conseiller = conseiller;
	}

	public Compte getCompteEmetteur()
	{
		return compteEmetteur;
	}

	public void setCompteEmetteur(Compte compteEmetteur)
	{
		this.compteEmetteur = compteEmetteur;
	}

	public Compte getCompteCible()
	{
		return compteCible;
	}

	public void setCompteCible(Compte compteCible)
	{
		this.compteCible = compteCible;
	}

	public float getMontant()
	{
		return montant;
	}

	public void setMontant(float montant)
	{
		this.montant = montant;
	}

	public Date getDateVirement()
	{
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement)
	{
		this.dateVirement = dateVirement;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

}
