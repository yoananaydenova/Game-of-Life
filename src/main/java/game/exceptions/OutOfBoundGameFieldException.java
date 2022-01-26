package game.exceptions;

public class OutOfBoundGameFieldException extends RuntimeException {
    public OutOfBoundGameFieldException(String errorMessage) {
        super(errorMessage);
    }
}
