package service;

import dao.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import modele.*;
import util.JpaUtil;

/**
 *
 * @author B3428
 */

public class Service
{

    protected ArtisteDao artisteDao;
    protected ClientDao clientDao;
    protected OeuvreDao oeuvreDao;
    protected GalerieDao galerieDao;


    // Constructeur
    public Service()
    {
        artisteDao = new ArtisteDao();
        clientDao = new ClientDao();
        oeuvreDao = new OeuvreDao();
        galerieDao = new GalerieDao();
    }
    
    // Initialisation de la Base de Données
    public void initBD() throws Exception
    {
	/* Ajout des artistes */
	Artiste dali = new Artiste( "DALI" , "Salvador" ,
		"Salvador Domingo Felipe Jacinto Dalí i Domènech, "
		+ "1er marquis de Púbol, connu sous le nom de Salvador Dalí, "
		+ "est un peintre, sculpteur et scénariste surréaliste espagnol,"
		+ " né le 11 mai 1904 et mort le 23 janvier 1989. Il est né et "
		+ "mort à Figuières, en Catalogne, où il a créé son propre "
		+ "musée en 1974, le Teatre-Museu Gala Salvador Dalí.");
	Artiste delacroix = new Artiste( "DELACROIX" , "Eugène" ,
		"Ferdinand-Victor-Eugène Delacroix, né le 26 avril 1798 à "
		+ "Charenton-Saint-Maurice (Seine), mort le 13 août 1863 à Paris, "
		+ "est un peintre majeur du romantisme en peinture, "
		+ "apparu au début du XIXe siècle, en France." );
	Artiste devinci = new Artiste( "DE VINCI" , "Leonard",
		"Léonard de Vinci (Leonardo di ser Piero da VinciLeonardo di ser"
		+ "Piero da Vinci, dit Leonardo da VinciNote), né à Vinci le "
		+ "15 avril 1452 et mort à Amboise le 2 mai 1519, "
		+ "est un peintre italien et un homme d'esprit universel, "
		+ "à la fois artiste, scientifique, ingénieur, inventeur, "
		+ "anatomiste, peintre, sculpteur, architecte, urbaniste, "
		+ "botaniste, musicien, poète, philosophe et écrivain." );
	Artiste matisse = new Artiste( "MATISSE" , "Henri" ,
		"Il s'épanouit dans cette atmosphère chaleureuse et libérale "
		+ "tout en procédant avec patience et méthode, faisant des "
		+ "copies au Louvre et des exercices sur nature, recherchant "
		+ "la maïtrise des valeurs avant la conquête de la couleur. "
		+ "Tandis qu'il expose aux Salons de la Nationale (1896-1897) "
		+ "des compositions encore sombres et timides, il passe deux "
		+ "étés successifs à Belle-Ile, reçu par John Russell, ami de "
		+ "Van Gogh et des-impressionnistes, qui le met en contact "
		+ "avec Rodin et Pissaro." );
	Artiste picasso = new Artiste( "PICASSO", "Pablo",
		"Pablo Ruiz Picasso, né à Málaga, Espagne, le 25 octobre 1881 et"
		+ " mort le 8 avril 1973 à Mougins, France, est un peintre, "
		+ "dessinateur et sculpteur espagnol ayant passé l'essentiel "
		+ "de sa vie en France. Artiste utilisant tous les supports "
		+ "pour son travail, il est considéré comme le fondateur du "
		+ "cubisme avec Georges Braque et un compagnon d'art du "
		+ "surréalisme. Il est l'un des plus importants artistes du XXe "
		+ "siècle, tant par ses apports techniques et formels que par "
		+ "ses prises de positions politiques. Il a produit 50 000 "
		+ "oeuvres dont environ 8 000 tableaux.");
	Artiste rodin = new Artiste( "RODIN" , "Auguste" , 
		"Auguste Rodin (François-Auguste-René Rodin), né à Paris le 12 "
		+ "novembre 1840 et mort à Meudon le 17 novembre 1917, "
		+ "est l'un des plus importants sculpteurs français de la "
		+ "seconde moitié du XIXe siècle." );
	
	creerArtiste( dali );
	creerArtiste( devinci );
	creerArtiste( delacroix );
	creerArtiste( matisse );
	creerArtiste( picasso );
	creerArtiste( rodin );
	
	/* Ajout des oeuvres */
	    /* Ajout des peintures */
	Peinture bacchus = new Peinture( "Bacchus", 3000 ,
					    177 , 115 , "Huile sur bois");
	Peinture joconde = new Peinture( "La Jocconde (Mona Lisa)" , 50000 ,
			    77 , 53 , "Huile sur panneau de bois de peuplier");
	Peinture desserte = new Peinture( "La Desserte Rouge" , 12000 ,
					    180, 220, "Huile sur toile");
	Peinture danse = new Peinture( "La Danse" , 20000 ,
					    260, 391, "Huile sur toile");
	Peinture guitare = new Peinture( "Man with a Guitar" , 10000 ,
				130 , 89 , "Huile et encaustique sur toile");
	Peinture arlequin = new Peinture( "Arlequin" , 5000 ,
					    116 , 90 , "Huile sur toile");
	Peinture violon = new Peinture( "Le Violon" , 8000 ,
					    75 , 81 , "Huile sur toile");
	Peinture guernica = new Peinture( "Guernica" , 13000 , 
					    351 , 782 , "Huile sur toile");
	Peinture liberte = new Peinture ( 
			    "La Liberté Guidant le Peuple" , 22000 , 
					    260 , 325 , "Huile sur toile");
	Peinture voyageur = new Peinture ( 
			    "Le Voyageur au-dessus de la Mer de Nuage" , 18000 , 
					    98.4f , 78.8f , "Huile sur toile");
	
	creerOeuvre( bacchus );
	creerOeuvre( joconde );
	creerOeuvre( desserte );
	creerOeuvre( danse );
	creerOeuvre( guitare );
	creerOeuvre( arlequin );
	creerOeuvre( violon );
	creerOeuvre( guernica );
	creerOeuvre( liberte );
	creerOeuvre( voyageur );
	
	    /* Ajout des sculptures */
	Sculpture alice = new Sculpture( "Alice au Pays des Merveilles", 10000 ,
					    50, 20, 10, "Bronze" );
	Sculpture rhino = new Sculpture( "Rhinoceros" , 5000 ,
					    200 , 400 , 200, "Bronze");
	Sculpture cheval = new Sculpture( "Cheval de Leonard" , 15000 ,
					    300 , 400 , 100, "Bronze");
	Sculpture chicago = new Sculpture( "Sculpture in Chicago" , 12000 ,
					    1520 , 200 , 200 , "Acier");
	Sculpture femme = new Sculpture( "Tete de Femme" , 8000 ,
					    128.5f , 54.5f , 62.5f , "Platre");
	Sculpture jb = new Sculpture( "Saint Jean Baptiste" , 20000 , 
					    200 , 63 , 40 , "Bronze");
	Sculpture penseur = new Sculpture( "Le Penseur" , 17000 , 
					    204 , 130 , 140 , "Bronze");
	
	creerOeuvre( alice );
	creerOeuvre( rhino );
	creerOeuvre( cheval );
	creerOeuvre( chicago );
	creerOeuvre( femme );
	creerOeuvre( jb );
	creerOeuvre( penseur );
	
	/* Association artistes-oeuvres */
	associerOeuvreArtiste( dali , alice );
	associerOeuvreArtiste( dali , rhino );
	associerOeuvreArtiste( delacroix , liberte );
	associerOeuvreArtiste( delacroix , voyageur );
	associerOeuvreArtiste( devinci , bacchus );
	associerOeuvreArtiste( devinci , joconde );
	associerOeuvreArtiste( devinci , cheval );
	associerOeuvreArtiste( matisse , desserte );
	associerOeuvreArtiste( matisse , danse );
	associerOeuvreArtiste( picasso , guitare );
	associerOeuvreArtiste( picasso , arlequin );
	associerOeuvreArtiste( picasso , chicago );
	associerOeuvreArtiste( picasso , femme );
	associerOeuvreArtiste( picasso , violon );
	associerOeuvreArtiste( picasso , guernica );
	associerOeuvreArtiste( rodin , jb );
	associerOeuvreArtiste( rodin , penseur );
	
	/* Ajout des clients */
	Client ermitage = new Client("L ERMITAGE", "Musee",
					"Russie", "06-70-77-00-77");
	Client louvre = new Client("LOUVRE", "Le",
					"Paris", "06-60-66-00-66");
	Client rijksmuseum = new Client("RIJKSMUSEUM", "Musee",
					    "Amsterdam", "06-80-88-00-88");
	
	creerClient( ermitage );
	creerClient( louvre );
	creerClient( rijksmuseum );
	
	/* Ajout des galeries */
	Calendar ermitageDebut = Calendar.getInstance();
        ermitageDebut.set(2012, Calendar.JANUARY, 1);
        Calendar ermitageFin = Calendar.getInstance();
        ermitageFin.set(2012, Calendar.FEBRUARY, 28);
	Galerie galerieErmitage = new Galerie( ermitageDebut , ermitageFin );
	
	Calendar ermitageDebut2 = Calendar.getInstance();
        ermitageDebut2.set(2012, Calendar.MARCH, 31);
        Calendar ermitageFin2 = Calendar.getInstance();
        ermitageFin2.set(2012, Calendar.MAY, 1);
	Galerie galerie2Ermitage = new Galerie( ermitageDebut2 , ermitageFin2 );
	
	Calendar louvreDebut = Calendar.getInstance();
        louvreDebut.set(2011, Calendar.DECEMBER, 1);
        Calendar louvreFin = Calendar.getInstance();
        louvreFin.set(2012, Calendar.APRIL, 30);
	Galerie galerieLouvre = new Galerie( louvreDebut , louvreFin );
	
	Calendar rijkDebut = Calendar.getInstance();
        rijkDebut.set(2012, Calendar.MAY, 1);
        Calendar rijkFin = Calendar.getInstance();
        rijkFin.set(2012, Calendar.JULY, 30);
	Galerie galerieRijk = new Galerie( rijkDebut , rijkFin );
	
	creerGalerie( galerieErmitage );
	creerGalerie( galerie2Ermitage );
	creerGalerie( galerieLouvre );
	creerGalerie( galerieRijk );
	
	/* Assoication clients-galerie */
	ajouterGalerieAClient( galerieErmitage , ermitage );
	ajouterGalerieAClient( galerie2Ermitage , ermitage );
	ajouterGalerieAClient( galerieLouvre , louvre );
	ajouterGalerieAClient( galerieRijk , rijksmuseum );
	
	/* Assoication galerie-oeuvre */
	ajouterOeuvreAGalerie( chicago , galerieErmitage );
	ajouterOeuvreAGalerie( femme , galerieErmitage );
	ajouterOeuvreAGalerie( joconde , galerieErmitage );
	ajouterOeuvreAGalerie( arlequin , galerieErmitage );
	ajouterOeuvreAGalerie( jb , galerieErmitage );
	
	ajouterOeuvreAGalerie( violon , galerie2Ermitage );
	ajouterOeuvreAGalerie( alice , galerie2Ermitage );
	ajouterOeuvreAGalerie( rhino , galerie2Ermitage );
	
	ajouterOeuvreAGalerie( bacchus , galerieLouvre );
	ajouterOeuvreAGalerie( joconde , galerieLouvre );
	ajouterOeuvreAGalerie( desserte , galerieLouvre );
	ajouterOeuvreAGalerie( danse , galerieLouvre );
	ajouterOeuvreAGalerie( guitare , galerieLouvre );
	ajouterOeuvreAGalerie( arlequin , galerieLouvre );
	ajouterOeuvreAGalerie( violon , galerieLouvre );
	ajouterOeuvreAGalerie( alice , galerieLouvre );
	ajouterOeuvreAGalerie( rhino , galerieLouvre );
	ajouterOeuvreAGalerie( cheval , galerieLouvre );
	
	ajouterOeuvreAGalerie( liberte , galerieRijk );
	ajouterOeuvreAGalerie( voyageur , galerieRijk );
	ajouterOeuvreAGalerie( penseur , galerieRijk );
    }

    /* SERVICES LIES A ARTISTE */
    // Création d'un artiste
    public void creerArtiste(Artiste artiste) throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

        try
        {
            transaction.begin();
            artisteDao.create(artiste);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println("*** Erreur lors de la création d'un artiste ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Recherche l'ensemble des artistes de la BD
    public List<Artiste> rechercherTousArtistes()
    {
        JpaUtil.openEntityManager();
        List<Artiste> artistes = artisteDao.findAll();
        JpaUtil.closeEntityManager();
        
	return artistes;
    }
    
    // Recherche un artiste par son ID
    public Artiste rechercherArtisteParID(int idArtiste)
    {
        JpaUtil.openEntityManager();
        Artiste artiste = artisteDao.findByID(idArtiste);
        JpaUtil.closeEntityManager();
        
	return artiste;
    }
    
    // Lie une oeuvre à un artiste
    public void associerOeuvreArtiste(Artiste artiste, Oeuvre oeuvre)
							    throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

	// Lien bidirectionnel mis à jour au niveau application
	artiste.addOeuvre(oeuvre);
	oeuvre.setArtist(artiste);
        
	// Lien mis à jour au niveau BD
	try
        {
            transaction.begin();
            artisteDao.update(artiste);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println("*** Erreur lors de l'association "
					+ "d'un artiste et d'une oeuvre ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Calcule la cote d'un artiste
    public float calculerCote(Artiste artiste) throws Exception
    {
	JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();
	float cote = -1;
        
	// Mise à jour depuis la BD
	try
        {
	    int idArtiste = artiste.getIdArtiste();
            transaction.begin();
            artiste = artisteDao.findByID(idArtiste);
            transaction.commit();
	    
	    if (artiste != null)
	    {
		Iterator<Oeuvre> it = artiste.getOeuvres().iterator();
		int i;
		cote = 0;
		for (i = 1; it.hasNext(); i++)
		{
		    cote += it.next().getTarifJournalier();
		}
		cote = cote / i;
	    }
	    else
	    {
		System.out.println("*** Erreur lors du calcul de la cote "
			+ "d'un artiste : l'artiste n° " + idArtiste 
			+ " n'est pas présent dans la BD ***");
	    }
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors du calcul de la cote d'un artiste ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }

	return cote;
    }
    
    /* SERVICES LIES A OEUVRE */
    // Création d'une oeuvre
    public void creerOeuvre(Oeuvre oeuvre) throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

        try
        {
            transaction.begin();
            oeuvreDao.create(oeuvre);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println("*** Erreur lors de la création d'une oeuvre ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }

    // Recherche l'ensemble des oeuvres de la BD
    public List<Oeuvre> rechercherToutesOeuvres() 
    {   
        JpaUtil.openEntityManager();
        List<Oeuvre> oeuvres = oeuvreDao.findAll();
        JpaUtil.closeEntityManager();
        
	return oeuvres;
    }

    // Recherche l'ensemble des peintures de la BD
    public List<Peinture> rechercherToutesPeintures()
    {
        JpaUtil.openEntityManager();
        List<Peinture> peintures = oeuvreDao.findAllPaintings();
        JpaUtil.closeEntityManager();
        
	return peintures;
    }

    // Recherche l'ensemble des sculptures de la BD
    public List<Sculpture> rechercherToutesSculptures()
    {
        JpaUtil.openEntityManager();
        List<Sculpture> sculptures = oeuvreDao.findAllSculptures();
        JpaUtil.closeEntityManager();
        
	return sculptures;
    }

    // Recherche les oeuvres disponibles pour une période donnée
    public List<Oeuvre> rechercherOeuvresDisponibles(
					Calendar dateDebut, Calendar dateFin)
    {
        JpaUtil.openEntityManager();
        List<Oeuvre> oeuvres = oeuvreDao.findAvailable(dateDebut, dateFin);
        JpaUtil.closeEntityManager();
        
	return oeuvres;
    }
    
    // Calcule le cout d'une oeuvre pour une période donnée
    protected float facturerOeuvre(Oeuvre oeuvre, 
					Calendar dateDebut, Calendar dateFin)
    {
	float facture = 0;

	long diffMillis = dateFin.getTimeInMillis() - dateDebut.getTimeInMillis();
        int diffJours = (int) (diffMillis / (24*60*60*1000));
	
	facture = diffJours * oeuvre.getTarifJournalier();
	
	return facture;
    }
    
    /* SERVICES LIES A CLIENT */
    // Création d'un client
    public void creerClient(Client client) throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

        try
        {
            transaction.begin();
            clientDao.create(client);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println("*** Erreur lors de la création d'un client ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Recherche l'ensemble des clients de la BD
    public List<Client> rechercherTousClients() 
    {   
        JpaUtil.openEntityManager();
        List<Client> clients = clientDao.findAll();
        JpaUtil.closeEntityManager();
        
	return clients;
    }
    
    // Identification d'un client
    public Client identification(int idClient) throws Exception
    {
        JpaUtil.openEntityManager();
        Client client = ClientDao.findById(idClient);
	JpaUtil.closeEntityManager();
	
	return client;
    }
    
    /* SERVICES LIES A GALERIE */
    // Création d'une galerie
    public void creerGalerie(Galerie galerie) throws Exception
    {
	JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

        try
        {
            transaction.begin();
            galerieDao.create(galerie);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors de la création d'une oeuvre galerie ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Supprimer une galerie de la BD
    public void supprimerGalerie(Galerie galerie) throws Exception
    {
	JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

        try
        {
            transaction.begin();
            galerieDao.remove(galerie);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors de la suppression d'une galerie ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Recherche l'ensemle des galeries d'un client
    public List<Galerie> rechercherGaleriesParClient(int idClient)
    {
        JpaUtil.openEntityManager();
        List<Galerie> galeries = galerieDao.findByClient(idClient);
        JpaUtil.closeEntityManager();
        
	return galeries;
    }
    
    // Recherche l'ensemble des galeries contenant
    // l'oeuvre ayant pour ID, idOeuvre
    public List<Galerie> rechercherGaleriesParOeuvre(int idOeuvre)
    {
        JpaUtil.openEntityManager();
        List<Galerie> galeries = galerieDao.findByOeuvre(idOeuvre);
        JpaUtil.closeEntityManager();
        
	return galeries;  
    }
    
    // Ajout d'une galerie à un client
    public void ajouterGalerieAClient(Galerie galerie, Client client)
	    throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

	// Lien bidirectionnel mis à jour au niveau application
	client.addGallery(galerie);
	galerie.setClient(client);
        
	// Lien mis à jour au niveau BD
	try
        {
            transaction.begin();
            clientDao.update(client);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors de l'ajout d'une galerie à un client ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Retire une galerie à un client
    public void retirerGalerieAClient(Galerie galerie, Client client)
	    throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

	// Lien unidirectionnel mis à jour au niveau application
	client.removeGallery(galerie);
        
	// Mis à jour au niveau BD
	try
        {
            transaction.begin();
            clientDao.update(client);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors du retrait d'une galerie à un client ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Ajout d'une oeuvre dans une galerie
    public void ajouterOeuvreAGalerie(Oeuvre oeuvre , Galerie galerie)
	    throws Exception
    {
        JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

	// Lien unidirectionel mis à jour au niveau application
	galerie.addOeuvre(oeuvre);
        
	// Lien mis à jour au niveau BD
	try
        {
            transaction.begin();
            galerieDao.update(galerie);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors de l'ajout d'une oeuvre à une galerie ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Retire une oeuvre à une galerie
    public void retirerOeuvreAGalerie(Oeuvre oeuvre , Galerie galerie )
	    throws Exception
    {
	JpaUtil.openEntityManager();
        EntityTransaction transaction = JpaUtil.getEntityManagerTransaction();

	// Lien unidirectionel mis à jour au niveau application
	galerie.removeOeuvre(oeuvre);
        
	// Mis à jour au niveau BD
	try
        {
            transaction.begin();
            galerieDao.update(galerie);
            transaction.commit();
        }
        catch(Exception e)
        {
            if (transaction != null && transaction.isActive())
            {
                transaction.rollback();
            }
	    System.out.println(
		    "*** Erreur lors du retrait d'une oeuvre à une galerie ***");
            e.printStackTrace();
        }
        finally
        {
            JpaUtil.closeEntityManager();
        }
    }
    
    // Calcule la facture d'une galerie
    public float facturerGalerie(Galerie galerie)
    {
	float facture = 0;
	for ( Oeuvre oeuvre : galerie.getOeuvres() )
	{
	    facture += facturerOeuvre(oeuvre,
				galerie.getDateDebut(), galerie.getDateFin() );
	}
	
	return facture;
    }

}
