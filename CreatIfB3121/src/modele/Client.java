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
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int numClient;

    @OneToMany(mappedBy = "client")
    private List<Galerie> listeGalerie;
    
    
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;

    public Client() {
    }

    public Client(String nom, String prenom, String adresse, String numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numTel = numTel;
        this.listeGalerie = new ArrayList<Galerie>() {};
    }

    public void addGalerie(Galerie galerie)
    {
         if(!getListeGalerie().contains(galerie)){ //si le client ne possede pas cette galerie
            getListeGalerie().add(galerie); //on l'ajoute
            if(galerie.getClient()!=null){ //si cette galerie existe deja pour un client
                galerie.getClient().getListeGalerie().remove(galerie);//on supprime la galerie pour permettre le transfert du nouveau client
            }
            galerie.setClient(this);
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Galerie> getListeGalerie() {
        return listeGalerie;
    }
    
    
    
}
