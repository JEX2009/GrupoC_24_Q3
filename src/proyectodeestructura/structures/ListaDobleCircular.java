package proyectodeestructura.structures;

import proyectodeestructura.Libro;

public class ListaDobleCircular {
    private NodoCircular cabeza;
    private NodoCircular cola;


    //Se usa para guardar los libros que comparten autor
    public void add(Libro elemento) {
        if (cabeza == null) {
            this.cabeza = new NodoCircular(elemento);
            this.cola = this.cabeza;
            this.cabeza.setAnterior(this.cola);
            this.cabeza.setSiguiente(this.cola);
            this.cola.setAnterior(this.cabeza);
            this.cola.setSiguiente(this.cabeza);
        } else {
            NodoCircular aux = new NodoCircular(elemento);
            this.cola.setSiguiente(aux);
            aux.setAnterior(cola);
            this.cola = aux;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        }
    }

    public void mostrarLista() {
        NodoCircular actual = this.cabeza;
        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }while (actual == this.cola);
        System.out.println();
    }

    public boolean BusquedaAutor(Libro dato) {
        NodoCircular actual = getCabeza();
        while (actual.getSiguiente() != null) {
            if (dato.getAutor().equals(actual.getDato().getAutor())) {
                return true;
            }
            actual = actual.getSiguiente();
        }return false;
    }

    public NodoCircular getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoCircular cabeza) {
        this.cabeza = cabeza;
    }

    public NodoCircular getCola() {
        return cola;
    }

    public void setCola(NodoCircular cola) {
        this.cola = cola;
    }

}
