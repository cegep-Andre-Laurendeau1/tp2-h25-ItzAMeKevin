package ca.cal.tp2.repository;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprunteurRepositoryJPA extends ParentRepositoryJPA implements EmprunteurRepository {

    @Override
    public void saveEmprunteur(Emprunteur emprunteur) throws DatabaseException {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Emprunteur findEmprunteur(String nom, String email) throws DatabaseException {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Utilisateur> query = em.createQuery(
                "SELECT c FROM Utilisateur c WHERE c.nom = :nom AND c.email = :email", Utilisateur.class
            );
            query.setParameter("nom", nom);
            query.setParameter("email", email);
            return (Emprunteur) query.getSingleResult();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

}
