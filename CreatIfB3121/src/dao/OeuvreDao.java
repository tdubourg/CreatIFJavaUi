/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import modele.Oeuvre;
import util.JpaUtil;

/**
 *
 * @author VincentB
 */
public class OeuvreDao {

    public OeuvreDao() {
    }

    // BD : persister une oeuvre
    public static void create(Oeuvre oeuvre) {
        JpaUtil.getEntityManager().persist(oeuvre);
    }

    // BD : merge une oeuvre (MAJ)
    public void update(Oeuvre oeuvre) {
        JpaUtil.getEntityManager().merge(oeuvre);
    }

    // Donne l'oeuvre de la BD correspond à son id (sa PK)
    public Oeuvre findOeuvre(int idOeuvre)
    {   
        Oeuvre oeuvre = JpaUtil.getEntityManager().find(Oeuvre.class, idOeuvre);
        return oeuvre;
    }
    
    // BD : retrouver toutes les oeuvres présentes en BD
    public List<Oeuvre> findAllOeuvre() {

        Query query = JpaUtil.getEntityManager().createQuery("select o from Oeuvre o");
        return (List<Oeuvre>) query.getResultList();

    }
    
    // BD : retrouver toutes les sculptures en BD 
    public List<Oeuvre> findAllSculpture() {

        Query query = JpaUtil.getEntityManager().createQuery("select s from Sculpture s");
        return (List<Oeuvre>) query.getResultList();

    }

    // BD : retrouver toutes les peintures en BD
    public List<Oeuvre> findAllPeinture() {

        Query query = JpaUtil.getEntityManager().createQuery("select p from Peinture p");
        return (List<Oeuvre>) query.getResultList();
    }
    
}
