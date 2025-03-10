package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Dvd;

public class DVDRepositoryJPA extends RepositoryJPA implements DVDRepository {
    @Override
    public void saveDvd(Dvd dvd) throws DatabaseException {
        save(dvd);
    }
}
