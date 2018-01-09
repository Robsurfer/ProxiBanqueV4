package fr.gtm.proxibanque.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gtm.proxibanque.dao.IEmployeDao;
import fr.gtm.proxibanque.domaine.Employe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IEmployeDaoTest {

	@Autowired
    private IEmployeDao employeDao;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(employeDao).isNotNull();
    }
	
	@Test
    public void findEmploye() {
    	
    	Employe employe_dao = employeDao.findEmployeByLogin("rhoareau");
    		assertThat(employe_dao).isNotNull();
    }
}
