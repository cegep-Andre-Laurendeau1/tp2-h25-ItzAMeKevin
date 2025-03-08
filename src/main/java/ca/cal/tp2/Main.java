package ca.cal.tp2;

import ca.cal.tp2.repository.EmprunteurRepositoryJDBC;
import ca.cal.tp2.service.BibliothequeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();

        BibliothequeService bibliothequeService = new BibliothequeService(new EmprunteurRepositoryJDBC());
        bibliothequeService.createEmprunteur(1, "John Smith", "johnsmith@email.com", "5140074422");
        System.out.println(bibliothequeService.getEmprunteur(1));

        Thread.currentThread().join();
    }
}
