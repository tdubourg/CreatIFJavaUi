package dao;

import java.util.List;
import javax.persistence.Query;
import modele.Artiste;
import util.JpaUtil;

/** @author B3428 */

public class ArtisteDao
{
    // Ajout d'un artiste dans la BD
    public void create(Artiste artiste)
    {
        JpaUtil.getEntityManager().persist(artiste);
    }
    
    // Mise à jour d'un artiste dans la BD
    public void update(Artiste artiste)
    {
	JpaUtil.getEntityManager().merge(artiste);
    }

    // Rechercher tous les artistes de la BD
    public List<Artiste> findAll()
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT artiste "
		+ "FROM Artiste artiste "
		+ "ORDER BY artiste.nom" );
        
	return (List<Artiste>) requete.getResultList();
    }
    
    // Rechercher un artiste par rapport à son ID
    public Artiste findByID(int idArtiste)
    {
	Artiste artiste = null;
        Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT artiste "
		+ "FROM Artiste artiste "
		+ "WHERE artiste.idArtiste = :idArtiste" );
        requete.setParameter("idArtiste", idArtiste);
	
	try
	{
	    artiste = (Artiste) requete.getSingleResult();
	}
	finally
	{
	    return artiste;
	}
    }
    
}
