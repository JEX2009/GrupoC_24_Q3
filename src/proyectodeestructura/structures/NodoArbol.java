package proyectodeestructura.structures;

public class NodoArbol {

    private String datoss;
    private NodoArbol hijoIzq;
    private NodoArbol hijoDer;

    // Constructor vacío
    public NodoArbol() {
        this.datoss = "";
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    // Constructor con el atributo datoss
    public NodoArbol(String datoss) {
        this.datoss = datoss;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    // Getters y setters
    public String getDatoss() {
        return datoss;
    }

    public void setDatoss(String datoss) {
        this.datoss = datoss;
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
