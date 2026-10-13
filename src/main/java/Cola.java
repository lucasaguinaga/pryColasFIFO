import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola {
    private final Queue<Pasajero> coleccion;
    private static final int ASIENTO_MIN = 1;
    private static final int ASIENTO_MAX = 30;

    public Cola() {
        coleccion = new LinkedList<>();
    }

    public void agregar(Pasajero p) {
        if (p == null) {
            throw new IllegalArgumentException("El pasajero no puede ser nulo");
        }

        // R1: se valida todo ANTES de tocar la colección.
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del pasajero no puede estar vacío");
        }
        validarRangoAsiento(p.getNumeroAsiento());

        // TODO R1 (persona 2): validar que el asiento no esté repetido.
        for (Pasajero pendiente : coleccion){
            if (pendiente.getNumeroAsiento() == p.getNumeroAsiento()){
                throw new IllegalArgumentException("El asiento " + p.getNumeroAsiento() + "ya está ocupado");
            }
        }

        coleccion.offer(p);
    }

    // Método auxiliar: lo reutilizan agregar, buscar, posición y cancelar.
    private void validarRangoAsiento(int asiento) {
        if (asiento < ASIENTO_MIN || asiento > ASIENTO_MAX) {
            throw new IllegalArgumentException(
                    "El asiento debe estar entre " + ASIENTO_MIN + " y " + ASIENTO_MAX);
        }
    }

    public Pasajero extraer() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.poll();
    }

    public Pasajero frente() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.peek();
    }

    public int size() {
        return coleccion.size();
    }

    public boolean estaVacia() {
        return coleccion.isEmpty();
    }

    public List<Pasajero> obtenerPendientes() {
        return Collections.unmodifiableList(new ArrayList<>(coleccion));
    }

    public Pasajero buscarPorAsiento(int asiento) {
        // TODO R2: validar rango y buscar sin retirar pasajeros.
        validarRangoAsiento(asiento);
        for (Pasajero p : coleccion) {
            if (p.getNumeroAsiento() == asiento) {
                return p;
            }
        }
        return null;
    }

    public int posicionPorAsiento(int asiento) {
        // TODO R2: posiciones desde 1; devolver -1 si no está en la fila.
        validarRangoAsiento(asiento);
        int posicion=1;
        for (Pasajero p: coleccion){
            if (p.getNumeroAsiento()==asiento) {
                return posicion;
            }
            posicion++;
        }
        return -1;
    }

    public Pasajero cancelarPorAsiento(int asiento) {
        // TODO R3: retirar únicamente al indicado y conservar el orden restante.
        throw new UnsupportedOperationException("Pendiente implementar R3: cancelación");
    }

    @Override
    public String toString() {
        if (coleccion.isEmpty()) {
            return "Cola sin elementos";
        }
        StringBuilder sb = new StringBuilder();
        int posicion = 1;
        for (Pasajero p : coleccion) {
            sb.append(posicion++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }
}
