package Models;

import Entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {
    
    public static EntityManager openDB(){
    
        EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("PI1PU");
        return emf.createEntityManager();
        
    }
    
    public boolean salvar(Usuario u){
        EntityManager em = Model.openDB();
        try {
            em.getTransaction().begin();
            if (u.getId() == null) {
                em.persist(u);
            }else{
                em.merge(u);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally{
            em.close();
        }
        
    }

    public Usuario buscaUsuario(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}