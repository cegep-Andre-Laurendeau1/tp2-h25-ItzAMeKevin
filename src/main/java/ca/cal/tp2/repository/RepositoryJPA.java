package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class RepositoryJPA {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio.pu");

    public <T> void save(T t) throws DatabaseException{
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }
}
