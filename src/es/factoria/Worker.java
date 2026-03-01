package es.factoria;

/**
 * Abstract class representing a Worker in the Factory.
 */
public abstract class Worker {

    private String name;
    private String address;
    private String dni;
    private double salary;

    /**
     * Constructor. Assigns name, address and dni.
     * @param pName worker's name
     * @param pAddress worker's address
     * @param pDni worker's DNI
     */
    public Worker(String pName, String pAddress, String pDni) {
        this.name = pName;
        this.address = pAddress;
        this.dni = pDni;
    }

    /** @return the name of the Worker */
    public String getName() {
        return name;
    }

    /** @return the DNI of the Worker */
    public String getDni() {
        return dni;
    }

    /** @return the address of the Worker */
    public String getAddress() {
        return address;
    }

    /** @param address new address */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a string with name, dni and address separated by commas.
     * @return string representation
     */
    @Override
    public String toString() {
        return name + ", " + dni + ", " + address;
    }

    /**
     * Two workers are equal if they have the same DNI.
     * @param obj object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Worker)) return false;
        Worker other = (Worker) obj;
        return this.dni.equals(other.dni);
    }

    /**
     * Abstract method to compute the salary for this worker.
     * @return computed salary
     */
    public abstract double computeSalary();

    /** @return the base salary */
    public double getSalary() {
        return salary;
    }

    /** @param salary new base salary */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
