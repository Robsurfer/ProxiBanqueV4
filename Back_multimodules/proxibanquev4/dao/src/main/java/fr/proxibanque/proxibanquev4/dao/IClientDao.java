package fr.proxibanque.proxibanquev4.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.proxibanque.proxibanquev4.domaine.Client;

public interface IClientDao extends JpaRepository<Client, Integer> {

	public Collection<Client> findByConseiller_login(@Param("login") String login);

	public Client findById(@Param("id") int id);

	void deleteById(@Param("id") int id);
	
}
