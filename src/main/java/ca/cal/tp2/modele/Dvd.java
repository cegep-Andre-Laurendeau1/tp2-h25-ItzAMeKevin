package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("DVD")
@Getter
public class Dvd extends Document {

    private String director;
    private int duree;
    private String rating;

    public Dvd(String titre, int nbExemplaire, String director, int duree, String rating) {
        super(titre, nbExemplaire);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }

    public Dvd() {}
}
