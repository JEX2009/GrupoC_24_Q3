package proyectodeestructura.structures;

class NodoParaDoble {
    private ListaDobleCircular lista;
    private NodoParaDoble anterior;
    private NodoParaDoble siguiente;

    public NodoParaDoble(ListaDobleCircular lista) {
        this.lista = lista;
    }

    public ListaDobleCircular getLista() {
        return lista;
    }

    public void setLista(ListaDobleCircular lista) {
        this.lista = lista;
    }

    public NodoParaDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoParaDoble anterior) {
        this.anterior = anterior;
    }

    public NodoParaDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoParaDoble siguiente) {
        this.siguiente = siguiente;
    }

}