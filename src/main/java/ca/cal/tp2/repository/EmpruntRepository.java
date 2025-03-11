package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunt;

public interface EmpruntRepository {
    void saveEmprunt(Emprunt emprunt) throws DatabaseException;

    Emprunt getEmprunt(int id) throws DatabaseException;
}
