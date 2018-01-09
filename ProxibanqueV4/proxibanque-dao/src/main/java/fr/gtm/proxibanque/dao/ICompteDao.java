package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Client;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ICompteDao extends JpaRepository<Compte, Integer>
{
	public Collection<Compte> findByClient(@Param("client")Client client);
	
	public Collection<Compte> findByClient_id(@Param("id")int id);

	public Compte findByNumero(@Param("numero") String numero);

	public List<Compte> findAll();

	public List<Compte> findAllByClient_Conseiller(@Param("conseiller") Conseiller conseiller);
	
	public List<Compte> findAllByClient_Conseiller_login(@Param("login") String login);
}
