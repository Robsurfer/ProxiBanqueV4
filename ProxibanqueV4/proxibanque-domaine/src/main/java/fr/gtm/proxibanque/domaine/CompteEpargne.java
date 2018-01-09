package fr.gtm.proxibanque.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Loriane & Hattmann
 * La classe permet l'instanciation d'un objet de type CompteEpargne qui est notamment caract�ris� par un
 * taux de r�mun�ration (par d�faut 3%).
 */
@Entity
@DiscriminatorValue("epargne")
public class CompteEpargne extends Compte
{

	private double taux;

	//Constructeur
	public CompteEpargne()
	{
		super();
		super.setType("epargne");
	}

	public CompteEpargne(int numero)
	{
		super(numero);
		super.setType("epargne");
	}

	public CompteEpargne(int numero, double solde, Date dateOuverture, double taux)
	{
		super(numero, solde, dateOuverture);
		this.taux = taux;
	}

	//Getters & Setters
	public double getTaux()
	{
		return taux;
	}

	public void setTauxRem(double taux)
	{
		this.taux = taux;
	}

}
