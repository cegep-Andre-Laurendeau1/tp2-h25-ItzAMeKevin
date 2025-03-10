package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class Dvd extends Document {

    private String director;
    private int duree;
    private String rating;
}
