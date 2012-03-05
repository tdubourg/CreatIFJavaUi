package modele;

import java.io.Serializable;
import javax.persistence.*;

/** @author B3428 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
// Permet de signifier que les attributs partagés de l'héritage sont
// dans une même table et une table pour chaque classe fille.

public class Oeuvre implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOeuvre;
    protected String titre;
    protected int tarifJournalier;

    @ManyToOne
    protected Artiste artiste;


    public Oeuvre()
    {
    }

    public Oeuvre(String titre, int tarifJournalier)
    {
        this.titre = titre;
        this.tarifJournalier = tarifJournalier;
    }

    public int getIdOeuvre()
    {
        return idOeuvre;
    }

    public int getTarifJournalier()
    {
        return tarifJournalier;
    }

    public String getTitre()
    {
        return titre;
    }

    public Artiste getArtiste()
    {
	return artiste;
    }

    public void setArtist(Artiste artiste)
    {
        this.artiste = artiste;
    }

    @Override
    public String toString()
    {
	return "Oeuvre n° " + idOeuvre + " -- " + titre + " -- " + tarifJournalier 
					+ " $/jour ";
    }
    
    public String toLittleString()
    {
	return "Oeuvre n° " + idOeuvre + " -- " + titre;
    }
    
}
