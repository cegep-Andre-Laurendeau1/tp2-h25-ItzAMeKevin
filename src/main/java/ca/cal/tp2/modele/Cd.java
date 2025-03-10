package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class Cd extends Document {

    private String artiste;
    private int duree;
    private String genre;

    public Cd(String titre, int nbExemplaire, String artiste, int duree, String genre) {
        super(titre, nbExemplaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public Cd() {}
}
