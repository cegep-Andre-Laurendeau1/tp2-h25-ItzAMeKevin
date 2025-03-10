package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Cd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CDRepositoryJPA extends RepositoryJPA implements CDRepository {
    @Override
    public void saveCD(Cd cd) throws DatabaseException {
        save(cd);
    }

    @Override
    public List<Cd> rechercherCDs(String titre, String artiste) throws DatabaseException {
        Map<String, String> criteres = new HashMap<>();
        if (titre != null) criteres.put("titre", titre);
        if (artiste != null) criteres.put("artiste", artiste);
        return rechercher(Cd.class, criteres);
    }
}
