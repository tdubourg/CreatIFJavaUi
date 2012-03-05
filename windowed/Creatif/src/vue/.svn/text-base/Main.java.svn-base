package vue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import modele.*;
import service.Service;
import util.*;

public class Main
{
    public static Service service = new Service();

    
    public static void creerOeuvre() throws Exception
    {
	List<Artiste> artistes = service.rechercherTousArtistes();
	for(Artiste artiste : artistes)
        {
	    System.out.println(artiste.toLittleString());
        }
	int ChoixArtiste = Integer.parseInt(Saisie.lireChaine(
							    "ID Artiste : "));
	String nom = Saisie.lireChaine("Titre de l'Oeuvre : ");
	int ChoixOeuvre = Integer.parseInt(Saisie.lireChaine(
			    "Type d'Oeuvre (Peinture = 1 / Sculpture = 2) : "));
	switch (ChoixOeuvre)
	{
	    case 1:
	    {
		try
		{
		    int prix = Integer.parseInt(Saisie.lireChaine(
							"Tarif Journalier : "));
		    int hauteur = Integer.parseInt(Saisie.lireChaine(
							    "Hauteur (cm) : "));
		    int largeur = Integer.parseInt(Saisie.lireChaine(
							    "Largeur (cm) : "));
		    String type = Saisie.lireChaine(
			    "Type de la Peinture (ex : Huile sur Toile) : ");
		    Peinture p = new Peinture(nom, prix, hauteur, largeur, type);
		    for (Artiste a : artistes)
		    {
			if (ChoixArtiste == a.getIdArtiste())
			{
			    service.creerOeuvre(p);
			    service.associerOeuvreArtiste(a, p);
			}
		    }
		}
		catch (NumberFormatException e)
		{
		    System.out.print(
			    "L'argument que vous avez écrit n'est pas valide\n");
		}
		break;
	    }
	    case 2:
	    {
		try
		{
		    int prix = Integer.parseInt(Saisie.lireChaine(
							"Tarif Journalier : "));
		    int hauteur = Integer.parseInt(Saisie.lireChaine(
							    "Hauteur (cm) : "));
		    int largeur = Integer.parseInt(Saisie.lireChaine(
							    "Largeur (cm) : "));
		    int profondeur = Integer.parseInt(Saisie.lireChaine(
							"Profondeur (cm) : "));
		    String type = Saisie.lireChaine(
						"Matiere (ex : Bronze) : ");

		    Sculpture s = new Sculpture(nom, prix, 
				    hauteur, largeur, profondeur, type);

		    for (Artiste a : artistes)
		    {
			if (ChoixArtiste == a.getIdArtiste())
			{
			    service.creerOeuvre(s);
			    service.associerOeuvreArtiste(a, s);
			}
		    }
		}
		catch (NumberFormatException e)
		{
		    System.out.print(
			    "L'argument que vous avez écrit n'est pas valide\n");
		}

		break;
	    }
	}
    }
    
    public static void nouvelleGalerie(Client client)
					    throws ParseException, Exception
    {
        Galerie galerie  = null;
        boolean ajouterOeuvres = true;
        List<Oeuvre> oeuvresDispo = null;
        
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dateDebut = Calendar.getInstance();
        dateDebut.setTime( format.parse( Saisie.lireChaine(
					"Date debut (dd/mm/yyyy) : " ) ) );
        Calendar dateFin = Calendar.getInstance();
        dateFin.setTime( format.parse( Saisie.lireChaine(
					"Date fin (dd/mm/yyyy) : " ) ) );
        
        galerie = new Galerie( dateDebut , dateFin );
	service.creerGalerie(galerie);

        while(ajouterOeuvres)
        {
	    int choix = Integer.parseInt(Saisie.lireChaine(
		    "\n -- Menu Galerie -- \n"
		    + "\t1 : Ajouter une oeuvre \n"
		    + "\t2 : Retirer une oeuvre \n"
		    + "\t3 : Valider la galerie \n"
		    + "\t0 : Annuler la galerie \n"
		    + "Votre Choix : "));

	    switch (choix)
	    {
		case 1:
		{
		    oeuvresDispo = service.rechercherOeuvresDisponibles(
				galerie.getDateDebut(), galerie.getDateFin());
		    for (Oeuvre oeuvre : oeuvresDispo)
		    {
			System.out.println(oeuvre.toLittleString());
		    }
		    int choixOeuvre = Integer.parseInt(Saisie.lireChaine(
						    "ID Oeuvre a ajouter : "));
		    for (Oeuvre oeuvre : oeuvresDispo)
		    {
			if (choixOeuvre == oeuvre.getIdOeuvre())
			{
			    service.ajouterOeuvreAGalerie( oeuvre , galerie );
			}
		    }
		    break;
		}
		case 2:
		{
		    for (Oeuvre oeuvre : galerie.getOeuvres())
		    {
			System.out.println(oeuvre.toLittleString());
		    }
		    int choixOeuvre = Integer.parseInt(Saisie.lireChaine(
						    "ID Oeuvre a retirer : "));
		    Iterator<Oeuvre> it = galerie.getOeuvres().iterator();
		    boolean stop = false;
		    Oeuvre oeuvre;
		    while ( !stop && it.hasNext() )
		    {
			oeuvre = it.next();
			if (choixOeuvre == oeuvre.getIdOeuvre())
			{
			    stop = true;
			    service.retirerOeuvreAGalerie( oeuvre , galerie );
			}
		    }
		    break;
		}
		case 3:
		{
		    service.ajouterGalerieAClient(galerie, client);
		    ajouterOeuvres = false;
		    break;
		}
		case 0:
		{
		    service.supprimerGalerie(galerie);
		    ajouterOeuvres = false;
		    break;
		}
	    }
        }
    }
    
    public static void catalogue() throws Exception
    {
	int idArtiste = -1;
	System.out.println("************************************************");
	System.out.println("\tPeintures");
	System.out.println("************************************************");
        List<Peinture> peintures = service.rechercherToutesPeintures();
        for(Peinture peinture : peintures)
        {
	    if ( idArtiste != peinture.getArtiste().getIdArtiste() )
	    {
		idArtiste = peinture.getArtiste().getIdArtiste();
		System.out.println(peinture.getArtiste().toLittleString()
		    + " -- Cote : " + service.calculerCote(peinture.getArtiste()));
	    }
	    System.out.println("\t" + peinture.toString());
        }
	
	idArtiste = -1;
	System.out.println("\n************************************************");
	System.out.println("\tSculptures");
	System.out.println("************************************************");
	List<Sculpture> sculptures = service.rechercherToutesSculptures();
        for(Sculpture sculpture : sculptures)
        {
	    if ( idArtiste != sculpture.getArtiste().getIdArtiste() )
	    {
		idArtiste = sculpture.getArtiste().getIdArtiste();
		System.out.println(sculpture.getArtiste().toLittleString()
		    + " -- Cote : " + service.calculerCote(sculpture.getArtiste()));
	    }
	    System.out.println("\t" + sculpture.toString());
        }
    }
    
    public static void listeClients()
    {
        List<Client> listeClient = service.rechercherTousClients();
        for(Client client:listeClient)
        {
	    System.out.println(client.toLittleString());
        }
    }
    
    public static void afficherGalerieParOeuvre()
    {
	int idOeuvre = Integer.parseInt(Saisie.lireChaine("ID Oeuvre : "));
        List<Galerie> listeGalerie = service.rechercherGaleriesParOeuvre(idOeuvre);
        for(Galerie galerie:listeGalerie)
        {
            System.out.println(galerie.toLittleString());        
        }
    }
    
    public static void afficherGalerieParClient(int idClient)
    {
	List<Galerie> listeGaleries = 
			    service.rechercherGaleriesParClient(idClient);
	for (Galerie galerie : listeGaleries)
	{
	    System.out.println(galerie.toLittleString());
	}
	int choixGalerie = Integer.parseInt(Saisie.lireChaine(
		"ID Galerie a detailler (0 pour quitter) : "));
	if (choixGalerie != 0)
	{
	    for (Galerie galerie : listeGaleries)
	    {
		if (choixGalerie == galerie.getIdGalerie())
		{
		    for (Oeuvre oeuvre : galerie.getOeuvres())
		    {
			System.out.println(oeuvre.toLittleString());
		    }
		    System.out.println(
			"Total : " + 
			    (long) service.facturerGalerie(galerie) + " $");
		}
	    }
	}
    }

    public static void menuClient() throws Exception
    {
        boolean identifie = false;
        boolean menuClient = true;
	Client leClient = null;

        while(menuClient)
        {
            if (!identifie)
            {
                int idClient = Integer.parseInt(Saisie.lireChaine(
			"\n -- Identification -- \n"
			+ "Votre Identifiant (0 pour quitter) : "));
       
                switch (idClient) 
                {
		    case 0:
                    {
			menuClient=false;
                        break;
                    }
		    default:
                    {
                        leClient=service.identification(idClient);
                        if ( leClient == null )
			{
			    System.out.println("Erreur lors de l'identification : "
				    + "Aucun client trouve pour ID = " + idClient);
			}
			else
			{
			    System.out.println("Identification Reussie : "
					    + "Bienvenue " + leClient.getNom());
			    identifie=true;
			}
                        break;
                    }
                }
            }
            else
            {
                int choix = Integer.parseInt(Saisie.lireChaine(
                    "\n -- Menu Personnel : " + leClient.getPrenom()
					    + " " + leClient.getNom() + " -- \n"
                    + "\t1 : Voir mes galeries \n"
                    + "\t2 : Creer une nouvelle galerie \n"
                    + "\t0 : Quitter \n"
		    + "Votre Choix : "));
                switch (choix) 
                {
		    case 1:
                    {
                        afficherGalerieParClient(leClient.getIdClient());
                        break;
                    }
		    case 2:
                    {
                        nouvelleGalerie(leClient);
                        break;
                    }    
		    case 0:
                    {
                        menuClient=false;
                        break;
                    }
                }   
            }   
        }
    }

    public static void menuAdmin() throws Exception
    {
	boolean menuAdmin = true;
	while (menuAdmin)
	{
	    int choix = Integer.parseInt(Saisie.lireChaine(
		    "\n -- Menu Administrateur -- \n"
		    + "\t1 : Ajouter une Oeuvre \n"
		    + "\t2 : Catalogue \n"
		    + "\t3 : Calendrier d'une oeuvre \n"
		    + "\t4 : Liste des clients \n"
		    + "\t0 : Quitter \n"
		    + "Votre Choix : "));

	    switch (choix)
	    {
		case 1:
		{
		    creerOeuvre();
		    break;
		}
		case 2:
		{
		    catalogue();
		    break;
		}
		case 3:
		{
		    List<Oeuvre> listeOeuvres = service.rechercherToutesOeuvres();
		    for (Oeuvre oeuvre : listeOeuvres)
		    {
			System.out.println(oeuvre.toLittleString());
		    }
		    afficherGalerieParOeuvre();
		    break;
		}
		case 4:
		{
		    listeClients();
		    break;
		}
		case 0:
		{
		    menuAdmin = false;
		    break;
		}
	    }
	}
    }

    public static void menuGeneral() throws Exception
    {
        boolean continuer = true;

        while(continuer)
        {
            int choix = Integer.parseInt(Saisie.lireChaine(
                    "\n -- Menu General -- \n"
                    + "\t1 : Client \n"
                    + "\t2 : Administrateur \n"
                    + "\t0 : Quitter \n"
		    + "Votre Choix : "));
            
	    switch (choix) 
            {
		case 1:
                {
                    menuClient();
                    break;
                }
		case 2:
                {
                    menuAdmin();
                    break;
                }
		case 0:
                {
                    continuer=false;
                    break;
                }
            }           
        }
    }

    public static void main(String[] args)
    {
        try
	{
            service.initBD();
            menuGeneral();
        }
	catch (Exception ex)
	{
            ex.printStackTrace();
        }
    }
    
}
