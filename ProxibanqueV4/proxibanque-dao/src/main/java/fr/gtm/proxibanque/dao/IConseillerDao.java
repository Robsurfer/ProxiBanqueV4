package fr.gtm.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Conseiller;

public interface IConseillerDao extends JpaRepository<Conseiller, String>
{
	public Conseiller findByLogin(String login);
	
	public List<Conseiller> findAll();
}
