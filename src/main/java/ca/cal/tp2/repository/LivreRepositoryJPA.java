package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.*;

import java.util.List;

public class LivreRepositoryJPA extends RepositoryJPA implements LivreRepository {

    @Override
    public void saveLivre(Livre livre) throws DatabaseException {
        save(livre);
    }

    @Override
    public List<Livre> rechercherLivres(String titre, String auteur) throws DatabaseException {
        try (EntityManager em = emf.createEntityManager()) {
            String jpql = "SELECT l FROM Livre l WHERE (:titre IS NULL OR LOWER(l.titre) LIKE LOWER(:titre)) " +
                    "AND (:auteur IS NULL OR LOWER(l.auteur) LIKE LOWER(:auteur))";
            TypedQuery<Livre> query = em.createQuery(jpql, Livre.class);
            query.setParameter("titre", titre != null ? "%" + titre.toLowerCase() + "%" : null);
            query.setParameter("auteur", auteur != null ? "%" + auteur.toLowerCase() + "%" : null);
            return query.getResultList();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
