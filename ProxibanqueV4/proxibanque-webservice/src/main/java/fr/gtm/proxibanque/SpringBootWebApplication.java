package fr.gtm.proxibanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="fr.gtm.proxibanque.dao")
@EntityScan(basePackages="fr.gtm.proxibanque.domaine")
@SpringBootApplication(scanBasePackages = "fr.gtm.proxibanque")
public class SpringBootWebApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
