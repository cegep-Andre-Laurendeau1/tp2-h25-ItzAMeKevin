package ca.cal.tp2.service;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.dto.EmprunteurDTO;

public class BibliothequeService {

    private EmprunteurRepositoryJPA emprunteurRepository;
    private LivreRepositoryJPA livreRepository;
    private CDRepositoryJPA cdRepository;

    public BibliothequeService(
            EmprunteurRepositoryJPA emprunteurRepository,
            LivreRepositoryJPA livreRepository,
            CDRepositoryJPA cdRepository
    ) {
        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
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

    public void saveCD(String titre, int nbExemplaire, String artiste, int duree, String genre) throws DatabaseException {
        cdRepository.saveCD(new Cd(titre, nbExemplaire, artiste, duree, genre));
    }
}
