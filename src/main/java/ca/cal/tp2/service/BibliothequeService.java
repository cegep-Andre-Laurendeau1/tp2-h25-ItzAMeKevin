package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.repository.EmprunteurRepositoryJDBC;

public class BibliothequeService {
    private final EmprunteurRepositoryJDBC utilisateurRepoJDBC;

    public BibliothequeService( EmprunteurRepositoryJDBC utilisateurRepoJDBC ) {
        this.utilisateurRepoJDBC = utilisateurRepoJDBC;
    }

    public void createEmprunteur(int userId, String name, String email, String phoneNumber) {
        utilisateurRepoJDBC.saveEmprunteur(new Emprunteur(userId, name, email, phoneNumber));
    }

    public Emprunteur getEmprunteur(int userId) {
        return utilisateurRepoJDBC.findEmprunteurById(userId);
    }
}
