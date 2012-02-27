/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ArtisteDao;
import dao.ClientDao;
import dao.GalerieDao;
import dao.OeuvreDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityTransaction;
import modele.Artiste;
import modele.Client;
import modele.Galerie;
import modele.Oeuvre;
import modele.Peinture;
import modele.Sculpture;
import util.JpaUtil;

/**
 *
 * @author VincentB
 */
public class Service {

    // BD : Genere l'affichage (un String) du catalogue 
    public static String catalogue() {
        String catalogue = "";
        List<Oeuvre> listeSculpture = new ArrayList<Oeuvre>();
        List<Oeuvre> listePeinture = new ArrayList<Oeuvre>();
        List<Artiste> listeArtiste = new ArrayList<Artiste>();
        listePeinture = rechercherToutesLesPeintures();
        listeSculpture = rechercherToutesLesSculptures();

        listeArtiste = rechercherArtisteParListeOeuvre(listePeinture);


        catalogue += "---------------------------------------\n";
        catalogue += "PEINTURES\n";
        catalogue += "---------------------------------------\n";
        for (Artiste a : listeArtiste) {
            catalogue += "[" + a.getIdArtiste() + "] " + a.getPrenom() + " " + a.getNom() + "\n";
            catalogue += "***************************************\n";
            for (Oeuvre o : listePeinture) {
                if (o.getArtiste() == a) {
                    catalogue += "[" + o.getIdOeuvre() + "] " + o.getNom();
                    catalogue += " (" + o.getDescription() + ", ";
                    Peinture p = (Peinture) o;
                    catalogue += p.getHauteur() + " x " + p.getLargeur() + ") ";
                    catalogue += p.getTarifJournalier() + "€\n";
                }

            }
            catalogue += "\n";
        }

        listeArtiste = rechercherArtisteParListeOeuvre(listeSculpture);


        catalogue += "---------------------------------------\n";
        catalogue += "SCULPTURES\n";
        catalogue += "---------------------------------------\n";
        for (Artiste a : listeArtiste) {
            catalogue += "[" + a.getIdArtiste() + "] " + a.getPrenom() + " " + a.getNom() + "\n";
            catalogue += "***************************************\n";
            for (Oeuvre o : listeSculpture) {
                if (o.getArtiste() == a) {
                    catalogue += "[" + o.getIdOeuvre() + "] " + o.getNom();
                    catalogue += " (" + o.getDescription() + ", ";
                    Sculpture s = (Sculpture) o;
                    catalogue += s.getHauteur() + " x " + s.getLargeur() + " x " + s.getEpaisseur() + ") ";
                    catalogue += s.getTarifJournalier() + "€\n";
                }

            }
            catalogue += "\n";
        }

        return catalogue;
    }

    //Genere l'affichage (un String) du calendrier d'une oeuvre    
    public static String calendrierLocation(Oeuvre oeuvre) {
        String calendrier = "";
        String ligneDate = "";
        List<Galerie> listeGalerie;
        if (oeuvre != null) {
            listeGalerie = oeuvre.getListeGalerie();
            if (!listeGalerie.isEmpty()) {
                for (Galerie g : listeGalerie) {
                    ligneDate = "Dates de location : du "
                            + g.getDateDebut().getDate() + "/"
                            + (g.getDateDebut().getMonth() + 1) + "/"
                            + (g.getDateDebut().getYear() + 1900) + " au "
                            + g.getDateRetour().getDate() + "/"
                            + (g.getDateRetour().getMonth() + 1) + "/"
                            + (g.getDateRetour().getYear() + 1900);
                    calendrier += ligneDate + "\n";
                }
            } else {
                calendrier += "Cette oeuvre n'est pas loue";
            }
        }
        return calendrier;
    }

    //Genere l'affichage (un String) d'une galerie personnelle
    public static String infoGalerie(Galerie galerie) {
        String infoGalerie = "";//contient l'affichage
        String ligneDate = "";//contient une partie de l'affichage
        int galeriePrix = 0;
        int dureeEnJour = 0;//contient la duree de l'affichage
        Client client;//stocke le client de la galerie
        List<Oeuvre> listeOeuvre;//stocke les oeuvre de la galerie
        List<Artiste> listeArtiste;//stocke les artiste de la galerie 
        if (galerie != null) {
            if (galerie.getClient() != null) {

                dureeEnJour = (int) ((galerie.getDateRetour().getTime() - galerie.getDateDebut().getTime()) / 86400000);


                client = galerie.getClient();
                infoGalerie = "-------------------------------------------\n"
                        + client.getPrenom() + " " + client.getNom() + "\n"
                        + client.getAdresse() + "\n"
                        + client.getNumTel() + "\n"
                        + "Votre numero client : " + client.getNumClient() + "\n";
                ligneDate = "Dates de location : du "
                        + galerie.getDateDebut().getDate() + "/"
                        + (galerie.getDateDebut().getMonth() + 1) + "/"
                        + (galerie.getDateDebut().getYear() + 1900) + " au "
                        + galerie.getDateRetour().getDate() + "/"
                        + (galerie.getDateRetour().getMonth() + 1) + "/"
                        + (galerie.getDateRetour().getYear() + 1900)
                        + " (" + dureeEnJour + " jours)";
                infoGalerie += ligneDate;
                
                for(Oeuvre o : galerie.getListeOeuvre()){
                    galeriePrix += o.getTarifJournalier()*dureeEnJour;
                }
                infoGalerie += "\nPrix facture : " + galeriePrix + " €";
                infoGalerie += "\n-------------------------------------------\n\n"
                        + "Votre galerie\n";
                listeOeuvre = galerie.getListeOeuvre();
                if (listeOeuvre != null) {
                    for (Oeuvre o : listeOeuvre) {
                        infoGalerie += "-";
                        infoGalerie += o.getArtiste().getPrenom().charAt(0);
                        infoGalerie += ". " + o.getArtiste().getNom();
                        infoGalerie += ", " + o.getNom() + "\n";
                    }
                    listeArtiste = rechercherArtisteParGalerie(galerie);
                    infoGalerie += "\nLes artiste de votre galerie\n";
                    for (Artiste a : listeArtiste) {
                        infoGalerie += a.getPrenom() + " " + a.getNom() + " : " + a.getBio() + "\n\n";
                    }


                } else {
                    infoGalerie += "Galerie vide";
                }

            }

        }
        return infoGalerie;
    }

    //I/O affichage de toutes les galeries d'un client
    public static void afficherLesGaleriesDunClient(Client client) {

        List<Galerie> listeGalerie;
        if (client != null) {
            listeGalerie = client.getListeGalerie();
            if (!listeGalerie.isEmpty()) {
                for (Galerie g : listeGalerie) {
                    System.out.println(infoGalerie(g));
                }
            } else if (listeGalerie.isEmpty()) {
                System.out.println("Aucune galerie");
            }
        }
    }

    // BD : ajouter une galerie a un client
    public static void ajouterGalerieAuClient(Galerie galerie, Client client) {

        if (galerieExistante(galerie) == false) //Si la galerie est absente de la base de données
        {
            creerGalerie(galerie);
        }
        
        if (clientExistant(client) == false) //Si le client est absent de la base de données
        {
            creerClient(client);
        }        

        client.addGalerie(galerie);
        updateGalerie(galerie);
        updateClient(client);
    }
    
    // ajouter une galerie a un client sans intervenir sur la BD
    public static void ajouterGalerieAuClientNoBD(Galerie galerie, Client client) {
        client.addGalerie(galerie);
    } 

    // BD : ajouter une oeuvre a une galerie
    public static void ajouterOeuvreAGalerie(Oeuvre oeuvre, Galerie galerie) {

        if (oeuvreExistante(oeuvre) == true) {
            if (galerieExistante(galerie) == false) //Si la galerie est absente de la base de données
            {
                creerGalerie(galerie);
            }

            galerie.addOeuvre(oeuvre);
            updateOeuvre(oeuvre);
            updateGalerie(galerie);
        }
    }
    
    // ajouter une oeuvre a une galerie sans intervenir sur la BD
    public static void ajouterOeuvreAGalerieNoBD(Oeuvre oeuvre, Galerie galerie) {
        galerie.addOeuvre(oeuvre);
    } 
    
    // BD : valide la creation d'une galerie par le client
    public static void validerCreationGalerie(Galerie galerie, Client client) {
        List<Oeuvre> listeOeuvre;//stockes les oeuvre de la galerie
        if (galerie != null){
            listeOeuvre = galerie.getListeOeuvre();
            for (Oeuvre o : listeOeuvre){
                updateOeuvre(o);             
            }
            updateClient(client);
            updateGalerie(galerie);
        }
        
    }

    // BD : ajouter une oeuvre (avec son artiste si celui ci n'existe pas dans la BD)
    public static void ajouterOeuvre(Oeuvre oeuvre, Artiste artiste) {


        if (artisteExistant(artiste) == false) //Si artiste absent de la base de données
        {
            creerArtiste(artiste);
        }

        creerOeuvre(oeuvre);
        artiste.addOeuvre(oeuvre);
        updateArtiste(artiste);
        updateOeuvre(oeuvre);
    }

    // BD : indique si un artiste est present ou non dans la BD
    public static boolean artisteExistant(Artiste artiste) {
        if (rechercherArtisteParNumId(artiste.getIdArtiste()) != null) {
            return true;
        }
        return false;
    }

    // BD : indique si une galerie est presente ou non dans la BD
    public static boolean galerieExistante(Galerie galerie) {
        if (rechercherArtisteParNumId(galerie.getIdGalerie()) != null) {
            return true;
        }
        return false;
    }
    
    // BD : indique si un client est present ou non dans la BD
    public static boolean clientExistant(Client client) {
        if (rechercherClientParNumClient(client.getNumClient()) != null) {
            return true;
        }
        return false;
    }
    
     // BD : indique si une oeuvre est presente ou non dans la BD
    public static boolean oeuvreExistante(Oeuvre oeuvre) {
        if (rechercherOeuvreParNumId(oeuvre.getIdOeuvre()) != null) {
            return true;
        }
        return false;
    }

    // Indique si une oeuvre est disponible a la location sur une periode donnee en parametre
    public static boolean oeuvreDisponible(Oeuvre oeuvre, Date dateDebut, Date dateFin) {
        List<Galerie> liste;
        liste = oeuvre.getListeGalerie();
        if (liste.size() == 0) {
            return true;
        } else {
            
            for (Galerie g : liste) {
                if (dateDebut.after(g.getDateRetour()) || dateDebut.before(g.getDateDebut())) {
                    if (dateFin.before(g.getDateDebut()) || dateFin.after(g.getDateRetour())) {
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // BD : Recherche toutes les oeuvres disponibles pour les dates passées en parametre
    public static List<Oeuvre> rechercherToutesLesOeuvresDisponibles(Date dateDebut, Date dateFin){
        List<Oeuvre> listeOeuvre = new ArrayList<Oeuvre>();
        listeOeuvre = rechercherToutesLesOeuvres();
        for (Oeuvre o : listeOeuvre){
            if (!oeuvreDisponible(o, dateDebut, dateFin)){
                listeOeuvre.remove(o);
            }
        }
        return listeOeuvre;
    }
    
    // Donne pour une liste d'oeuvre, tous les artistes de ces oeuvres
    public static List<Artiste> rechercherArtisteParListeOeuvre(List<Oeuvre> listeOeuvre) {
        List<Artiste> listeArtiste = new ArrayList<Artiste>();
        if (listeOeuvre != null) {
            if (!listeOeuvre.isEmpty()) {
                for (Oeuvre o : listeOeuvre) {
                    if (!listeArtiste.contains(o.getArtiste())) {//si la listeArtiste ne contient pas l'artiste de l'oeuvre
                        listeArtiste.add(o.getArtiste());//on l'ajoute
                    }
                }
            }
        }
        return listeArtiste;
    }

    // Donne pour une galerie donnee, tous les artiste qui ont des oeuvres dans cette galerie
    public static List<Artiste> rechercherArtisteParGalerie(Galerie galerie) {
        List<Artiste> listeArtiste = new ArrayList<Artiste>(); //stocke la liste des artiste a renvoyer
        List<Oeuvre> listeOeuvre = new ArrayList<Oeuvre>(); //stocke les oeuvre de la galerie

        if (galerie != null) //controle
        {
            listeOeuvre = galerie.getListeOeuvre();
            if (listeOeuvre != null) //controle
            {
                listeArtiste = rechercherArtisteParListeOeuvre(listeOeuvre);
            }
        }
        return listeArtiste;
    }

    // BD : rechercher un client par sa PK : son numClient
    public static Client rechercherClientParNumClient(int numClient) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            Client client;
            ClientDao cd = new ClientDao();
            client = cd.findClient(numClient);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : rechercher un artiste par sa PK : son numId
    public static Artiste rechercherArtisteParNumId(int id) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            Artiste artiste;
            ArtisteDao ad = new ArtisteDao();
            artiste = ad.findArtiste(id);
            return artiste;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : rechercher une galerie par sa PK : son numId
    public static Galerie rechercherGalerieParNumId(int id) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            Galerie galerie;
            GalerieDao gd = new GalerieDao();
            galerie = gd.findGalerie(id);
            return galerie;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
    
    // BD : rechercher une oeuvre par sa PK : son IdOeuvre
    public static Oeuvre rechercherOeuvreParNumId(int id) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            Oeuvre oeuvre;
            OeuvreDao od = new OeuvreDao();
            oeuvre = od.findOeuvre(id);
            return oeuvre;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }    

    // BD : rechercher tous les artistes presents en BD
    public static List<Artiste> rechercherToutsLesArtistes() {
        List<Artiste> liste;
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            ArtisteDao ad = new ArtisteDao();
            liste = ad.findAllArtiste();
            return liste;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : rechercher toutes les oeuvres presentes en BD
    public static List<Oeuvre> rechercherToutesLesOeuvres() {
        List<Oeuvre> liste;
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            OeuvreDao od = new OeuvreDao();
            liste = od.findAllOeuvre();
            return liste;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : rechercher toutes les sculptures presentes en BD
    public static List<Oeuvre> rechercherToutesLesSculptures() {
        List<Oeuvre> liste;
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            OeuvreDao od = new OeuvreDao();
            liste = od.findAllSculpture();
            return liste;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : rechercher toutes les peintures presentes en BD
    public static List<Oeuvre> rechercherToutesLesPeintures() {
        List<Oeuvre> liste;
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            OeuvreDao od = new OeuvreDao();
            liste = od.findAllPeinture();
            return liste;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return null;
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : persister un artiste
    public static void creerArtiste(Artiste artiste) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            ArtisteDao.create(artiste);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : persister un client
    public static void creerClient(Client client) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            ClientDao.create(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : persister une galerie
    public static void creerGalerie(Galerie galerie) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            GalerieDao.create(galerie);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : persister une oeuvre
    public static void creerOeuvre(Oeuvre oeuvre) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            OeuvreDao.create(oeuvre);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : mettre a jour un artiste (merge)
    public static void updateArtiste(Artiste artiste) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            ArtisteDao ad = new ArtisteDao();
            ad.update(artiste);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : mettre a jour une oeuvre (merge)    
    public static void updateOeuvre(Oeuvre oeuvre) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            OeuvreDao od = new OeuvreDao();
            od.update(oeuvre);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : mettre a jour une galerie (merge)    
    public static void updateGalerie(Galerie galerie) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            GalerieDao gd = new GalerieDao();
            gd.update(galerie);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    // BD : mettre a jour un client (merge)    
    public static void updateClient(Client client) {
        EntityTransaction tx = null;
        JpaUtil.openEntityManager();
        try {
            tx = JpaUtil.getEntityManagerTransaction();
            tx.begin();
            ClientDao cd = new ClientDao();
            cd.update(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
}
