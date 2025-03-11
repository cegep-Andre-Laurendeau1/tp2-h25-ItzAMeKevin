package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.*;

import java.util.List;

public interface DocumentRepository {

    void saveDocument(Document document) throws DatabaseException;

    List<Livre> rechercherLivres(String titre, String auteur) throws DatabaseException;

    List<Cd> rechercherCds(String titre, String artiste) throws DatabaseException;

    List<Dvd> rechercherDvds(String titre, String director) throws DatabaseException;

    Document getDocument(int id) throws DatabaseException;
}
