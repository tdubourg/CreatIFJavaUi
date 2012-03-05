package modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Galerie;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-03-05T14:25:07")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> numTel;
    public static volatile SingularAttribute<Client, Integer> numClient;
    public static volatile ListAttribute<Client, Galerie> listeGalerie;
    public static volatile SingularAttribute<Client, String> nom;

}