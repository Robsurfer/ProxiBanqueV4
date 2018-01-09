package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeDao extends JpaRepository<Employe, String>
{
	public Employe findEmployeByLogin(String login);
}
