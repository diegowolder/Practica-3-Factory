package es.factoria;

/**
 * Exception thrown when a Worker is not found in the Factory.
 */
public class NotFoundException extends Exception {

    /**
     * Constructor.
     * @param message error message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
