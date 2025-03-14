package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Dvd;

public record DvdDTO(int id, String titre, int nbExemplaire, String director, int duree, String rating) {
    public static DvdDTO toDTO(Dvd dvd) {
        return new DvdDTO(
                dvd.getId(),
                dvd.getTitre(),
                dvd.getNombreExemplaire(),
                dvd.getDirector(),
                dvd.getDuree(),
                dvd.getRating()
        );
    }
}
