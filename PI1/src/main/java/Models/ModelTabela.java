
package Models;

import Entidades.Ferro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModelTabela {
    public static EntityManager openDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PI1PU");
        return emf.createEntityManager();
    }

    public boolean salvar(Ferro f) {
        EntityManager em = ModelTabela.openDB();//Abre a conexão
        try {
            em.getTransaction().begin();//Início da transação
            if (f.getId() == null) {
                em.persist(f);//Monta um INSERT INTO..
            } else {
                em.merge(f);//Monta um UPDATE
            }
            em.getTransaction().commit();//Executa o INSERT ou o UPDATE com o objeto c
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();//Defaz a transação e volta ao estado incial.
            return false;
        } finally {
            em.close();//Fecha a conexão
        }
    }
    
    public List<Ferro> listaFerro(){
        EntityManager em = ModelTabela.openDB();//Abre a conexão
        try {
           return em.createQuery("select f from Ferro f order by f.tipo").getResultList();
        } finally {
            em.close();
        }
    }
    
   
    
}
