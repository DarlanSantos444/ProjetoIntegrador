package Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {
    
    public static EntityManager openDB(){
    
        EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("PI1PU");
        return emf.createEntityManager();
        
    }
    
}