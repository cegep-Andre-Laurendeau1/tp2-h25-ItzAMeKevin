package ca.cal.tp2.modele;

import jakarta.persistence.*;
import java.util.*;

@Entity
@DiscriminatorValue("EMPRUNTEUR")
public class Emprunteur extends Utilisateur {

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes = new ArrayList<>();

    public Emprunteur(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public Emprunteur() {

    }
}
