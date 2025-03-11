package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.*;

import java.util.*;

public class LivreRepositoryJPA extends RepositoryJPA implements LivreRepository {

    @Override
    public void saveLivre(Livre livre) throws DatabaseException {
        save(livre);
    }

    @Override
    public List<Livre> rechercherLivres(String titre, String auteur) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null) criteres.put("titre", titre);
        if (auteur != null) criteres.put("auteur", auteur);
        return rechercher(Livre.class, criteres);
    }

    @Override
    public Livre getLivre(int id) throws DatabaseException {
        return rechercheById(id, Livre.class);
    }
}
