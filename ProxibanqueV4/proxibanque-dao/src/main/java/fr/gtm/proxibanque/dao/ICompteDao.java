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

	public Compte findByNumero(@Param("numero") int numero);

	public List<Compte> findAll();

	public List<Compte> findAllByClient_Conseiller(@Param("conseiller") Conseiller conseiller);
	
	public List<Compte> findAllByClient_Conseiller_login(@Param("login") String login);
	
	public List<Compte> findByClient_idAndClient_Conseiller_login(int id, String login);
	
	//public Client findByIdAndConseiller_login(int id, String login);

}
