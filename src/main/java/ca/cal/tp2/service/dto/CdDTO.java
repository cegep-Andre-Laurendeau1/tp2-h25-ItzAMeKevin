package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Cd;

public record CdDTO(int id, String titre, int nbExemplaire, String artiste, int duree, String genre) {
    public static CdDTO toDTO(Cd cd) {
        return new CdDTO(
                cd.getId(),
                cd.getTitre(),
                cd.getNombreExemplaire(),
                cd.getArtiste(),
                cd.getDuree(),
                cd.getGenre()
        );
    }
}
