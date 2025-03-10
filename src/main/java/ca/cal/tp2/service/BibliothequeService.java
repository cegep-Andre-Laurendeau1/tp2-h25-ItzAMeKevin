package ca.cal.tp2.service;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.repository.LivreRepositoryJPA;
import ca.cal.tp2.service.dto.EmprunteurDTO;

public class BibliothequeService {

    private EmprunteurRepositoryJPA emprunteurRepository;
    private LivreRepositoryJPA livreRepository;

    public BibliothequeService( EmprunteurRepositoryJPA emprunteurRepository, LivreRepositoryJPA livreRepository ) {
        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
    }

    public void saveEmprunteur(String nom, String email, String phoneNumber) throws DatabaseException {
        emprunteurRepository.saveEmprunteur(new Emprunteur(nom, email, phoneNumber));
    }

    public EmprunteurDTO getEmprunteur(String nom, String email) throws DatabaseException {
        return EmprunteurDTO.toDTO(emprunteurRepository.findEmprunteur(nom, email));
    }

    public void saveLivre(String titre, int nbExemplaire, String isbn, String auteur, String publicateur, int nbPage) throws DatabaseException {
        livreRepository.saveLivre(new Livre(titre, nbExemplaire, isbn, auteur, publicateur, nbPage));
    }
}
