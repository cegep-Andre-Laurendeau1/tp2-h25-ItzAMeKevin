package ca.cal.tp2;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.BibliothequeService;
import ca.cal.tp2.service.dto.CdDTO;
import ca.cal.tp2.service.dto.DvdDTO;
import ca.cal.tp2.service.dto.LivreDTO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        BibliothequeService service = new BibliothequeService(
                new EmprunteurRepositoryJPA(),
                new LivreRepositoryJPA(),
                new CDRepositoryJPA(),
                new DVDRepositoryJPA(),
                new EmpruntRepositoryJPA(),
                new EmpruntDetailsRepositoryJPA()
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
            System.out.println(service.getEmprunteur(1));
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            service.saveLivre("Les parapluies verts", 2, "1234567890123", "Jean Dupont", "Éditions Soleil", 305);
            service.saveLivre("Parapluies et le froid", 1, "9876543210987", "Marie Curie", "Éditions Pluie", 251);
            service.saveLivre("Le vent et la neige", 3, "4567891230456", "Jean Dupont", "Éditions Nature", 409);

            List<LivreDTO> resultatsTitre = service.rechercherLivres("parapluies", null);
            System.out.println("Recherche par titre (parapluies) :");
            resultatsTitre.forEach(System.out::println);

            List<LivreDTO> resultatsAuteur = service.rechercherLivres(null, "Jean");
            System.out.println("\nRecherche par Auteur (Jean) :");
            resultatsAuteur.forEach(System.out::println);

            List<LivreDTO> resultatsTitreAuteur = service.rechercherLivres("parapluies", "Jean");
            System.out.println("\nRecherche par titre (parapluies) et auteur (Jean) :");
            resultatsTitreAuteur.forEach(System.out::println);

        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            service.saveCD("Greatest Hits", 2, "Queen", 60, "Rock");
            service.saveCD("Bohemian Rhapsody", 1, "Queen", 6, "Rock");
            service.saveCD("The Best of Mozart", 3, "Mozart", 120, "Classique");
            service.saveCD("Jazz Classics", 2, "Various Artists", 90, "Jazz");

            List<CdDTO> resultatsTitre = service.rechercherCDs("Greatest", null);
            System.out.println("Recherche par titre (Greatest) :");
            resultatsTitre.forEach(System.out::println);

            List<CdDTO> resultatsArtiste = service.rechercherCDs(null, "Queen");
            System.out.println("\nRecherche par artiste (Queen) :");
            resultatsArtiste.forEach(System.out::println);

            List<CdDTO> resultatsTitreArtiste = service.rechercherCDs("Greatest", "Queen");
            System.out.println("\nRecherche par titre (Greatest) et artiste (Queen) :");
            resultatsTitreArtiste.forEach(System.out::println);

        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            System.out.println(service.getCD(4));
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            service.saveDVD("Super Mario Bros", 2, "James Cameron", 120, "Funny");
            service.saveDVD("Miyamoto and Mario", 3, "Nintendo", 75, "Creative");
            service.saveDVD("Miyamoto the designer", 2, "Nintendo", 75, "Ok cool");

            List<DvdDTO> resultatsTitre = service.rechercherDVDs("Mario", null);
            System.out.println("Recherche par titre (Mario) :");
            resultatsTitre.forEach(System.out::println);

            List<DvdDTO> resultatsDirector = service.rechercherDVDs(null, "Nintendo");
            System.out.println("\nRecherche par directeur (Nintendo) :");
            resultatsDirector.forEach(System.out::println);

            List<DvdDTO> resultatsTitreDirector = service.rechercherDVDs("Mario", "Nintendo");
            System.out.println("\nRecherche par titre (Mario) et directeur (Nintendo) :");
            resultatsTitreDirector.forEach(System.out::println);

        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        try {
            System.out.println(service.getDVD(8));
        } catch (DatabaseException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }

        Thread.currentThread().join();
    }
}
