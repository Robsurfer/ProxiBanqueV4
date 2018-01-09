package fr.gtm.proxibanque.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.domaine.Compte;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICompteDaoTest {

	@Autowired
    private ICompteDao compteDao;
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(compteDao).isNotNull();
	    }
	 
	 @Test
	    public void findCompte() {
	    	
	    	Collection<Compte> comptes_dao = compteDao.findByClient_id(1);
	    		assertThat(comptes_dao).isNotNull();
	    }
}
