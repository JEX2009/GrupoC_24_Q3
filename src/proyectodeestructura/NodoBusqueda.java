package proyectodeestructura;

public class NodoBusqueda {
    private String dato;
    private NodoBusqueda siguiente;

    public NodoBusqueda(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoBusqueda getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBusqueda siguiente) {
        this.siguiente = siguiente;
    }
}
