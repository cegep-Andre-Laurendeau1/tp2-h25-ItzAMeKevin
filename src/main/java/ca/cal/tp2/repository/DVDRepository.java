package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Dvd;

import java.util.List;

public interface DVDRepository {
    void saveDvd(Dvd dvd) throws DatabaseException;

    List<Dvd> rechercherDvds(String titre, String director) throws DatabaseException;

    Dvd getDVD(int id) throws DatabaseException;
}
