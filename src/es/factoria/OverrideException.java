package es.factoria;

/**
 * Excepción que se lanza cuando se intenta asignar un worker que ya
 * pertenece a otro executive o ya está en la factoría.
 *
 * @author Diego A.
 * @version 1.0
 */
public class OverrideException extends Exception {

    /**
     * Constructor con mensaje de error.
     * @param message descripción del error
     */
    public OverrideException(String message) {
        super(message);
    }
}
