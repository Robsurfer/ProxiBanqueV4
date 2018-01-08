package fr.gtm.proxibanque.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lise Rodier
 */
@Entity
public class Virement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "generatorVirement", sequenceName = "seq_virement", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorVirement")
	@Column(name = "ID_VIREMENT")
	private int idVirement;

	private double montant;

	@Column(name = "DATE_VIREMENT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateVirement;
	@JoinColumn(name = "NUM_COMPTE_CREDITEUR", referencedColumnName = "NUMERO_COMPTE")
	@ManyToOne
	private Compte compteCrediteur;
	@JoinColumn(name = "NUM_COMPTE_DEBITEUR", referencedColumnName = "NUMERO_COMPTE")
	@ManyToOne
	private Compte compteDebiteur;

	@JoinColumn(name = "LOGIN_CONSEILLER", referencedColumnName = "LOGIN")
	@ManyToOne
	private Conseiller conseiller;

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public int getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public Virement() {
	}

	public Virement(double montant, Date dateVirement) {
		this.montant = montant;
		this.dateVirement = dateVirement;
	}

	public Virement(double montant, Conseiller conseiller) {
		this.montant = montant;
		this.conseiller = conseiller;
	}

	public Virement(double montant, Date dateVirement, Conseiller conseiller) {
		this.montant = montant;
		this.dateVirement = dateVirement;
		this.conseiller = conseiller;
	}

	@Override
	public String toString() {
		return "Virement{" + "idVirement=" + idVirement + ", montant=" + montant + ", dateVirement=" + dateVirement
				+ ", conseiller=" + conseiller + '}';
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Virement)) {
			return false;
		}
		Virement other = (Virement) object;
		return (this.idVirement == other.idVirement);
	}

}
