package fr.proxibanque.proxibanquev4.dao;

import java.util.List;

import fr.proxibanque.proxibanquev4.domaine.Compte;

public interface ICompteDao {

	public Compte createCompte(Compte compte);
	
	public Compte updateCompte(Compte compte);
	
	public Compte selectCompte(Compte compte);
	
	public void deleteCompte(Compte compte);
	
	public List<Compte> selectAllComptes();
	
	public Compte selectCompteByNumCompte(String numCompte);
	
	
	
}
