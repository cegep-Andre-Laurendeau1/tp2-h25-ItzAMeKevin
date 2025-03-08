package ca.cal.tp2.service;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.dto.EmprunteurDTO;

public class BibliothequeService {

    private EmprunteurRepositoryJPA emprunteurRepository;

    public BibliothequeService( EmprunteurRepositoryJPA emprunteurRepository ) {
        this.emprunteurRepository = emprunteurRepository;
    }

    public void createEmprunteur(String nom, String email, String phoneNumber) throws DatabaseException {
        emprunteurRepository.saveEmprunteur(new Emprunteur(nom, email, phoneNumber));
    }

    public EmprunteurDTO getEmprunteur(String nom, String email) throws DatabaseException {
        return EmprunteurDTO.toDTO(emprunteurRepository.findEmprunteur(nom, email));
    }
}
