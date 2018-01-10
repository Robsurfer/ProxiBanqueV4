package fr.gtm.proxibanque.dao.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IGerantDao;
import fr.gtm.proxibanque.domaine.Gerant;

/**
 * 
 * @author adminl
 *
 *La classe IGerantDaoTest contient les tests des méthodes de l'interface IGerantDao. Ces dernières sont récupérées après injection de la dite interface
 * via @Autowired.
 * 
 * @see RunWith, @see {@link SpringBootTest}
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IGerantDaoTest {

	@Autowired
    private IGerantDao gerantDao;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(gerantDao).isNotNull();
    }
	
	@Test
    public void findGerant() {
    	
    	Gerant gerant_dao = gerantDao.findByLogin("gclaude");
    		assertThat(gerant_dao).isNotNull();
    }
}
