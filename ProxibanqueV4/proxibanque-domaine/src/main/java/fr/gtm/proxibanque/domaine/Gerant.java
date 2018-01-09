/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.proxibanque.domaine;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author Loriane & Hattmann
 * Cette classe permettra l'instanciation d'un objet de type Gérant, caract�ris� par ses attributs :
 * - un login, login
 * - un mot de passe, password
 * - un nom
 * - un prenom
 * - listeConseillers, la liste de tous les conseillers de l'agence.
 *
 */
@Entity
@DiscriminatorValue("gerant")
public class Gerant extends Employe
{

	@Transient
	private List<Conseiller> listeConseillers;

	public Gerant()
	{
		super();
		super.setRole("gerant");
	}

	public Gerant(String login)
	{
		super(login);
		super.setRole("gerant");
	}

	public List<Conseiller> getListeConseillers()
	{
		return listeConseillers;
	}

	public void setListeConseillers(List<Conseiller> listeConseillers)
	{
		this.listeConseillers = listeConseillers;
	}

}
