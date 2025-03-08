package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class Cd extends Document {

    private String artiste;
    private int duree;
    private String genre;

}
