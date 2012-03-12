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
public class Peinture extends Oeuvre {
    
    
    private int hauteur;
    private int largeur;

    public Peinture() {
    }

    public Peinture( String nom, int tarifJournalier, String description, int hauteur, int largeur) {
        super(nom, tarifJournalier, description);
        this.hauteur = hauteur;
        this.largeur = largeur;
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
