package fr.gtm.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.gtm.proxibanque.domaine.Conseiller;

@CrossOrigin(origins = "http://localhost:4200")
/*
 * Spring Data REST se construit à partir de Spring MVC. Il crée une collection
 * de contrôleurs Spring MVC, de convertisseurs JSON et d'autres beans
 * nécessaires pour fournir un front RESTful. Ces composants sont liés au
 * backend JPA Spring Data. En utilisant Spring Boot, tout est autoconfiguré.
 * Détails cf RepositoryRestMvcConfiguration dans Spring Data REST
 */
@RepositoryRestResource
public interface IConseillerDao extends JpaRepository<Conseiller, String> {

	/**
	 * @param login
	 * @return This method returns a object Conseiller. This method has 1 char
	 *         parameter : login. This method gets back from the database a object
	 *         Conseiller linked to the login given in parameter.
	 * @throws fr.gtm.formation.proxibanque.dao.exceptions.DaoException
	 */
	public Conseiller findByLogin(@Param("login") String login);
}
