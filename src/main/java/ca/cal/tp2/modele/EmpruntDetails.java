package ca.cal.tp2.modele;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpruntDetails {
    private final int id;
    private final LocalDate dateRetourPrevue;
    private final LocalDate dateRetourActuelle;
    private final String status;
    private Document document;

    // A mettre dans le service
    public boolean isEnRetard() {
        return false;
    }

    // A mettre dans le service
    public double calculAmende() {
        return 0;
    }

    // A mettre dans le service
    public void updateStatus() {}
}
