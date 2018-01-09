package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.domaine.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IGerantDao extends JpaRepository<Gerant, String>
{
    public Gerant findByLogin(@Param("login") String login);
}
