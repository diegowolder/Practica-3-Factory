package es.factoria;

/**
 * Clase abstracta que representa a un trabajador de la factoría.
 * Todos los tipos de trabajadores heredan de esta clase.
 *
 * @author Diego A.
 * @version 1.0
 */
public abstract class Worker {

    // atributos del trabajador
    private String name;
    private String address;
    private String dni;
    private double salary;

    /**
     * Constructor de Worker.
     * @param pName nombre del trabajador
     * @param pAddress dirección del trabajador
     * @param pDni DNI del trabajador
     */
    public Worker(String pName, String pAddress, String pDni) {
        this.name = pName;
        this.address = pAddress;
        this.dni = pDni;
    }

    /** Devuelve el nombre del trabajador */
    public String getName() {
        return name;
    }

    /** Devuelve el DNI del trabajador */
    public String getDni() {
        return dni;
    }

    /** Devuelve la dirección del trabajador */
    public String getAddress() {
        return address;
    }

    /** Cambia la dirección (puede cambiar con el tiempo) */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devuelve una cadena con nombre, dni y dirección separados por comas.
     */
    @Override
    public String toString() {
        return name + ", " + dni + ", " + address;
    }

    /**
     * Dos workers son iguales si tienen el mismo DNI.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Worker)) return false;
        Worker otro = (Worker) obj;
        return this.dni.equals(otro.dni);
    }

    /**
     * Método abstracto para calcular el salario del trabajador.
     * Cada subclase lo implementa a su manera.
     * @return salario calculado
     */
    public abstract double computeSalary();

    /** Devuelve el salario base */
    public double getSalary() {
        return salary;
    }

    /** Establece el salario base */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
