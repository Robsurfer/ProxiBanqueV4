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
 *
 * @author Admin
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
	}

	public Gerant(String login)
	{
		super(login);
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
