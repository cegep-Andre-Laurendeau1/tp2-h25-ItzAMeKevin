package ca.cal.tp2.modele;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Amende {
    private final int id;
    private final double montant;
    private final LocalDate dateCreation;
    private final boolean status;

    // A mettre dans le service
    public double calculMontant() {
        return 0;
    }

    // A mettre dans le service
    public void updateStatus() {}


    // A mettre dans le service
    public int getId() {
        return id;
    }

    // A mettre dans le service
    public double getMontant() {
        return montant;
    }

    // A mettre dans le service
    public LocalDate getDateCreation() {
        return dateCreation;
    }

    // A mettre dans le service
    public boolean isStatus() {
        return status;
    }
}
