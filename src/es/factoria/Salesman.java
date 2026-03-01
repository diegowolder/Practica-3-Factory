package es.factoria;

/**
 * Represents a Salesman worker with a base salary plus sales commission.
 */
public class Salesman extends Worker {

    private static final double COMISSION = 5;
    private static final double SALARYBASE = 1300;

    private double salesMonth;
    private Executive executive;

    /**
     * Constructor. Creates a Salesman with name, address and dni.
     * @param pName salesman's name
     * @param pAddress salesman's address
     * @param pDni salesman's DNI
     */
    public Salesman(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
        this.salesMonth = 0;
    }

    /**
     * Computes salary: base salary + floor(salesMonth * COMISSION / 100).
     * @return computed salary
     */
    @Override
    public double computeSalary() {
        return getSalary() + Math.floor(salesMonth * COMISSION / 100);
    }

    /**
     * Adds a new sale amount to this month's total.
     * @param pSale amount of the new sale
     */
    public void newSale(double pSale) {
        this.salesMonth += pSale;
    }

    /** @return total sales this month */
    public double getSalesMonth() {
        return salesMonth;
    }

    /** Resets monthly sales to zero (new month). */
    public void changeMonth() {
        this.salesMonth = 0;
    }

    /**
     * Sets the executive for this Salesman.
     * @param pExecutive the executive to assign
     */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /** @return the executive of this Salesman */
    public Executive getExecutive() {
        return executive;
    }

    /** @return true if this Salesman has an Executive assigned */
    public boolean hasExecutive() {
        return executive != null;
    }
}
