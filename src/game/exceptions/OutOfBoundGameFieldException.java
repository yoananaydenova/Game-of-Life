package game.exceptions;

public class OutOfBoundGameFieldException extends Exception {
    public OutOfBoundGameFieldException(String errorMessage) {
        super(errorMessage);
    }
}
