package modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Oeuvre;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-03-05T14:25:07")
@StaticMetamodel(Artiste.class)
public class Artiste_ { 

    public static volatile SingularAttribute<Artiste, String> prenom;
    public static volatile SingularAttribute<Artiste, Integer> idArtiste;
    public static volatile SingularAttribute<Artiste, String> bio;
    public static volatile SingularAttribute<Artiste, Integer> cote;
    public static volatile SingularAttribute<Artiste, String> nom;
    public static volatile ListAttribute<Artiste, Oeuvre> listeOeuvre;

}