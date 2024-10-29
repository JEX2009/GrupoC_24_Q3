package proyectodeestructura;

public class NodoCola {
    private Prestamo dato;
    private NodoCola siguiente;

    public NodoCola(Prestamo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Prestamo getDato() {
        return dato;
    }

    public void setDato(Prestamo dato) {
        this.dato = dato;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
