/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import modele.Artiste;
import util.JpaUtil;

/**
 *
 * @author VincentB
 */
public class ArtisteDao {

    public ArtisteDao() {
    }

    // BD : persister l'artiste
    public static void create(Artiste artiste) {
        JpaUtil.getEntityManager().persist(artiste);
    }

    // BD : mettre a jour l'artiste (merge)
    public void update(Artiste artiste) {
        JpaUtil.getEntityManager().merge(artiste);
    }

    // BD : retrouver un artiste pas sa PK
    public Artiste findArtiste(int id) {
        Artiste artiste = JpaUtil.getEntityManager().find(Artiste.class, id);
        return artiste;
    }

    // BD : Donne tous les artistes de la BD
    public List<Artiste> findAllArtiste() {
        Query query = JpaUtil.getEntityManager().createQuery("select a from Artiste a");
        return (List<Artiste>) query.getResultList();
    }
}
