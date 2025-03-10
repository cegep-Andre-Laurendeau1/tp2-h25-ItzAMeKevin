package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;

public class LivreRepositoryJPA extends RepositoryJPA implements LivreRepository {

    @Override
    public void saveLivre(Livre livre) throws DatabaseException {
        save(livre);
    }
}
