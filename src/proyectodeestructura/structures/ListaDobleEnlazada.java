package proyectodeestructura.structures;

public class ListaDobleEnlazada {
    private NodoParaDoble cabeza;
    private NodoParaDoble cola;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarInicio(int dato) {
        NodoParaDoble nuevo = new NodoParaDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarFinal(int dato) {
        NodoParaDoble nuevo = new NodoParaDoble(dato);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void eliminarInicio() {
        if (cabeza != null) {
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
            }
        }
    }

    public void eliminarFinal() {
        if (cola != null) {
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                cola = cola.anterior;
                cola.siguiente = null;
            }
        }
    }

    public void mostrarLista() {
        NodoParaDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
