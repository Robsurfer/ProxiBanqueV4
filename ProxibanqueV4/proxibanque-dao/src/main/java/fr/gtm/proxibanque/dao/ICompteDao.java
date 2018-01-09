package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Client;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteDao extends JpaRepository<Compte, Integer>
{
	public Collection<Compte> findByClient(Client client);

	public Compte findByNumero(int numeroCompte);

	public Collection<Compte> findAllByClient_Conseiller(Conseiller conseiller);
}
