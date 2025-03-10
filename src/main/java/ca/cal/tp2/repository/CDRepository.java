package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Cd;

import java.util.List;

public interface CDRepository {
    void saveCD(Cd cd) throws DatabaseException;

    List<Cd> rechercherCDs(String titre, String artiste) throws DatabaseException;
}
