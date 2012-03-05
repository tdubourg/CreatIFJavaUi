package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaUtil
{
    private static final String NAME_PERSISTENCE_UNIT = "CreatIFPU";
    private static EntityManagerFactory emf;
    private static ThreadLocal<EntityManager> tl = 
					    new ThreadLocal<EntityManager>();

    public static void openEntityManager()
    {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        tl.set(em);
    }

    public static EntityManager getEntityManager()
    {
        EntityManager em = tl.get();
        return em;
    }

    private static EntityManagerFactory getEntityManagerFactory()
    {
        if (emf == null)
	{
            emf = Persistence.createEntityManagerFactory(NAME_PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static void closeEntityManager()
    {
        EntityManager em = tl.get();
        if (em != null)
	{
            em.close();
            tl.set(null);
        }
    }

    public static EntityTransaction getEntityManagerTransaction() 
							    throws Exception
    {
        return getEntityManager().getTransaction();
    }
    
}

