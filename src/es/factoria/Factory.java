package es.factoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Factory with a name and a list of Workers.
 */
public class Factory {

    private String name;
    private List<Worker> workers;

    /**
     * Default constructor. Creates a Factory without a specific name.
     */
    public Factory() {
        this.workers = new ArrayList<>();
    }

    /**
     * Constructor that creates a Factory with a specific name.
     * @param pName factory name
     */
    public Factory(String pName) {
        this();
        this.name = pName;
    }

    /** @param pName new name for the Factory */
    public void setName(String pName) {
        this.name = pName;
    }

    /** @return the name of the Factory */
    public String getName() {
        return name;
    }

    /**
     * Adds a Worker to the Factory if the Worker is not already registered.
     * @param pNewWorker worker to add
     * @throws OverrideException if the worker is already in the Factory
     */
    public void addWorker(Worker pNewWorker) throws OverrideException {
        if (workers.contains(pNewWorker)) {
            throw new OverrideException("El Worker " + pNewWorker.getDni() + " ya está en la Factory.");
        }
        workers.add(pNewWorker);
    }

    /** @return the list of workers */
    public List<Worker> getWorkers() {
        return workers;
    }

    /**
     * Returns a Worker with the given DNI.
     * @param pDni DNI to search for
     * @return the Worker found
     * @throws NotFoundException if no Worker with that DNI exists
     */
    public Worker getWorker(String pDni) throws NotFoundException {
        for (Worker w : workers) {
            if (w.getDni().equals(pDni)) {
                return w;
            }
        }
        throw new NotFoundException("No existe ningún Worker con DNI: " + pDni);
    }

    /**
     * Returns a string listing all Workers and their computed salaries.
     * @return formatted salary listing
     */
    public String listSalaryWorkers() {
        StringBuilder sb = new StringBuilder();
        for (Worker w : workers) {
            sb.append(w.getName()).append(" ").append(w.getDni())
              .append(" ").append((int) w.computeSalary()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns a string with the factory name.
     * @return factory description
     */
    @Override
    public String toString() {
        return name;
    }
}
