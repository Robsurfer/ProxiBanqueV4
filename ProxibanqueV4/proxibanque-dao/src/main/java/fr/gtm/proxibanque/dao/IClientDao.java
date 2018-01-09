package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Client;

public interface IClientDao extends JpaRepository<Client, Integer> {

	public Collection<Client> findByConseiller_login(String login);

	public Client findById(int id);
	
	public Client findByIdAndConseiller_login(int id, String login);

	void deleteById(int id);
}
