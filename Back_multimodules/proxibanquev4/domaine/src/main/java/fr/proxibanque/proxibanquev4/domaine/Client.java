package fr.proxibanque.proxibanquev4.domaine;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Loriane & Hattmann La classe Client est la classe-m�re des classes
 *         ClientEntreprise et ClientService. Un objet Client a pour attributs
 *         une adresse, code postal, ville, un num�ro de t�l�phone, un email et
 *         est reli� � une liste de comptes (CompteCourant, CompteEpargne), et
 *         un Conseiller. Un attribut typeClient permet quant � lui de d�finir
 *         par la suite s'il s'agira d'un client entreprise ou d'un client
 *         particulier.
 */

@Entity
@Table(name = "CLIENT")
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
		@NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c where c.id = :id") })
public class Client {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_generator")
	@SequenceGenerator(name="compte_generator", sequenceName = "sequencecli", initialValue = 17)
	private int id;
	private String nom;
    private String prenom;
	private String adresse;
	@Column(name= "CODE_POSTAL")
	private String codePostal;
	private String ville;
	private String telephone;
	private String mail;
	@JoinColumn(name = "CONSEILLER", referencedColumnName = "LOGIN")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore // Pour éviter les références circulaires
	private Conseiller conseiller;
	@Transient
	private List<Compte> listeComptes;
	@OneToOne(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CompteEpargne compteEpargne;
	@OneToOne(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CompteCourant compteCourant;

	// Constructeurs

	public Client() {
		super();
	}
	
	
	public Client(int id) {
		super();
		this.id = id;
	}


	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
			String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}



	// Getters et setters
	
	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Conseiller getConseiller() {
		return conseiller;
	}


	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}


	public List<Compte> getListeComptes() {
		this.listeComptes = new ArrayList<Compte>();
		this.listeComptes.add(this.compteCourant);
		this.listeComptes.add(this.compteEpargne);
		return listeComptes;
	}


	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}


	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}


	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}


	public CompteCourant getCompteCourant() {
		return compteCourant;
	}


	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	
}
