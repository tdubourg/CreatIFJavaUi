/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author VincentB
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Oeuvre implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idOeuvre;
    
    private String nom;
    private int tarifJournalier;

    @ManyToMany(mappedBy = "listeOeuvre", cascade=CascadeType.ALL)
    private List<Galerie> listeGalerie;
    
    @ManyToOne
    private Artiste artiste;
    private String description;

    public Oeuvre() {
    }
    

    public Oeuvre(String nom, int tarifJournalier, String description) {
        this.nom = nom;
        this.tarifJournalier = tarifJournalier;
        this.description = description;
        this.listeGalerie = new ArrayList<Galerie>() {};
    }
    
    

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTarifJournalier() {
        return tarifJournalier;
    }

    public List<Galerie> getListeGalerie() {
        return listeGalerie;
    }
    
    

    public void setTarifJournalier(int tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }
    
    @Override
    public String toString()
    {
	return nom;
    }
    
    
}
