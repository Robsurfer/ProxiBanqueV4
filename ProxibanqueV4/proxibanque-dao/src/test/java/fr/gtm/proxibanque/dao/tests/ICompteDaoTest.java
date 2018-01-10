package fr.gtm.proxibanque.dao.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.domaine.Compte;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICompteDaoTest {

	@Autowired
    private ICompteDao compteDao;
	
	@Autowired
	private IClientDao clientDao;
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(compteDao).isNotNull();
	    }
	 
	 @Test
	    public void findCompteByClient_id() {
	    	
	    	Collection<Compte> comptes_dao = compteDao.findByClient_id(1);
	    		assertThat(comptes_dao).isNotNull();
	    }
	 
	 @Test
	    public void findCompteByClient() {
	    	
	    	Collection<Compte> comptes_dao = compteDao.findByClient(clientDao.findById(1));
	    		assertThat(comptes_dao).isNotNull();
	    }
	 
	 @Test
	    public void findCompteByNumero() {
	    	
	    	Compte compte_dao = compteDao.findByNumero(716562);
	    		assertThat(compte_dao).isNotNull();
	    }
	 
	 @Test
	    public void findAllCompte() {
	    	
		 Collection<Compte> comptes_dao = compteDao.findAll();
	    		assertThat(comptes_dao).isNotNull();
	    }
	 
	 @Test
	    public void findCompteByClient_idAndClient_Conseiller_login() {
	    	
		 List<Compte> comptes_dao = compteDao.findByClient_idAndClient_Conseiller_login(7,"psanchez");
	    		assertThat(comptes_dao).isNotNull();
	    }
}
