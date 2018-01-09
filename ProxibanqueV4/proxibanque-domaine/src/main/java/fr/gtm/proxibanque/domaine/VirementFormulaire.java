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
 * Cette classe permettra de récupérer les informations d'un virement sous le format
 * renvoyé par le Front pour le webservice VirementController.
 * On remarque entre autres que contrairement à un objet Virement, on associe à VirementFormulaire
 * un numéro de compte émetteur, et un numéro de compte cible, et non des objets Compte.
 */
public class VirementFormulaire
{


	private int numCompteEmetteur;
	private int numCompteCible;
	private double montant;
	private String libelle;

	//Constructeur
	public VirementFormulaire()
	{
		super();
	}



	public VirementFormulaire(int numCompteEmetteur, int numCompteCible, double montant, String libelle)
	{
		super();
		this.numCompteEmetteur = numCompteEmetteur;
		this.numCompteCible = numCompteCible;
		this.montant = montant;
		this.libelle = libelle;
	}



	public int getNumCompteEmetteur() {
		return numCompteEmetteur;
	}



	public void setNumCompteEmetteur(int numCompteEmetteur) {
		this.numCompteEmetteur = numCompteEmetteur;
	}



	public int getNumCompteCible() {
		return numCompteCible;
	}



	public void setNumCompteCible(int numCompteCible) {
		this.numCompteCible = numCompteCible;
	}



	public double getMontant()
	{
		return montant;
	}

	public void setMontant(double montant)
	{
		this.montant = montant;
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
