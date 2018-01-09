package fr.gtm.proxibanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author HLLRS
 *
 *La présente classe SpringJpaApplication constitue une classe de configuration. Elle est nécessaire notamment pour les classes de tests nécessitant 
 *différentes annotations définissant les packages à scanner et une fonction main pour le chargement du contexte.
 *
 *@see SpringBootApplication , @see {@link EnableTransactionManagement}, @see {@link EntityScan}, @see {@link EnableJpaRepositories}
 */

@SpringBootApplication(scanBasePackages="fr.gtm.proxibanque")
@EnableTransactionManagement
@EntityScan("fr.gtm.proxibanque.domaine")
@EnableJpaRepositories(basePackages = {"fr.gtm.proxibanque.dao"})
public class SpringJpaApplication {

	/**
	 * La méthode main permet le chargement du contexte dans le cadre de notre application SpringBoot.
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
}
