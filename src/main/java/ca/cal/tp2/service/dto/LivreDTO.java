package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Livre;

public record LivreDTO(String titre, int nbExemplaire, String isbn, String auteur, String editeur, int nombrePages) {
    public static LivreDTO toDTO(Livre livre) {
        return new LivreDTO(
                livre.getTitre(),
                livre.getNombreExemplaire(),
                livre.getIsbn(),
                livre.getAuteur(),
                livre.getEditeur(),
                livre.getNombrePages()
        );
    }
}
