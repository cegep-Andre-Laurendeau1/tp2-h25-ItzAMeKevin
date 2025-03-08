package ca.cal.tp2.modele;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;
}
