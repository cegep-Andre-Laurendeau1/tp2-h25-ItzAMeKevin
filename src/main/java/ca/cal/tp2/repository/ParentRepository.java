package ca.cal.tp2.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ParentRepository {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp2;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String empTableSql =  "CREATE TABLE EMPRUNTEUR " +
                    "(userid INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " phoneNumber VARCHAR(255), " +
                    " PRIMARY KEY ( userid ))";
            String prepTableSql =  "CREATE TABLE PREPOSE " +
                    "(userid INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " phoneNumber VARCHAR(255), " +
                    " PRIMARY KEY ( userid ))";
            String livreTableSql =  "CREATE TABLE LIVRE " +
                    "(documentId INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " nbExemplaire VARCHAR(255), " +
                    " isbn VARCHAR(255), " +
                    " auteur VARCHAR(255), " +
                    " editeur VARCHAR(255), " +
                    " nbPage INTEGER, " +
                    " PRIMARY KEY ( documentId ))";
            String cdTableSql =  "CREATE TABLE CD " +
                    "(documentId INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " nbExemplaire VARCHAR(255), " +
                    " artiste VARCHAR(255), " +
                    " duree INTEGER, " +
                    " genre VARCHAR(255), " +
                    " PRIMARY KEY ( documentId ))";
            String dvdTableSql =  "CREATE TABLE DVD " +
                    "(documentId INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " nbExemplaire VARCHAR(255), " +
                    " directeur VARCHAR(255), " +
                    " duree INTEGER, " +
                    " rating VARCHAR(255), " +
                    " PRIMARY KEY ( documentId ))";
            statement.executeUpdate(empTableSql);
            statement.executeUpdate(prepTableSql);
            statement.executeUpdate(livreTableSql);
            statement.executeUpdate(cdTableSql);
            statement.executeUpdate(dvdTableSql);
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
