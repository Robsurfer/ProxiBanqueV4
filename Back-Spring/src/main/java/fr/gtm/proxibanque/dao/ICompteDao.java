package fr.gtm.proxibanque.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Compte;
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
public interface ICompteDao extends JpaRepository<Compte, Integer> {
	public Collection<Compte> findByClient(Client client);

	public Compte findByNumeroCompte(@Param("numeroCompte") int numeroCompte);

	public List<Compte> findAll();

	public List<Compte> findAllByClient_Conseiller(@Param("conseiller") Conseiller conseiller);
}
