/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.proxibanque.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Hattmann Belleus
 *
 * La classe employe est une classe abstraite visant a generaliser la fonction des employes susceptibles
 * d'utiliser cette application: le gerant et les conseillers.
 * Les attributs sont:
 * -le login,
 * -le mot de passe,
 * -le nom,
 * -et le prenom.
 *
 * L'employe accedera a l'application grace a son login et son mot de passe et aura acces aux fonctionnalites
 * selon son role.
 *
 * @see Gerant
 * @see Conseiller
 */
@Entity
@Table(name = "EMPLOYE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE")
public abstract class Employe
{

	@Id
	private String login;
	private String password;
	private String prenom;
	private String nom;
	@Transient
	private String role;

	//constructeur
	public Employe()
	{
		super();
	}

	public Employe(String login)
	{
		super();
		this.login = login;
	}

	public Employe(String login, String password, String nom, String prenom)
	{
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	//Getters & Setters
	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getRole()
	{
		return role;
	}

}
