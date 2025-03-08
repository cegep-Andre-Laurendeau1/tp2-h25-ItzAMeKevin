package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Emprunteur;

public record EmprunteurDTO(long id, String nom, String email, String phoneNumber) {
    public static EmprunteurDTO toDTO(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getId(), emprunteur.getNom(), emprunteur.getEmail(), emprunteur.getPhoneNumber());
    }
}
