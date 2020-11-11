package Models;

import Entidades.Ferro;
import Entidades.Usuario;
import java.util.List;
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


    public Usuario buscaUsuario(String nome){
        EntityManager em = Model.openDB();//Abre a conexão
        try {
            return (Usuario) em.createQuery("select u from Usuario u where u.nome = '"+nome+"'").getSingleResult();
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
    }
    
    public List<Ferro> listaFerro(){
        EntityManager em = Model.openDB();//Abre a conexão
        try {
            return em.createQuery("select u from ferro").getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
    }
    
    
}