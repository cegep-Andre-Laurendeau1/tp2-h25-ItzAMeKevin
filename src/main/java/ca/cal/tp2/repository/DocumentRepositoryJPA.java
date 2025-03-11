package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Cd;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Dvd;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentRepositoryJPA extends RepositoryJPA implements DocumentRepository {
    @Override
    public void saveDocument(Document document) throws DatabaseException {
        save(document);
    }

    @Override
    public List<Livre> rechercherLivres(String titre, String auteur) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null) criteres.put("titre", titre);
        if (auteur != null) criteres.put("auteur", auteur);
        return rechercher(Livre.class, criteres);
    }

    @Override
    public List<Cd> rechercherCds(String titre, String artiste) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null && !titre.isBlank()) criteres.put("titre", titre);
        if (artiste != null && !artiste.isBlank()) criteres.put("artiste", artiste);
        return rechercher(Cd.class, criteres);
    }

    @Override
    public List<Dvd> rechercherDvds(String titre, String director) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null && !titre.isBlank()) criteres.put("titre", titre);
        if (director != null && !director.isBlank()) criteres.put("director", director);
        return rechercher(Dvd.class, criteres);
    }

    @Override
    public Document getDocument(int id) throws DatabaseException {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Document> query = em.createQuery(
                    "SELECT d FROM Document d LEFT JOIN FETCH d.empruntDetailsList WHERE d.id = :id", Document.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
