package dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import modele.Oeuvre;
import modele.Peinture;
import modele.Sculpture;
import util.JpaUtil;

/** @author B3428 */

public class OeuvreDao
{
    // Ajout d'une oeuvre dans la BD
    public void create(Oeuvre oeuvre)
    {
        JpaUtil.getEntityManager().persist(oeuvre);
    }
    
    // Rechercher toutes les oeuvres de la BD
    public List<Oeuvre> findAll()
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT oeuvre "
                + "FROM Oeuvre oeuvre "
		+ "ORDER BY oeuvre.artiste.nom" );
        
	return (List<Oeuvre>) requete.getResultList();
    }

    // Rechercher toutes les sculptures de la BD
    public List<Sculpture> findAllSculptures()
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT sculpture "
                + "FROM Sculpture sculpture "
		+ "ORDER BY sculpture.artiste.nom" );
	
        return (List<Sculpture>) requete.getResultList();
    }

    // Rechercher toutes les peintures de la BD
    public List<Peinture> findAllPaintings()
    {
        Query requete = JpaUtil.getEntityManager().createQuery(
		"SELECT peinture "
                + "FROM Peinture peinture "
		+ "ORDER BY peinture.artiste.nom" );
	
        return (List<Peinture>) requete.getResultList();
    }

    // Rechercher les oeuvres disponibles pour une période donnée
    public List<Oeuvre> findAvailable(Calendar dateBegin, Calendar dateEnd)
    {
        String condition = "galerie.dateDebut <= :dateEnd "
			    + "AND galerie.dateFin>=:dateBegin";
        Query requete = JpaUtil.getEntityManager().createQuery(
		"Select oeuvre FROM Oeuvre oeuvre "
                + "WHERE oeuvre.idOeuvre NOT IN "
                + "( SELECT oeuvre2.idOeuvre "
		    + "FROM Galerie galerie JOIN galerie.oeuvres as oeuvre2 "
		    + "WHERE " + condition + ")" );
        requete.setParameter("dateEnd", dateEnd);
        requete.setParameter("dateBegin", dateBegin);
        
	return (List<Oeuvre>) requete.getResultList();
    }

}
