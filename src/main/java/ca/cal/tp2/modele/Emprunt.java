package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetails> empruntDetailsList;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

}
