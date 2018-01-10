package fr.gtm.proxibanque.dao.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * 
 * @author adminl
 *
 *La classe IConseillerDaoTest contient les tests des méthodes de l'interface IConseillerDao. Ces dernières sont récupérées après injection de la dite interface
 * via @Autowired.
 * 
 * @see RunWith, @see {@link SpringBootTest}
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IConseillerDaoTest {

	@Autowired
    private IConseillerDao conseillerDao;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(conseillerDao).isNotNull();
    }
	
	@Test
    public void findConseiller() {
    	
    	Conseiller conseiller_dao = conseillerDao.findByLogin("pierre.sanchez");
    		assertThat(conseiller_dao).isNotNull();
    }
	
	@Test
    public void findAllConseillers() {
    	
    	List<Conseiller> conseillers_dao = conseillerDao.findAll();
    		assertThat(conseillers_dao).isNotNull();
    }
	
}
