package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/** @author B3428 */

@Entity
public class Client implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;

    // Met à jour les galeries lors de la mise à jour du client
    @OneToMany(mappedBy="client", cascade= { CascadeType.MERGE } )
    protected List<Galerie> galeries = new ArrayList<Galerie>();


    public Client()
    {
    }

    public Client(String nom, String prenom, String adresse, String telephone)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getIdClient()
    {
	return idClient;
    }

    public String getNom()
    {
	return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }
        
    public String getAdresse()
    {
        return adresse;
    }

    public String getTelephone()
    {
        return telephone;
    }
 
    public void addGallery(Galerie galerie)
    {
        galeries.add(galerie);
    }
    
    public void removeGallery(Galerie galerie)
    {
	galeries.remove(galerie);
    }
    
    @Override
    public String toString()
    {
	return "Client n° " + idClient + " -- " + prenom + " " + nom 
					+ " -- " + adresse + " -- " + telephone;
    }
    
    public String toLittleString()
    {
	return "Client n° " + idClient + " -- " + prenom + " " + nom;
    }
    
}
