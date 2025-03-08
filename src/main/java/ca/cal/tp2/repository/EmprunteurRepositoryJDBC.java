package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunteur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprunteurRepositoryJDBC extends ParentRepository implements EmprunteurRepository {

    @Override
    public void saveEmprunteur(Emprunteur emprunteur) {
        try(PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO EMPRUNTEUR (userID, name, email, phoneNumber) VALUES (?, ?, ?, ?)"
        )) {
            preparedStatement.setInt(1, emprunteur.getId());
            preparedStatement.setString(2, emprunteur.getName());
            preparedStatement.setString(3, emprunteur.getEmail());
            preparedStatement.setString(4, emprunteur.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Emprunteur findEmprunteurById(int id) {
        try(PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT * FROM EMPRUNTEUR WHERE userId = ?"
        )) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Emprunteur(
                        resultSet.getInt("userId"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
