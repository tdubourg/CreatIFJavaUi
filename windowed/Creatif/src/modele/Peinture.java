package modele;

import javax.persistence.Entity;

/** @author B3428 */

@Entity
public class Peinture extends Oeuvre
{
    protected float hauteur;
    protected float largeur;
    protected String type;

    public Peinture()
    {
    }

    public Peinture(String titre, int tarifJournalier,
				  float hauteur, float largeur, String type)
    {
        super(titre, tarifJournalier);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.type = type;
    }

    public float getHauteur()
    {
        return hauteur;
    }

    public float getLargeur()
    {
        return largeur;
    }

    public String getType()
    {
        return type;
    }
    
    @Override
    public String toString()
    {
	return super.toString() + "\n\tDetails : "
			    + hauteur + " x " + largeur + " -- " + type;
    }
    
}
