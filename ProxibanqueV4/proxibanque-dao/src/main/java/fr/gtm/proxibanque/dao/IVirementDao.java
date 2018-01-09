package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

public interface IVirementDao extends JpaRepository<Virement, Integer>
{

	public Collection<Virement> findAllByConseiller(Conseiller conseiller);

	public Collection<Virement> findAllByCompteEmetteur(Compte compteEmetteur);

	public Collection<Virement> findAllByCompteCible(Compte compteCible);
}
