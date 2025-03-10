package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Livre;

import javax.xml.crypto.Data;

public interface LivreRepository {

    void saveLivre(Livre livre) throws DatabaseException;
}
