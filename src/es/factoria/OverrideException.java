package es.factoria;

/**
 * Exception thrown when a Worker is already assigned to another Executive or Factory.
 */
public class OverrideException extends Exception {

    /**
     * Constructor.
     * @param message error message
     */
    public OverrideException(String message) {
        super(message);
    }
}
