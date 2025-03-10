package ca.cal.tp2.service;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.dto.CdDTO;
import ca.cal.tp2.service.dto.EmprunteurDTO;
import ca.cal.tp2.service.dto.LivreDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BibliothequeService {

    private EmprunteurRepositoryJPA emprunteurRepository;
    private LivreRepositoryJPA livreRepository;
    private CDRepositoryJPA cdRepository;
    private DVDRepositoryJPA dvdRepository;

    public BibliothequeService(
            EmprunteurRepositoryJPA emprunteurRepository,
            LivreRepositoryJPA livreRepository,
            CDRepositoryJPA cdRepository,
            DVDRepositoryJPA dvdRepository
    ) {
        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
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

    public List<LivreDTO> rechercherLivres(String titre, String auteur) throws DatabaseException {
        List<Livre> livres = livreRepository.rechercherLivres(titre, auteur);
        return livres.stream().map(LivreDTO::toDTO).collect(Collectors.toList());
    }

    public void saveCD(String titre, int nbExemplaire, String artiste, int duree, String genre) throws DatabaseException {
        cdRepository.saveCD(new Cd(titre, nbExemplaire, artiste, duree, genre));
    }

    public List<CdDTO> rechercherCDs(String titre, String artiste) throws DatabaseException {
        List<Cd> cds = cdRepository.rechercherCDs(titre, artiste);
        return cds.stream().map(CdDTO::toDTO).collect(Collectors.toList());
    }

    public void saveDVD(String titre, int nbExemplaire, String director, int duree, String rating) throws DatabaseException {
        dvdRepository.saveDvd(new Dvd(titre, nbExemplaire, director, duree, rating));
    }
}
