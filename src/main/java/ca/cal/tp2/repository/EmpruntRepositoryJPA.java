package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmpruntRepositoryJPA extends RepositoryJPA implements EmpruntRepository {
    @Override
    public void saveEmprunt(Emprunt emprunt) throws DatabaseException {
        save(emprunt);
    }

    @Override
    public Emprunt getEmprunt(int id) throws DatabaseException {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Emprunt> query = em.createQuery(
                    "SELECT e FROM Emprunt e LEFT JOIN FETCH e.empruntDetailsList WHERE e.id = :id", Emprunt.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
