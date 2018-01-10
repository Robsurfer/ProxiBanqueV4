package fr.gtm.proxibanque.dao.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

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
    	client = new Client ("Marc","WELLBERG","rue de Biarritz","13010","AIX-EN-PROVENCE","0312556585","jsmith@hotmail.fr");
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
    public void findClientById() {
    	
    	Client client_dao = clientDao.findById(1);
    		assertThat(client_dao).isNotNull();
    }
    
    @Test
    public void findClientByConseiller () {
    	Collection<Client> liste_clients_dao = clientDao.findByConseiller_login("pierre.sanchez");
    	assertThat(liste_clients_dao).isNotNull();
    }
    
    @Test
    public void findByIdAndConseiller_login () {
    	 Client client_dao = clientDao.findByIdAndConseiller_login(7, "psanchez");
    	    assertThat(client_dao).isNotNull();	
    }
  
    @Test
    public void saveClient () {
    	clientDao.save(client);
    	
    }
    
  
}
