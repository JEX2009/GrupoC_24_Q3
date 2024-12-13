package proyectodeestructura.structures;

import proyectodeestructura.models.Prestamo;

public class Arbol {
    private NodoArbol raiz;

    // Constructor
    public Arbol() {
        this.raiz = null;
    }

    // Método para insertar un nodo en el árbol
    public void add(Prestamo datoss) {
        NodoArbol nuevo = new NodoArbol(datoss);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarEnArbol(raiz, nuevo);
        }
    }

    private void insertarEnArbol(NodoArbol actual, NodoArbol nuevo) {
        String fechaDevolucionNuevo = nuevo.getDatoss().getFechaDevolucion();
        String fechaDevolucionActual = actual.getDatoss().getFechaDevolucion();
    
        // Extraer año, mes y día de ambas fechas
        int anioNuevo = Integer.parseInt(fechaDevolucionNuevo.substring(6, 8));
        int anioActual = Integer.parseInt(fechaDevolucionActual.substring(6, 8));
        int mesNuevo = Integer.parseInt(fechaDevolucionNuevo.substring(3, 5));
        int mesActual = Integer.parseInt(fechaDevolucionActual.substring(3, 5));
        int diaNuevo = Integer.parseInt(fechaDevolucionNuevo.substring(0, 2)); 
        int diaActual = Integer.parseInt(fechaDevolucionActual.substring(0, 2));

        //Se comparan 
        if (anioNuevo < anioActual || 
        (anioNuevo == anioActual && mesNuevo < mesActual) || 
        (anioNuevo == anioActual && mesNuevo == mesActual && diaNuevo < diaActual)) {
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