package fr.proxibanque.proxibanquev4.dao;

import fr.proxibanque.proxibanquev4.domaine.Gerant;

public interface IGerantDao {

	public void setGerant(Gerant gerant);
	
	public Gerant selectGerant ();
	
	public IConseillerDao getConseillerDao();
	
}
