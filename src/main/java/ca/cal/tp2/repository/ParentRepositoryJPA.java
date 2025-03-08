package ca.cal.tp2.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class ParentRepositoryJPA {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio.pu");
}
