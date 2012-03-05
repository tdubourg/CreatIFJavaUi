/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author VincentB
 */
@Entity
public class Artiste implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idArtiste;
    
    private String nom;
    private String prenom;
    private int cote;
    private String bio;
    
    @OneToMany( mappedBy = "artiste")
    private List<Oeuvre> listeOeuvre;

    public Artiste() {
    }

    public Artiste(String nom, String prenom, String bio) {
        this.nom = nom;
        this.prenom = prenom;
        this.cote = 0;
        this.bio = bio;
        this.listeOeuvre = new ArrayList<Oeuvre>() {};        
    }
    
    public void addOeuvre (Oeuvre oeuvre){
                
        if(!getListeOeuvre().contains(oeuvre)){ //si lartiste ne contient pas doeuvre
            getListeOeuvre().add(oeuvre); //on l'ajoute
            if(oeuvre.getArtiste()!=null){ //si lartiste de cette oeuvre est different de null
                oeuvre.getArtiste().getListeOeuvre().remove(oeuvre); //on enleve cette oeuvre
            }
            oeuvre.setArtiste(this); //
        }
        
        this.calculCote();
        
    }
    
    public void calculCote(){
        
        if(!this.listeOeuvre.isEmpty())
        {
            this.cote = 0;
            
            for (Oeuvre oeuvre : this.listeOeuvre)
            {
                this.cote = this.cote + oeuvre.getTarifJournalier();
            }
            
            this.cote = this.cote / this.listeOeuvre.size();
        }
    }
    
    

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public int getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(int idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Oeuvre> getListeOeuvre() {
        return listeOeuvre;
    }

    public void setListeOeuvre(List<Oeuvre> listeOeuvre) {
        this.listeOeuvre = listeOeuvre;
    }

    
    //
    //Ceci est un ajout de la part du B3133
    //
    
    @Override
    public String toString()
    {
	return (this.getPrenom() + " " + this.getNom());
    }
    
}
