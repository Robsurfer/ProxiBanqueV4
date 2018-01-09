package fr.proxibanque.proxibanquev4.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * @author Loriane & Hattmann
 * La classe permet l'instanciation d'un objet de type CompteCourant qui est notamment caract�ris� par une
 * autorisation de d�couvert (par d�faut 500�).
 */

@Entity
@DiscriminatorValue ("courant")
public class CompteCourant extends Compte {

	private double decouvert;

	//Constructeur
	
	public CompteCourant() {
		super();
	}

	public CompteCourant(String numero) {
		super(numero);
	}
	
	public CompteCourant(String numero, float solde, Date dateOuverture, double decouvert) {
		super(numero, solde, dateOuverture);
		this.decouvert = decouvert;
	}


	//Getters & Setters
	public double getDecouvert() {
		return decouvert;
	}

	
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	} 
	
	
	

}