package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Client;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteDao extends JpaRepository<Compte, Integer>
{
	public Collection<Compte> findByClient(Client client);
	
	public Collection<Compte> findByClient_id(int id);

	public Compte findByNumero(String numero);

	public List<Compte> findAll();

	public List<Compte> findAllByClient_Conseiller(Conseiller conseiller);
	
	public List<Compte> findAllByClient_Conseiller_login(String login);
}
