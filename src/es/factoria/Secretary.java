package es.factoria;

/**
 * Represents a Secretary worker with a fixed salary.
 */
public class Secretary extends Worker {

    private static final double SALARYBASE = 1200;
    private Executive executive;

    /**
     * Constructor. Creates a Secretary with name, address and dni.
     * @param pName secretary's name
     * @param pAddress secretary's address
     * @param pDni secretary's DNI
     */
    public Secretary(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
    }

    /**
     * Computes the salary for this Secretary (returns the base salary).
     * @return salary
     */
    @Override
    public double computeSalary() {
        return getSalary();
    }

    /**
     * Sets the executive for this Secretary.
     * @param pExecutive the executive to assign
     */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /** @return the executive of this Secretary */
    public Executive getExecutive() {
        return executive;
    }

    /** @return true if this Secretary has an Executive assigned */
    public boolean hasExecutive() {
        return executive != null;
    }
}
