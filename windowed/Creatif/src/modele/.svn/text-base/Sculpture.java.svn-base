package modele;

import javax.persistence.Entity;

/** @author B3428 */

@Entity
public class Sculpture extends Oeuvre
{
    protected float hauteur;
    protected float largeur;
    protected float profondeur;
    protected String matiere;

    public Sculpture()
    {
    }

    public Sculpture(String titre, int tarifJournalier, float hauteur,
			    float largeur, float profondeur, String matiere)
    {
        super(titre, tarifJournalier);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.matiere = matiere;
    }

    public float getHauteur()
    {
        return hauteur;
    }

    public float getLargeur()
    {
        return largeur;
    }

    public String getMatiere()
    {
        return matiere;
    }

    public float getProfondeur()
    {
        return profondeur;
    }

    @Override
    public String toString()
    {
	return super.toString() + "\n\tDetails : " + hauteur + " x "
			    + largeur + " x " + profondeur + " -- " + matiere;
    }
    
}
