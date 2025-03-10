package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Livre;

import java.util.List;

public interface LivreRepository {

    void saveLivre(Livre livre) throws DatabaseException;

    List<Livre> rechercherLivres(String titre, String auteur) throws DatabaseException;
}
