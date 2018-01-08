package fr.proxibanque.proxibanquev4.dao;

import fr.proxibanque.proxibanquev4.domaine.Employe;

public interface IEmployeDao {

	public Employe selectEmploye (Employe employe);
	
	public void getRoleEmploye (Employe employe);
	
	public Employe findEmployeByLogin (String login);
}
