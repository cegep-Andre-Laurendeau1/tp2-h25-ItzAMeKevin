package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Cd;

public interface CDRepository {
    void saveCD(Cd cd) throws DatabaseException;
}
