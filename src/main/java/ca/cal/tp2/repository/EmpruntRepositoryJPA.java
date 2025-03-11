package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunt;

public class EmpruntRepositoryJPA extends RepositoryJPA implements EmpruntRepository {
    @Override
    public void saveEmprunt(Emprunt emprunt) throws DatabaseException {
        save(emprunt);
    }
}
