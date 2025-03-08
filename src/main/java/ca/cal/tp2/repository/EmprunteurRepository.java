package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunteur;

// A changer en 2 interfaces (Emprunteur et Prepose)
public interface EmprunteurRepository {

    void saveEmprunteur(Emprunteur emprunteur) throws DatabaseException;

    Emprunteur findEmprunteur(String nom, String email) throws DatabaseException;

}
