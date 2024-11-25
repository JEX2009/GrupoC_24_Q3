package proyectodeestructura.structures;

class NodoParaDoble {
    int dato;
    NodoParaDoble anterior;
    NodoParaDoble siguiente;

    public NodoParaDoble(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoParaDoble getAnterior() {
        return anterior;
    }

    public NodoParaDoble getSiguiente() {
        return siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setAnterior(NodoParaDoble anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoParaDoble siguiente) {
        this.siguiente = siguiente;
    }

}