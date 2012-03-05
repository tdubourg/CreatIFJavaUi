package modele;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/** @author B3428 */

@Entity
public class Galerie implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGalerie;
    @Temporal(TemporalType.DATE)
    protected Calendar dateDebut;
    @Temporal(TemporalType.DATE)
    protected Calendar dateFin;
    
    @ManyToOne
    protected Client client;
    @ManyToMany(targetEntity=Oeuvre.class)
    protected List<Oeuvre> oeuvres = new ArrayList<Oeuvre>();
    
    
    public Galerie()
    {
    }

    public Galerie(Calendar dateDebut, Calendar dateFin)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    public int getIdGalerie()
    {
        return idGalerie;
    }

    public Client getClient()
    {
        return client;
    }

    public Calendar getDateDebut()
    {
        return dateDebut;
    }

    public Calendar getDateFin()
    {
        return dateFin;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }
    
    public void addOeuvre(Oeuvre oeuvre)
    {
        oeuvres.add(oeuvre);
    }
    
    public void removeOeuvre(Oeuvre oeuvre)
    {
        oeuvres.remove(oeuvre);
    }

    public List<Oeuvre> getOeuvres()
	{
        return oeuvres;
    }
    
    @Override
    public String toString()
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	return "Galerie n° " + idGalerie + " -- "
		+ dateFormat.format(dateDebut.getTime()) + " a "
		    + dateFormat.format(dateFin.getTime())
	+ " --\n\t" + oeuvres.size() + " oeuvres -- " + client.toLittleString();
    }
    
    public String toLittleString()
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	return "Galerie n° " + idGalerie + " -- "
		+ dateFormat.format(dateDebut.getTime()) + " a "
		    + dateFormat.format(dateFin.getTime());
    }
}
