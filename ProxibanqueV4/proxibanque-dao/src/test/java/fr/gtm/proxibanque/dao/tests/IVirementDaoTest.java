package fr.gtm.proxibanque.dao.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.ICompteDao;
import fr.gtm.proxibanque.dao.IConseillerDao;
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
	
	@Autowired
    private IConseillerDao conseillerDao;
	
	@Autowired
    private ICompteDao compteDao;
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(virementDao).isNotNull();
	    }
	 
	 @Test
	    public void findAllVirementByConseiller_login() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByConseiller_login("psanchez");
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByConseiller() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByConseiller(conseillerDao.findByLogin("psanchez"));
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByCompteEmetteur() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByCompteEmetteur(compteDao.findByNumero(716562));
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByCompteEmetteur_numero() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByCompteEmetteur_numero(716562);
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByCompteCible() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByCompteCible(compteDao.findByNumero(716562));
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByCompteCible_numero() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findAllByCompteCible_numero(716562);
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findByCompteCible_numeroOrCompteEmetteur_numero() {
	    	
	    	Collection<Virement> virements_dao = virementDao.findByCompteCible_numeroOrCompteEmetteur_numero(716562,716562);
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 @Test
	    public void findVirementByDateVirementBeforeAndDateVirementAfter() throws ParseException {
		 
		 	Date date1 = new Date();
		 	String date_ant = "12/12/2017";
		 	SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy");
		 		Date date2 = output.parse(date_ant);
	    	
	    	List<Virement> virements_dao = virementDao.findByDateVirementBeforeAndDateVirementAfter(date1,date2);
	    		assertThat(virements_dao).isNotNull();
	    }
	 
	 
}
