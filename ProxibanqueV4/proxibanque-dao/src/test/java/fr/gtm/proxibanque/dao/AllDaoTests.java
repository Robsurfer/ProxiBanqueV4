package fr.gtm.proxibanque.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.gtm.proxibanque.dao.tests.IClientDaoTest;
import fr.gtm.proxibanque.dao.tests.ICompteDaoTest;
import fr.gtm.proxibanque.dao.tests.IConseillerDaoTest;
import fr.gtm.proxibanque.dao.tests.IEmployeDaoTest;
import fr.gtm.proxibanque.dao.tests.IGerantDaoTest;
import fr.gtm.proxibanque.dao.tests.IVirementDaoTest;

@RunWith(Suite.class)
@SuiteClasses({ IClientDaoTest.class, ICompteDaoTest.class, IConseillerDaoTest.class, IEmployeDaoTest.class,
		IGerantDaoTest.class, IVirementDaoTest.class })
public class AllDaoTests {

}
