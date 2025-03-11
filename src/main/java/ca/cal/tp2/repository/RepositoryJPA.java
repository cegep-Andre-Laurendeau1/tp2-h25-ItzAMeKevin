package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

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

    public <T> List<T> rechercher(Class<T> classeT, Map<String, String> criteres) throws DatabaseException{
        try (EntityManager em = emf.createEntityManager()) {
            StringBuilder jpql = new StringBuilder("SELECT e FROM " + classeT.getSimpleName() + " e WHERE 1=1");

            for (String key : criteres.keySet()) {
                jpql.append(" AND LOWER(e.").append(key).append(") LIKE LOWER(:").append(key).append(")");
            }

            TypedQuery<T> query = em.createQuery(jpql.toString(), classeT);

            for (Map.Entry<String, String> entry : criteres.entrySet()) {
                query.setParameter(entry.getKey(), "%" + entry.getValue().toLowerCase() + "%");
            }

            return query.getResultList();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    public <T> T rechercheById(int id, Class<T> classeT) throws DatabaseException{
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<T> query = em.createQuery(
                    "SELECT e FROM " + classeT.getSimpleName() + " e WHERE e.id = :id", classeT
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
