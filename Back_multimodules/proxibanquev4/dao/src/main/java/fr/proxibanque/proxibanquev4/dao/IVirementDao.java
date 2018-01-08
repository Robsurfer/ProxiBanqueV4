package fr.proxibanque.proxibanquev4.dao;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.proxibanque.proxibanquev4.domaine.Compte;
import fr.proxibanque.proxibanquev4.domaine.Conseiller;
import fr.proxibanque.proxibanquev4.domaine.Virement;

public interface IVirementDao extends JpaRepository<Virement, Integer>{

	public Collection<Virement> findAllByConseiller(@Param("conseiller") Conseiller conseiller);

	public Collection<Virement> findAllByCompteDebiteur(@Param("compteDebiteur") Compte compteDebiteur);

	public Collection<Virement> findAllByCompteCrediteur(@Param("compteCrediteur") Compte compteCrediteur);
}
