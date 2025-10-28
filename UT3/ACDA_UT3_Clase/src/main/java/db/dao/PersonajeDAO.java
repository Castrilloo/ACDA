package db.dao;

import db.model.Personaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonajeDAO {

    private static final String PERSISTENCE_UNIT_NAME = "default"; // Cambia si tu persistence.xml usa otro nombre
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void save(Personaje personaje) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(personaje);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Personaje findById(int id) {
        EntityManager em = emf.createEntityManager();
        Personaje personaje = null;
        try {
            personaje = em.find(Personaje.class, id);
        } finally {
            em.close();
        }
        return personaje;
    }

    public List<Personaje> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Personaje> lista = null;
        try {
            TypedQuery<Personaje> query = em.createQuery("SELECT v FROM Personaje p", Personaje.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public void update(Personaje personaje) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(personaje);
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
            Personaje personaje = em.find(Personaje.class, id);
            if (personaje != null) {
                em.remove(personaje);
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
