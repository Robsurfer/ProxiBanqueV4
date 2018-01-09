package fr.gtm.proxibanque.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IVirementDao;
import fr.gtm.proxibanque.domaine.Virement;

/**
 * 
 * @author HLLRS
 * 
 * La classe IVirementDaoTest contient les tests des méthodes de l'interface IVirementDao. Ces dernières sont récupérées après injection de la dite interface
 * via @Autowired.
 * 
 * @see RunWith, @see {@link SpringBootTest}
 *
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class IVirementDaoTest {

	@Autowired
    private IVirementDao virementDao;
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(virementDao).isNotNull();
	    }
	 
	 @Test
	    public void findCompte() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByConseiller_login("psanchez");
	    		assertThat(virements_dao).isNotNull();
	    }
}
