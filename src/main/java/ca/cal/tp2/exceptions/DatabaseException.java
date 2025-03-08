package ca.cal.tp2.exceptions;

public class DatabaseException extends Exception {
    public DatabaseException(Exception e) {
        super(e);
    }
}
