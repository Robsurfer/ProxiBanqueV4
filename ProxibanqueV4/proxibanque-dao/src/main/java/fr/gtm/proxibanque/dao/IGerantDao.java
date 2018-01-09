package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGerantDao extends JpaRepository<Gerant, String>
{
    public Gerant findByLogin(@Param("login") String login);
}
