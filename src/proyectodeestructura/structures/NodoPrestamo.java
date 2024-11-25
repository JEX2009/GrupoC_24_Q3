package proyectodeestructura.structures;

import proyectodeestructura.Prestamo;

public class NodoPrestamo {
    private Prestamo dato;
    private NodoPrestamo siguiente;

    public NodoPrestamo(Prestamo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Prestamo getDato() {
        return dato;
    }

    public void setDato(Prestamo dato) {
        this.dato = dato;
    }

    public NodoPrestamo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPrestamo siguiente) {
        this.siguiente = siguiente;
    }
}
