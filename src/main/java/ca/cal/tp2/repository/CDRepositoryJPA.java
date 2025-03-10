package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Cd;

public class CDRepositoryJPA extends RepositoryJPA implements CDRepository {
    @Override
    public void saveCD(Cd cd) throws DatabaseException {
        save(cd);
    }
}
