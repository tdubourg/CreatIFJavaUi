package modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Client;
import modele.Oeuvre;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-03-05T14:25:07")
@StaticMetamodel(Galerie.class)
public class Galerie_ { 

    public static volatile SingularAttribute<Galerie, Client> client;
    public static volatile SingularAttribute<Galerie, Date> dateRetour;
    public static volatile SingularAttribute<Galerie, Integer> idGalerie;
    public static volatile ListAttribute<Galerie, Oeuvre> listeOeuvre;
    public static volatile SingularAttribute<Galerie, Date> dateDebut;

}