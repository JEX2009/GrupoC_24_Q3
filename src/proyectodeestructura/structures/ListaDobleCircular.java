package proyectodeestructura.structures;

public class ListaDobleCircular {
    private NodoParaDoble cabeza;

    public ListaDobleCircular() {
        this.cabeza = null;
    }

    public void insertarInicio(int dato) {
        NodoParaDoble nuevo = new NodoParaDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoParaDoble cola = cabeza.anterior;
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;
            cabeza.anterior = nuevo;
            cola.siguiente = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarFinal(int dato) {
        NodoParaDoble nuevo = new NodoParaDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoParaDoble cola = cabeza.anterior;
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;
            cabeza.anterior = nuevo;
            cola.siguiente = nuevo;
        }
    }

    public void eliminarInicio() {
        if (cabeza != null) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                NodoParaDoble cola = cabeza.anterior;
                cabeza = cabeza.siguiente;
                cabeza.anterior = cola;
                cola.siguiente = cabeza;
            }
        }
    }

    public void eliminarFinal() {
        if (cabeza != null) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                NodoParaDoble cola = cabeza.anterior;
                NodoParaDoble nuevaCola = cola.anterior;
                nuevaCola.siguiente = cabeza;
                cabeza.anterior = nuevaCola;
            }
        }
    }

    public void mostrarLista() {
        if (cabeza != null) {
            NodoParaDoble actual = cabeza;
            do {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            } while (actual != cabeza);
            System.out.println();
        }
    }
}