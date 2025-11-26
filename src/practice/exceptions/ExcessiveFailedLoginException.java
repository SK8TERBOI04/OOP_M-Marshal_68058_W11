package practice.exceptions;

public class ExcessiveFailedLoginException extends Exception {
    public ExcessiveFailedLoginException(String message) {
        super(message);
    }
}
