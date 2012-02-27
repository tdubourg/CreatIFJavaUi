/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.persistence.FlushModeType;
import javax.persistence.Query;
import modele.Client;
import util.JpaUtil;

/**
 *
 * @author Administrateur
 */
public class ClientDao 
{

    public ClientDao() 
    {
    }

    // BD : Persister un client dans la BD
    public static void create(Client client)
    {
        JpaUtil.getEntityManager().persist(client);
    }
    
    // BD : mettre a jour un client de la BD (via merge)
    public void update(Client client)
    { 
       JpaUtil.getEntityManager().merge(client); 
    }
    
    // Donne le client de la BD correspond au numClient (sa PK)
    public Client findClient(int numClient)
    {   
        Client client = JpaUtil.getEntityManager().find(Client.class, numClient);
        return client;
    }

}
