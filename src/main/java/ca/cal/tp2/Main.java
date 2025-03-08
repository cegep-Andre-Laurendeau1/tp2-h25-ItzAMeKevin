package ca.cal.tp2;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.BibliothequeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        BibliothequeService service = new BibliothequeService(new EmprunteurRepositoryJPA());

        try {
            service.createEmprunteur("Justin Trudeau", "justrudeau@email.com", "1234567890");
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            System.out.println(service.getEmprunteur("Justin Trudeau", "justrudeau@email.com"));
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
