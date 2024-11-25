package proyectodeestructura;

public class NodoElemento {
    private elemento dato;  // Aquí almacenamos el dato de tipo elemento
    private NodoElemento siguiente;  
    public NodoElemento(elemento dato) {
        this.dato = dato;
        this.siguiente = null;  
    }

    public elemento getDato() {
        return dato;  
    }

    public NodoElemento getSiguiente() {
        return siguiente;  
    }

    public void setSiguiente(NodoElemento siguiente) {
        this.siguiente = siguiente;  
    }
}
