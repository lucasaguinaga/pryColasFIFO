import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola {
    private final Queue<Pasajero> coleccion;

    public Cola() {
        coleccion = new LinkedList<>();
    }

    public void agregar(Pasajero p) {
        if (p == null) {
            throw new IllegalArgumentException("El pasajero no puede ser nulo");
        }

        // TODO R1: validar nombre, asiento entre 1 y 30 y asiento no repetido.
        // Validar ANTES de modificar la colección.

        coleccion.offer(p);
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
        throw new UnsupportedOperationException("Pendiente implementar R2: búsqueda");
    }

    public int posicionPorAsiento(int asiento) {
        // TODO R2: posiciones desde 1; devolver -1 si no está en la fila.
        throw new UnsupportedOperationException("Pendiente implementar R2: posición");
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
