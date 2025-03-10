package ca.cal.tp2;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.repository.CDRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.repository.LivreRepositoryJPA;
import ca.cal.tp2.service.BibliothequeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        BibliothequeService service = new BibliothequeService(
                new EmprunteurRepositoryJPA(),
                new LivreRepositoryJPA(),
                new CDRepositoryJPA()
        );

        try {
            service.saveEmprunteur("Justin Trudeau", "justrudeau@email.com", "1234567890");
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            System.out.println(service.getEmprunteur("Justin Trudeau", "justrudeau@email.com"));
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            service.saveLivre("Excalibur", 1, "4102128880117", "Martin", "LivrePub", 426);
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            service.saveCD("Smooth Criminal", 3, "Michael Jackson", 4, "Pop");
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
