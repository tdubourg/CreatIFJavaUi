package modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Artiste;
import modele.Galerie;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-03-05T14:25:07")
@StaticMetamodel(Oeuvre.class)
public class Oeuvre_ { 

    public static volatile SingularAttribute<Oeuvre, Integer> tarifJournalier;
    public static volatile SingularAttribute<Oeuvre, Integer> idOeuvre;
    public static volatile SingularAttribute<Oeuvre, String> description;
    public static volatile SingularAttribute<Oeuvre, Artiste> artiste;
    public static volatile ListAttribute<Oeuvre, Galerie> listeGalerie;
    public static volatile SingularAttribute<Oeuvre, String> nom;

}