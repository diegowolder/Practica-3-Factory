package es.factoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Executive worker who manages a list of Salesmen and a Secretary.
 */
public class Executive extends Worker {

    private static final double COMISSION = 2;
    private static final double SALARYBASE = 2500;

    private List<Salesman> salesmen;
    private Secretary secretary;

    /**
     * Constructor. Creates an Executive with name, address and dni.
     * @param pName executive's name
     * @param pAddress executive's address
     * @param pDni executive's DNI
     */
    public Executive(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
        this.salesmen = new ArrayList<>();
    }

    /**
     * Computes salary: base salary + floor(totalSales * COMISSION / 100).
     * @return computed salary
     */
    @Override
    public double computeSalary() {
        double totalSales = 0;
        for (Salesman s : salesmen) {
            totalSales += s.getSalesMonth();
        }
        return getSalary() + Math.floor(totalSales * COMISSION / 100);
    }

    /**
     * Adds a Salesman to this Executive's list if the Salesman has no Executive yet.
     * @param pNewSalesman salesman to add
     * @throws OverrideException if the salesman already has an Executive
     */
    public void addSalesman(Salesman pNewSalesman) throws OverrideException {
        if (pNewSalesman.hasExecutive()) {
            throw new OverrideException("El Salesman " + pNewSalesman.getDni() + " ya tiene un Executive asignado.");
        }
        salesmen.add(pNewSalesman);
        pNewSalesman.setExecutive(this);
    }

    /**
     * Assigns a Secretary to this Executive if the Secretary has no Executive yet.
     * @param pNewSecretary secretary to assign
     * @throws OverrideException if the secretary already has an Executive
     */
    public void setSecretary(Secretary pNewSecretary) throws OverrideException {
        if (pNewSecretary.hasExecutive()) {
            throw new OverrideException("El Secretary " + pNewSecretary.getDni() + " ya tiene un Executive asignado.");
        }
        this.secretary = pNewSecretary;
        pNewSecretary.setExecutive(this);
    }

    /**
     * Returns a listing of all Salesmen (and Secretary if present) of this Executive.
     * @return formatted string listing
     */
    public String listWorkers() {
        StringBuilder sb = new StringBuilder();
        if (secretary != null) {
            sb.append(secretary.getName()).append(" ").append(secretary.getDni())
              .append(" ").append(secretary.getAddress()).append("\n");
        }
        for (Salesman s : salesmen) {
            sb.append(s.getName()).append(" ").append(s.getDni())
              .append(" ").append(s.getAddress()).append("\n");
        }
        return sb.toString();
    }
}
