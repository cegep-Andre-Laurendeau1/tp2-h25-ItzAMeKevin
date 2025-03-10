package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Dvd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDRepositoryJPA extends RepositoryJPA implements DVDRepository {
    @Override
    public void saveDvd(Dvd dvd) throws DatabaseException {
        save(dvd);
    }

    @Override
    public List<Dvd> rechercherDvds(String titre, String director) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null) criteres.put("titre", titre);
        if (director != null) criteres.put("director", director);
        return rechercher(Dvd.class, criteres);
    }
}
