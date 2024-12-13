package proyectodeestructura.structures;

import proyectodeestructura.models.Prestamo;

public class NodoArbol {

    private Prestamo dato;
    private NodoArbol hijoIzq;
    private NodoArbol hijoDer;

    // Constructor vacío
    public NodoArbol(Prestamo prestamo) {
        this.dato = prestamo;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    // Getters y setters
    public Prestamo getDatoss() {
        return dato;
    }

    public void setDatoss(Prestamo dato) {
        this.dato = dato;
    }

    public NodoArbol getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoArbol getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }
}
