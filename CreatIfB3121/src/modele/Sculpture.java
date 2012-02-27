/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author VincentB
 */
@Entity
public class Sculpture extends Oeuvre {
    
    private int hauteur;
    private int largeur;
    private int epaisseur;

    public Sculpture() {
    }

    public Sculpture( String nom, int tarifJournalier, String description, int hauteur, int largeur, int epaisseur) {
        super(nom, tarifJournalier, description);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.epaisseur = epaisseur;
    }

    

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    
     
    
    
}
