package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.EmpruntDetails;

public interface EmpruntDetailsRepository {
    void saveEmpruntDetails(EmpruntDetails empruntDetails) throws DatabaseException;
}
