package db.dao;

import db.model.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class VideojuegoDAO {

    private static final String PERSISTENCE_UNIT_NAME = "default"; // Cambia si tu persistence.xml usa otro nombre
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void save(Videojuego videojuego) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(videojuego);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Videojuego findById(int id) {
        EntityManager em = emf.createEntityManager();
        Videojuego videojuego = null;
        try {
            videojuego = em.find(Videojuego.class, id);
        } finally {
            em.close();
        }
        return videojuego;
    }

    public List<Videojuego> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Videojuego> lista = null;
        try {
            TypedQuery<Videojuego> query = em.createQuery("SELECT v FROM Videojuego v", Videojuego.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public void update(Videojuego videojuego) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(videojuego);
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
            Videojuego videojuego = em.find(Videojuego.class, id);
            if (videojuego != null) {
                em.remove(videojuego);
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
