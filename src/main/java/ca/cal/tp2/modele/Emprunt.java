package ca.cal.tp2.modele;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Emprunt {
    private final int id;
    private final LocalDate dateEmprunt;
    private final String status;
    private final List<EmpruntDetails> empruntDetailsList;

    // A mettre dans le service
    public void getItems() {}
}
