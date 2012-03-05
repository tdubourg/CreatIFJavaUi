package dao;

import java.util.List;
import javax.persistence.Query;
import modele.Client;
import util.JpaUtil;

/** @author B3428 */

public class ClientDao
{
    // Ajout d'un client dans la BD
    public void create(Client client)
    {
        JpaUtil.getEntityManager().persist(client);
    }
    
    // Mise à jour d'un client dans la BD
    public void update(Client client)
    {
	JpaUtil.getEntityManager().merge(client);
    }
    
    // Rechercher tous les clients de la BD
    public List<Client> findAll()
    {
	Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT client "
		+ "FROM Client client "
		+ "ORDER BY client.nom" );
	
	return (List<Client>) requete.getResultList();
    }
    
    // Rechercher un client par son ID
    public static Client findById(int idClient)
    {
	Client client = null;
	Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT client "
		+ "FROM Client client "
		+ "WHERE client.idClient = :idClient" );
	requete.setParameter("idClient", idClient);
	
        try
	{
	    client = (Client) requete.getSingleResult();
	}
	finally
	{
	    return client;
	}
    }

}
