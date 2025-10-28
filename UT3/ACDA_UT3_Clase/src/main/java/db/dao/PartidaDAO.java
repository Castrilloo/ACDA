package db.dao;

import db.model.Partida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PartidaDAO {

    private static final String PERSISTENCE_UNIT_NAME = "default"; // Cambia si tu persistence.xml usa otro nombre
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void save(Partida partida) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(partida);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Partida findById(int id) {
        EntityManager em = emf.createEntityManager();
        Partida partida = null;
        try {
            partida = em.find(Partida.class, id);
        } finally {
            em.close();
        }
        return partida;
    }

    public List<Partida> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Partida> lista = null;
        try {
            TypedQuery<Partida> query = em.createQuery("SELECT v FROM partida p", Partida.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public void update(Partida partida) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(partida);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Partida partida = em.find(Partida.class, id);
            if (partida != null) {
                em.remove(partida);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    
    
    
    
}
