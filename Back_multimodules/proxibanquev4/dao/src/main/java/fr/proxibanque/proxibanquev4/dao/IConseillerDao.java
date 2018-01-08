package fr.proxibanque.proxibanquev4.dao;

import java.util.List;

import fr.proxibanque.proxibanquev4.domaine.Conseiller;

public interface IConseillerDao {
	
	public void setConseiller(Conseiller conseiller);
	
	public Conseiller selectConseiller();
	
	public List<Conseiller> selectAllConseiller();

}
