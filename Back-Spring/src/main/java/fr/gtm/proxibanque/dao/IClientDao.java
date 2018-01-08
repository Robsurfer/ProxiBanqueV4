package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;

import fr.gtm.proxibanque.domaine.Client;

/*
 * Spring Data REST se construit à partir de Spring MVC. Il crée une collection
 * de contrôleurs Spring MVC, de convertisseurs JSON et d'autres beans
 * nécessaires pour fournir un front RESTful. Ces composants sont liés au
 * backend JPA Spring Data. En utilisant Spring Boot, tout est autoconfiguré.
 * Détails cf RepositoryRestMvcConfiguration dans Spring Data REST
 */
//@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface IClientDao extends JpaRepository<Client, Integer> {

	public Collection<Client> findByConseiller_login(@Param("login") String login);

	public Client findByIdClient(@Param("id") int id);

	void deleteByIdClient(@Param("id") int id);
}
