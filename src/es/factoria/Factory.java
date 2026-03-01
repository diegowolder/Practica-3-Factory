package es.factoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa la factoría.
 * Gestiona una lista de todos los trabajadores y permite listar sus salarios.
 *
 * @author Diego A.
 * @version 1.0
 */
public class Factory {

    private String name;
    private List<Worker> workers; // lista de todos los workers de la empresa

    /**
     * Constructor vacío: crea la factoría sin nombre, pero inicializa la lista.
     */
    public Factory() {
        this.workers = new ArrayList<>();
    }

    /**
     * Constructor con nombre.
     * @param pName nombre de la factoría
     */
    public Factory(String pName) {
        this(); // reutilizamos el constructor vacío
        this.name = pName;
    }

    /** Cambia el nombre de la factoría */
    public void setName(String pName) {
        this.name = pName;
    }

    /** Devuelve el nombre de la factoría */
    public String getName() {
        return name;
    }

    /**
     * Añade un worker a la factoría si no estaba ya registrado.
     * Usamos stream + anyMatch para comprobar si ya existe.
     * @param pNewWorker worker a añadir
     * @throws OverrideException si el worker ya estaba en la lista
     */
    public void addWorker(Worker pNewWorker) throws OverrideException {
        // comprobamos con stream si ya existe un worker con el mismo DNI
        boolean yaExiste = workers.stream().anyMatch(w -> w.equals(pNewWorker));
        if (yaExiste) {
            throw new OverrideException("El Worker " + pNewWorker.getDni() + " ya está en la Factory.");
        }
        workers.add(pNewWorker);
    }

    /** Devuelve la lista de workers */
    public List<Worker> getWorkers() {
        return workers;
    }

    /**
     * Busca un worker por su DNI.
     * Usamos stream + filter + findFirst para buscarlo de forma funcional.
     * @param pDni DNI del worker a buscar
     * @return el worker encontrado
     * @throws NotFoundException si no existe ningún worker con ese DNI
     */
    public Worker getWorker(String pDni) throws NotFoundException {
        return workers.stream()
                .filter(w -> w.getDni().equals(pDni))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No existe ningún Worker con DNI: " + pDni));
    }

    /**
     * Genera un listado con el nombre, DNI y salario de cada worker.
     * Aquí aplicamos programación funcional con streams y lambdas para
     * recorrer todos los workers y calcular sus salarios de forma genérica.
     * @return cadena con el listado de salarios
     */
    public String listSalaryWorkers() {
        String resultado = workers.stream()
                .map(w -> w.getName() + " " + w.getDni() + " " + (int) w.computeSalary())
                .collect(Collectors.joining("\n"));
        return resultado.isEmpty() ? resultado : resultado + "\n";
    }

    /** Devuelve el nombre de la factoría */
    @Override
    public String toString() {
        return name;
    }
}
