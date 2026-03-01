package es.factoria;

/**
 * Clase que representa a un secretario/a de la factoría.
 * Su salario es fijo, sin comisiones.
 *
 * @author Diego A.
 * @version 1.0
 */
public class Secretary extends Worker {

    // el salario base del secretario es fijo: 1200€
    private static final double SALARYBASE = 1200;
    private Executive executive; // el executive al que está asignado (puede ser null)

    /**
     * Constructor del Secretary.
     * @param pName nombre
     * @param pAddress dirección
     * @param pDni DNI
     */
    public Secretary(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
    }

    /**
     * El salario del secretario es simplemente el salario base, sin comisiones.
     */
    @Override
    public double computeSalary() {
        return getSalary();
    }

    /** Asigna un executive a este secretary */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /** Devuelve el executive de este secretary */
    public Executive getExecutive() {
        return executive;
    }

    /** Comprueba si ya tiene executive asignado */
    public boolean hasExecutive() {
        return executive != null;
    }
}
