package db.dao;

import db.model.Mision;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MisionDAO {
    private static final String PERSISTENCE_UNIT_NAME = "default"; // Cambia si tu persistence.xml usa otro nombre
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void save(Mision mision) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mision);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Mision findById(int id) {
        EntityManager em = emf.createEntityManager();
        Mision mision = null;
        try {
            mision = em.find(Mision.class, id);
        } finally {
            em.close();
        }
        return mision;
    }

    public List<Mision> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Mision> lista = null;
        try {
            TypedQuery<Mision> query = em.createQuery("SELECT v FROM Mision m", Mision.class);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public void update(Mision mision) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(mision);
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
            Mision mision = em.find(Mision.class, id);
            if (mision != null) {
                em.remove(mision);
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
