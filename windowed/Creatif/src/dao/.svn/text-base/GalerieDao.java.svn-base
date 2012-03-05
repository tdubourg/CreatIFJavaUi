package dao;

import java.util.List;
import javax.persistence.Query;
import modele.Galerie;
import util.JpaUtil;

/** @author B3428 */

public class GalerieDao
{
    // Ajout d'une galerie dans la BD
    public void create(Galerie galerie)
    {
        JpaUtil.getEntityManager().persist(galerie);
    }
    
    // Mise à jour d'une galerie dans la BD
    public void update(Galerie galerie)
    {
	JpaUtil.getEntityManager().merge(galerie);
    }
    
    // Suppresion d'une galerie dans la BD
    public void remove (Galerie galerie)
    {
	Galerie gal = JpaUtil.getEntityManager().merge(galerie);
	JpaUtil.getEntityManager().remove(gal);
    }
    
    // Rechercher les galeries contenant l'oeuvre ayant pour identifiant idOeuvre
    public List<Galerie> findByOeuvre(int idOeuvre)
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
                "SELECT galerie "
		+ "FROM Galerie galerie "
		+ "JOIN galerie.oeuvres galOeuvres "
                + "WHERE galOeuvres.idOeuvre = :idO "
		+ "ORDER BY galerie.dateDebut" );
        requete.setParameter("idO", idOeuvre);
        
	return (List<Galerie>) requete.getResultList();
    }

    // Rechercher toutes les galeries d'un client
    public List<Galerie> findByClient(int idClient)
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
                "SELECT galerie "
		+ "FROM Galerie galerie "
		+ "WHERE galerie.client.idClient = :idClient" );
        requete.setParameter("idClient", idClient);

        return (List<Galerie>) requete.getResultList();
    }
    
}