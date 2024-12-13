package proyectodeestructura.structures;

public class Arbol {
    private NodoArbol raiz;

    // Constructor
    public Arbol() {
        this.raiz = null;
    }

    // Método para insertar un nodo en el árbol
    public void insertar(String datoss) {
        NodoArbol nuevo = new NodoArbol(datoss);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarEnArbol(raiz, nuevo);
        }
    }

    private void insertarEnArbol(NodoArbol actual, NodoArbol nuevo) {
        if (nuevo.getDatoss().compareTo(actual.getDatoss()) < 0) {
            if (actual.getHijoIzq() == null) {
                actual.setHijoIzq(nuevo);
            } else {
                insertarEnArbol(actual.getHijoIzq(), nuevo);
            }
        } else {
            if (actual.getHijoDer() == null) {
                actual.setHijoDer(nuevo);
            } else {
                insertarEnArbol(actual.getHijoDer(), nuevo);
            }
        }
    }

    // Método para imprimir los nodos
    public void imprimirTodo() {
        imprimirTodoRecursivo(raiz);
    }

    private void imprimirTodoRecursivo(NodoArbol actual) {
        if (actual != null) {
            System.out.println(actual.getDatoss());
            imprimirTodoRecursivo(actual.getHijoIzq());
            imprimirTodoRecursivo(actual.getHijoDer());
        }
    }
}