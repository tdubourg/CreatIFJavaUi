/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modele.Galerie;
import util.JpaUtil;

/**
 *
 * @author brize
 */
public class GalerieDao {

    public GalerieDao() {
    }

    // BD : persiste la galerie dans la BD
    public static void create(Galerie galerie)
    {
        JpaUtil.getEntityManager().persist(galerie);
    }
    
    // BD : MAJ de la galerie dans la BD via merge
    public void update(Galerie galerie)
    {
       JpaUtil.getEntityManager().merge(galerie); 
    }
    
    // BD : trouve la galerie dans la BD correspondant à son id
     public Galerie findGalerie(int id) {
        Galerie galerie = JpaUtil.getEntityManager().find(Galerie.class, id);
        return galerie;
    }

    
}
