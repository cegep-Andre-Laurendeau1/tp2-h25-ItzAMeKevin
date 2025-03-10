package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Dvd;

public interface DVDRepository {
    void saveDvd(Dvd dvd) throws DatabaseException;
}
