package proyectodeestructura.structures;

import proyectodeestructura.Libro;

public class NodoCircular {
    private Libro dato;
    private NodoCircular anterior;
    private NodoCircular siguiente;

    public NodoCircular(Libro dato) {
        this.dato = dato;
    }

    public Libro getDato() {
        return dato;
    }

    public void setDato(Libro dato) {
        this.dato = dato;
    }

    public NodoCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular anterior) {
        this.anterior = anterior;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }

}
