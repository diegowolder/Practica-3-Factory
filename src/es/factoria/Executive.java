package es.factoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase que representa a un ejecutivo de la factoría.
 * Un executive tiene a su cargo varios salesmen y un secretary.
 * Su salario = base + 2% de las ventas totales de sus salesmen.
 */
public class Executive extends Worker {

    private static final double COMISSION = 2;     // 2% sobre las ventas del equipo
    private static final double SALARYBASE = 2500; // salario base del executive

    private List<Salesman> salesmen; // lista de vendedores a su cargo
    private Secretary secretary;     // su secretario/a

    /**
     * Constructor del Executive.
     * @param pName nombre
     * @param pAddress dirección
     * @param pDni DNI
     */
    public Executive(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        setSalary(SALARYBASE);
        this.salesmen = new ArrayList<>();
    }

    /**
     * Calcula el salario del executive: base + floor(2% * ventas totales del equipo).
     * Usamos stream para sumar las ventas de todos los salesmen de forma más limpia.
     */
    @Override
    public double computeSalary() {
        // sumamos las ventas de todos los salesmen con un stream
        double totalVentas = salesmen.stream()
                .mapToDouble(Salesman::getSalesMonth)
                .sum();
        return getSalary() + Math.floor(totalVentas * COMISSION / 100);
    }

    /**
     * Añade un salesman al executive, pero solo si ese salesman no tiene executive ya.
     * @param pNewSalesman el salesman a añadir
     * @throws OverrideException si el salesman ya tiene executive asignado
     */
    public void addSalesman(Salesman pNewSalesman) throws OverrideException {
        if (pNewSalesman.hasExecutive()) {
            throw new OverrideException("El Salesman " + pNewSalesman.getDni() + " ya tiene un Executive asignado.");
        }
        salesmen.add(pNewSalesman);
        pNewSalesman.setExecutive(this);
    }

    /**
     * Asigna un secretary al executive, solo si ese secretary no tiene executive todavía.
     * @param pNewSecretary el secretary a asignar
     * @throws OverrideException si el secretary ya tiene executive
     */
    public void setSecretary(Secretary pNewSecretary) throws OverrideException {
        if (pNewSecretary.hasExecutive()) {
            throw new OverrideException("El Secretary " + pNewSecretary.getDni() + " ya tiene un Executive asignado.");
        }
        this.secretary = pNewSecretary;
        pNewSecretary.setExecutive(this);
    }

    /**
     * Lista todos los trabajadores del executive (secretary primero, luego salesmen).
     * Usamos Stream.concat para unir el stream del secretary con el de los salesmen.
     * @return cadena con nombre, dni y dirección de cada uno
     */
    public String listWorkers() {
        // si hay secretary lo ponemos al inicio, si no stream vacío
        Stream<Worker> streamSecretary = secretary != null
                ? Stream.of(secretary)
                : Stream.empty();

        // concatenamos secretary + salesmen y generamos la cadena
        String resultado = Stream.concat(streamSecretary, salesmen.stream())
                .map(w -> w.getName() + " " + w.getDni() + " " + w.getAddress())
                .collect(Collectors.joining("\n"));
        return resultado.isEmpty() ? resultado : resultado + "\n";
    }
}
