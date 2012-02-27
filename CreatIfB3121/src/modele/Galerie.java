/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Administrateur
 */
@Entity
public class Galerie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGalerie;
    @ManyToMany
    private List<Oeuvre> listeOeuvre;
    //private int numClient;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRetour;
    @ManyToOne
    private Client client;

    public Galerie() {
    }

    public Galerie(String dateDebut, String dateRetour) {
        this.dateDebut = new Date(dateDebut);
        this.dateRetour = new Date(dateRetour);
        this.listeOeuvre = new ArrayList<Oeuvre>() {
        };
    }

    public Galerie(Date dateDebut, Date dateRetour) {
        this.dateDebut = dateDebut;
        this.dateRetour = dateRetour;
        this.listeOeuvre = new ArrayList<Oeuvre>() {
        };
    }
    
    public Galerie(String jourDebut, String moisDebut, String anneeDebut, String jourFin, String moisFin, String anneeFin) {
        String sdateDebut = "";
        String sdateFin = "";
        sdateDebut = jourDebut + "/" + moisDebut + "/" + anneeDebut;
        sdateFin = jourFin + "/" + moisFin + "/" + anneeFin;        
        this.dateDebut = new Date(sdateDebut);
        this.dateRetour = new Date(sdateFin);
        this.listeOeuvre = new ArrayList<Oeuvre>(){};
    }
    public void addOeuvre(Oeuvre oeuvre) {
        if (!this.getListeOeuvre().contains(oeuvre)) { //si la galerie ne contient pas l'oeuvre
            this.getListeOeuvre().add(oeuvre); //on l'ajoute l'oeuvre a la galerie     
        }

        if (!oeuvre.getListeGalerie().contains(this)) { //si l'oeuvre n'a pas cette galerie 
            oeuvre.getListeGalerie().add(this); //on ajoute cette galerie à l'oeuvre     
        }
    }

    public void RetireOeuvre(Oeuvre oeuvre) {
        getListeOeuvre().remove(oeuvre);
        if (oeuvre.getListeGalerie().contains(this)) {
            int index;
            index = oeuvre.getListeGalerie().indexOf(this);
            oeuvre.getListeGalerie().get(index).RetireOeuvre(oeuvre);
        }
        oeuvre.getListeGalerie().remove(this);

    }


    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getIdGalerie() {
        return idGalerie;
    }

    public void setIdGalerie(int idGalerie) {
        this.idGalerie = idGalerie;
    }

    public List<Oeuvre> getListeOeuvre() {
        return listeOeuvre;
    }

    public void setListeOeuvre(List<Oeuvre> listeOeuvre) {
        this.listeOeuvre = listeOeuvre;
    }

    /*public int getNumClient() {
    return numClient;
    }*/

    /*public void setNumClient(int numClient) {
    this.numClient = numClient;
    }*/
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        //this.numClient = client.getNumClient();
    }
}
