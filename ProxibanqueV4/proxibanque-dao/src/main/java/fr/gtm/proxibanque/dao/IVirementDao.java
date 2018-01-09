package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

public interface IVirementDao extends JpaRepository<Virement, Integer>
{

	public Collection<Virement> findAllByConseiller(Conseiller conseiller);
		
	public Collection<Virement> findAllByConseiller_login(@Param("login") String login);

	public Collection<Virement> findAllByCompteEmetteur(@Param("compteEmetteur") Compte compteEmetteur);
	
	public Collection<Virement> findAllByCompteEmetteur_numero(@Param("numero") String numero);

	public Collection<Virement> findAllByCompteCible(@Param("compteCible") Compte compteCible);
	
	public Collection<Virement> findAllByCompteCible_numero(@Param("numero") String numero);
}
