package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class Dvd extends Document {
    public Dvd(String titre, String nombreExemplaire, String director, int duree, String rating) {
        super(titre, nombreExemplaire);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }

    private String director;
    private int duree;
    private String rating;

    public Dvd() {}
}
