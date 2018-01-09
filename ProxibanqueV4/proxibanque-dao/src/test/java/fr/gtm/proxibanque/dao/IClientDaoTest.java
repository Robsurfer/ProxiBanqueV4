package fr.gtm.proxibanque.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.domaine.Client;

/**
 * 
 * @author HLLR
 * 
 * La classe IClientDaoTest contient les tests des méthodes de l'interface IClientDao. Ces dernières sont récupérées après injection de la dite interface
 * via @Autowired.
 * 
 * @see RunWith, @see {@link SpringBootTest}
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IClientDaoTest {

    @Autowired
    private IClientDao clientDao;

    Client client;
    
    @Before
    public void createClient () {
    	client = new Client (30,"Marc","WELLBERG","rue de Biarritz","13010","AIX-EN-PROVENCE","0312556585","jsmith@hotmail.fr");
    }
    
    @After
    public void eraseClient () {

    	clientDao.delete(client);
    }
    
    @Test
    public void contexLoads() throws Exception {
        assertThat(clientDao).isNotNull();
    }
    
    @Test
    public void findClient() {
    	
    	Client client_dao = clientDao.findById(1);
    		assertThat(client_dao).isNotNull();
    }
    
  
}
