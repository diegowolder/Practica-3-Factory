package es.factoria;

/**
 * Clase que representa a un vendedor de la factoría.
 * Su salario = salario base + comisión sobre las ventas del mes.
 *
 * @author Diego A.
 * @version 1.0
 */
public class Salesman extends Worker {

    // constantes del salesman
    private static final double COMISSION = 5;    // 5% de comisión sobre ventas
    private static final double SALARYBASE = 1300; // salario base fijo

    private double salesMonth; // total de ventas del mes actual
    private Executive executive; // executive responsable de este salesman

    /**
     * Constructor del Salesman.
     * @param pName nombre
     * @param pAddress dirección
     * @param pDni DNI
     */
    public Salesman(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
        this.salesMonth = 0;
    }

    /**
     * Calcula el salario: base + floor(ventas * 5 / 100)
     */
    @Override
    public double computeSalary() {
        return getSalary() + Math.floor(salesMonth * COMISSION / 100);
    }

    /**
     * Añade una venta al total del mes.
     * @param pSale importe de la venta
     */
    public void newSale(double pSale) {
        salesMonth += pSale;
    }

    /** Devuelve el total de ventas del mes */
    public double getSalesMonth() {
        return salesMonth;
    }

    /** Cambia de mes: resetea las ventas a 0 */
    public void changeMonth() {
        salesMonth = 0;
    }

    /** Asigna el executive responsable */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /** Devuelve el executive de este salesman */
    public Executive getExecutive() {
        return executive;
    }

    /** Comprueba si ya tiene executive asignado */
    public boolean hasExecutive() {
        return executive != null;
    }
}
