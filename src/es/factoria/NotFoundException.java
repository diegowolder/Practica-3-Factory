package es.factoria;

/**
 * Excepción que se lanza cuando se busca un worker que no existe en la factoría.
 *
 * @author Diego A.
 * @version 1.0
 */
public class NotFoundException extends Exception {

    /**
     * Constructor con mensaje de error.
     * @param message descripción del error
     */
    public NotFoundException(String message) {
        super(message);
    }
}
