package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.EmpruntDetails;

public class EmpruntDetailsRepositoryJPA extends RepositoryJPA implements EmpruntDetailsRepository {
    @Override
    public void saveEmpruntDetails(EmpruntDetails empruntDetails) throws DatabaseException {
        save(empruntDetails);
    }
}
