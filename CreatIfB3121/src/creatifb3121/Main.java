/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creatifb3121;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.Artiste;
import modele.Client;
import modele.Galerie;
import modele.Oeuvre;
import modele.Peinture;
import modele.Sculpture;
import service.Service;
import util.Saisie;

/**
 *
 * @author Vincent BRISON & Mathilde CUCCHI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Service service = new Service();
    // ------- tests creations d'oeuvres sans artistes -------------

    public static void creationDb() throws Exception {

        Artiste a1 = new Artiste("De Vinci", "Leonard", "DeVinci, illustre artiste");
        Artiste a2 = new Artiste("De Vinci fils", "Leonardo", "DeVinci fils, le fils de DeVinci");
        Artiste a3 = new Artiste("De Vinci pere", "Leonardio", "DeVinci pere, pere de DeVinci, et grand pere de DeVinci pere");

        Oeuvre o1 = new Peinture("La Joconde", 500, "Art, le top du top", 40, 50);
        Oeuvre o2 = new Peinture("La Joconde brouillon", 50, "Brouillon de la peinture la plus connue du monde", 20, 25);
        Oeuvre o3 = new Peinture("La Joconde XXL", 5000, "La Joconde en taille XXL", 400, 500);
        Oeuvre o4 = new Peinture("La Joconde NB", 250, "La Joconde en noir et blanc", 40, 50);
        Oeuvre o5 = new Peinture("La Joconde abstraite", 50000, "Reprentation tres abstraite de la Jocombe", 1, 2);
        Oeuvre o6 = new Sculpture("La Joconde en vrai 3D", 500000, "Art cubique, la jocombe en 3 dimensions", 100, 100, 100);

        Client c1 = new Client("Bob", "Jack", "2 rue de la rose, 12345 DasiVille", "04 52 12 36 59");
        Client c2 = new Client("Do", "John", "3 rue des fleurs, 12345 DasiVille", "02 22 22 22 22");

        //Format date MM/JJ/AAAA
        Date d1 = new Date("01/13/2012");
        Date d2 = new Date("02/07/2012");

        Date d3 = new Date("01/5/2015");
        Date d4 = new Date("02/15/2016");

        Date d5 = new Date("01/22/2017");
        Date d6 = new Date("02/15/2018");


        Galerie g1 = new Galerie(d1, d2);
        Galerie g2 = new Galerie(d3, d4);
        Galerie g3 = new Galerie(d5, d6);

        service.ajouterOeuvre(o1, a1);
        service.ajouterOeuvre(o2, a1);
        service.ajouterOeuvre(o3, a2);
        service.ajouterOeuvre(o4, a2);
        service.ajouterOeuvre(o5, a3);
        service.ajouterOeuvre(o6, a3);

        service.ajouterOeuvreAGalerie(o1, g1);
        service.ajouterOeuvreAGalerie(o2, g1);
        service.ajouterOeuvreAGalerie(o3, g1);

        service.ajouterOeuvreAGalerie(o1, g2);

        service.ajouterOeuvreAGalerie(o1, g3);
        service.ajouterOeuvreAGalerie(o5, g3);
        service.ajouterOeuvreAGalerie(o6, g3);

        service.ajouterGalerieAuClient(g1, c1);
        service.ajouterGalerieAuClient(g2, c1);
        service.ajouterGalerieAuClient(g3, c2);

    }

    // I/O Affichage du catalogue
    public static void afficherCatalogue() {
        String catalogue = "";
        catalogue += service.catalogue();
        System.out.println(catalogue);
    }

    // Login d'un client via son numClient
    public static Client login() {
        String saisie = "";
        int numClient = 0;
        Client client = null;
        saisie = Saisie.lireChaine("Entrez votre numero client : ");
        numClient = Integer.parseInt(saisie);
        System.out.println("Vous avez entre le numero client : " + numClient);
        client = service.rechercherClientParNumClient(numClient);

        if (client == null) {
            System.out.println("Client non trouve");
            return client;
        } else {
            System.out.println("Bienvenue " + client.getPrenom() + " " + client.getNom());
            return client;
        }
    }

    // BD : Creer une galerie pour un client
    public static void elaborerGalerie(Client client) throws Exception {
        int confirmation = 0; //permet au client d'annuler ou de valider sa galerie
        int nbOeuvre = 0; //permet de limiter à 10 le nombre d'oeuvres par galerie
        Oeuvre oeuvre;//Permet de manipuler les oeuvres au cours de l'elaboration de la galerie
        Galerie galerie;//Permet de manipuler la galerie en cours d'elaboration
        int choixMenu = 1; //permet les I/O console
        Date dateDebut;//debut de la galerie
        Date dateFin;//fin de la galerie
        List<Oeuvre> listeOeuvre = new ArrayList<Oeuvre>();//stocke les oeuvres pouvant etre selectionnées
        
        if (client != null) {
            dateDebut = new Date(Saisie.lireChaine("Indiquez la date de debut dans le format MM/JJ/AAAA (exemple : 01/22/2013) : "));
            dateFin = new Date(Saisie.lireChaine("Indiquez la date de fin dans le format MM/JJ/AAAA (exemple : 01/22/2013) : "));
            galerie = new Galerie(dateDebut, dateFin);
            listeOeuvre = service.rechercherToutesLesOeuvresDisponibles(dateDebut, dateFin);
            
            while (choixMenu != 0 && nbOeuvre < 10) { //Selection des oeuvres
                System.out.println("Vous pouvez encore ajouter " + (10 - nbOeuvre) + " oeuvre(s)");
                oeuvre = selectionOeuvreDuneListe(listeOeuvre);
                listeOeuvre.remove(oeuvre);
                service.ajouterOeuvreAGalerieNoBD(oeuvre, galerie);
                System.out.println("L'oeuvre : " + oeuvre.getNom() + " a ete ajoutee a votre galerie");
                nbOeuvre++; //compteur pour ne pas ajouter plus de 10 oeuvres
                choixMenu = Integer.parseInt(Saisie.lireChaine("Si votre selection est finie (vous ne voulez plus ajouter d'oeuvres), tapez 0 : "));

            }
            service.ajouterGalerieAuClientNoBD(galerie, client);
            System.out.println("Resume de votre galerie : ");
            System.out.println(service.infoGalerie(galerie));
            confirmation = Integer.parseInt(Saisie.lireChaine("Validez votre galerie ?\n1 : Oui\n0 : Non\n"));
            if (confirmation == 1) {
                service.validerCreationGalerie(galerie, client);
                System.out.println("Galerie cree!");
            } else {
                System.out.println("Galerie non cree!");
            }
        }
    }

    // I/O : Affiche les galerie d'un client
    public static void afficherGalerie(Client client) {
        service.afficherLesGaleriesDunClient(client);
    }

    // BD : Creer une oeuvre et l'ajouter à la base de donnée
    public static void ajouterOeuvre() throws Exception {
        Oeuvre oeuvre = null;
        Artiste artiste = null;
        String saisie = ""; //pour les I/O console
        int type = 0; //renseigne le type de l'oeuvre (sculpture ou peinture

        String nom = ""; //renseigne l'oeuvre
        int tarifJournalier = 0;//renseigne l'oeuvre
        String description = "";//renseigne l'oeuvre
        int hauteur = 0;//renseigne l'oeuvre
        int largeur = 0;//renseigne l'oeuvre
        int epaisseur = 0;//renseigne l'oeuvre

        System.out.println("--|Service d'ajout d'une oeuvre|--");
        System.out.println("Quelle est le type de l'oeuvre : ");
        System.out.println("1 : Peinture");
        System.out.println("2 : Sculpture");
        saisie = Saisie.lireChaine("Entrez votre choix : ");

        type = Integer.parseInt(saisie);
        if (type == 1 || type == 2) {
            nom = Saisie.lireChaine("Indiquez le nom : ");
            tarifJournalier = Integer.parseInt(Saisie.lireChaine("Indiquez le tarif journalier : "));
            description = Saisie.lireChaine("Indiquez la description : ");
            hauteur = Integer.parseInt(Saisie.lireChaine("Indiquez la hauteur : "));
            largeur = Integer.parseInt(Saisie.lireChaine("Indiquez la largeur : "));
            if (type == 1) { //Si l'oeuvre est une peinture
                oeuvre = new Peinture(nom, tarifJournalier, description, hauteur, largeur);
            } else if (type == 2) { // Si l'oeuvre est une sculpture
                epaisseur = Integer.parseInt(Saisie.lireChaine("Indiquez l'epaisseur : "));
                oeuvre = new Sculpture(nom, tarifJournalier, description, hauteur, largeur, epaisseur);
            }
            artiste = selectionArtiste();
            if (artiste != null) {
                service.ajouterOeuvre(oeuvre, artiste);
                System.out.println("Oeuvre ajoutée !");
            }

        } else {
            System.out.println("Choix du type invalide, retour au menu principal");
        }

    }

    // I/O Permet de visualiser le calendrier d'une oeuvre (obtenu via un service)
    @SuppressWarnings("static-access")
    public static void calendrierOeuvre() throws Exception {
        Oeuvre oeuvre;
        oeuvre = selectionOeuvre();
        System.out.println(service.calendrierLocation(oeuvre));
    }

    // I/O Permet d'afficher les artistes de la BD et d'en selectionner un artiste
    public static Artiste selectionArtiste() throws Exception {
        List<Artiste> ListArtiste;
        int selectionArtiste = 0;
        ListArtiste = afficherTousLesArtistes();
        selectionArtiste = Integer.parseInt(Saisie.lireChaine("Indiquez l'artiste : "));
        if (selectionArtiste >= 1 && selectionArtiste <= ListArtiste.size()) {
            return ListArtiste.get(selectionArtiste - 1);
        } else {
            System.out.println("Selection invalide, l'artiste n'est pas selectionne");
            return null;
        }
    }

    // I/O Permet d'afficher les oeuvres de la BD et d'en selectionner une    
    public static Oeuvre selectionOeuvre() throws Exception {
        List<Oeuvre> ListOeuvre;
        int selectionOeuvre = 0;
        ListOeuvre = afficherToutesLesOeuvres();
        selectionOeuvre = Integer.parseInt(Saisie.lireChaine("Indiquez l'oeuvre: "));
        if (selectionOeuvre >= 1 && selectionOeuvre <= ListOeuvre.size()) {
            return ListOeuvre.get(selectionOeuvre - 1);
        } else {
            System.out.println("Selection invalide, l'oeuvre n'est pas selectionnee");
            return null;
        }
    }
    
    // I/O Permet d'afficher les oeuvres d'une List et d'en selectionner une    
    public static Oeuvre selectionOeuvreDuneListe(List<Oeuvre> listeOeuvre) throws Exception {
        int selectionOeuvre = 0;
        afficherLesOeuvresDuneListe(listeOeuvre);
        selectionOeuvre = Integer.parseInt(Saisie.lireChaine("Indiquez l'oeuvre: "));
        if (selectionOeuvre >= 1 && selectionOeuvre <= listeOeuvre.size()) {
            return listeOeuvre.get(selectionOeuvre - 1);
        } else {
            System.out.println("Selection invalide, l'oeuvre n'est pas selectionnee");
            return null;
        }
    }

    // I/O Affiche tous les artistes de la BD, renvoie la List correspondante pour d'eventuelles manipulation
    public static List afficherTousLesArtistes() throws Exception {
        List<Artiste> liste = service.rechercherToutsLesArtistes();
        int i = 1;
        for (Artiste a : liste) {
            System.out.println(i + " : " + a.getNom()); //la variable i est utlisee pour fair ela selection en mode console
            i = i + 1;
        }
        return liste;
    }

    // I/O Affiche toutes les oeuvres de la BD, renvoie la List correspondante pour d'eventuelles manipulation
    public static List afficherToutesLesOeuvres() throws Exception {
        List<Oeuvre> liste = service.rechercherToutesLesOeuvres();
        int i = 1;
        for (Oeuvre o : liste) {
            System.out.println(i + " : " + o.getNom()); //la variable i est utlisee pour fair ela selection en mode console
            i = i + 1;
        }
        return liste;
    }
    
    // I/O Affiche toutes les oeuvres d'une list
    public static void afficherLesOeuvresDuneListe(List<Oeuvre> listeOeuvre){
        List<Oeuvre> liste = listeOeuvre;
                int i = 1;
        for (Oeuvre o : liste) {
            System.out.println(i + " : " + o.getNom()); //la variable i est utlisee pour fair ela selection en mode console
            i = i + 1;
        }
    }
    

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int choixMenu = 0;
        String saisie = "";

        creationDb();
        while (choixMenu == 0) {
            System.out.println("--| Creat'IF |--");
            System.out.println("1 : Ajouter une oeuvre au service");
            System.out.println("2 : Visualisez le calendrier de location d'une oeuvre");
            System.out.println("3 : Login d'un client, pour creer une galerie");
            System.out.println("4 : Login d'un client, pour afficher ses galeries");
            System.out.println("5 : Afficher le catalogue");
            System.out.println("6 : Quitter");
            saisie = Saisie.lireChaine("Entrez votre choix : ");
            choixMenu = Integer.parseInt(saisie);
            switch (choixMenu) {
                case 1:
                    ajouterOeuvre();
                    choixMenu = 0;
                    break;
                case 2:
                    calendrierOeuvre();
                    choixMenu = 0;
                    break;
                case 3:
                    elaborerGalerie(login());
                    choixMenu = 0;
                    break;
                case 4:
                    afficherGalerie(login());
                    choixMenu = 0;
                    break;
                case 5:
                    afficherCatalogue();
                    choixMenu = 0;
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Choix menu invalide");
                    choixMenu = 0;
            }
        }

    }
}
