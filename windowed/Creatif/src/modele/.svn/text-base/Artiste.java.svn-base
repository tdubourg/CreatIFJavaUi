package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/** @author B3428 */

@Entity
public class Artiste implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idArtiste;
    protected String nom;
    protected String prenom;
    @Column(length=5000)
    protected String description;

    // Met à jour les oeuvres lors de la mise à jour de l'artiste dans la BD
    @OneToMany(mappedBy="artiste", cascade= { CascadeType.MERGE } )
    protected List<Oeuvre> oeuvres = new ArrayList();

    public Artiste()
    {
    }

    public Artiste(String nom, String prenom, String description)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
    }

    public int getIdArtiste()
    {
        return idArtiste;
    }
  
    public String getDescription()
    {
        return description;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public List<Oeuvre> getOeuvres()
    {
	return oeuvres;
    }
    
    public void addOeuvre(Oeuvre oeuvre)
    {
        oeuvres.add(oeuvre);
    }

    @Override
    public String toString()
    {
	return "Artiste n° " + idArtiste + " -- " + prenom + " " + nom 
							+ " -- " + description;
    }
    
    public String toLittleString()
    {
	return "Artiste n° " + idArtiste + " -- " + prenom + " " + nom;
    }

}
