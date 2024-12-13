package proyectodeestructura.structures;

import proyectodeestructura.models.*;

public class ListaDobleEnlazada {
    private NodoParaDoble cabeza;

    public ListaDobleEnlazada() {
        cabeza = null;
    }

    // Guarda las distintas listas en una sola
    private void add(ListaDobleCircular dato) {
        NodoParaDoble nuevoNodo = new NodoParaDoble(dato);
        if (getCabeza() == null) {
            setCabeza(nuevoNodo);
        } else {
            NodoParaDoble actual = getCabeza();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
        }
    }

    public void AgregarLibro(Libro dato) {
        NodoParaDoble actual = getCabeza();
        if (actual != null) {
            while (actual.getSiguiente() != null) {
                if (actual.getLista().BusquedaAutor(dato)) {
                    actual.getLista().add(dato);
                }
                actual = actual.getSiguiente();
            }
        }
        ListaDobleCircular Nueva = new ListaDobleCircular();
        Nueva.add(dato);
        add(Nueva);
    }

    public void mostrarLibrosPorAutor(String autor) {
        NodoParaDoble actual = getCabeza();
        boolean encontrado = false; // Bandera para indicar si se encontró el autor
        do {
            // Verificar si la lista circular actual contiene libros del autor buscado
            if (actual.getLista().BusquedaAutor(new Libro("", autor, "", ""))) {
                System.out.println("Libros de " + autor + ":");
                actual.getLista().mostrarLista(); // Mostrar la lista circular
                encontrado = true;
                break; // Salir del bucle ya que se encontró el autor
            }
            actual = actual.getSiguiente();
        }while (actual == getCabeza());

        if (!encontrado) {
            System.out.println("No se encontraron libros del autor " + autor);
        }
    }

    public NodoParaDoble getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoParaDoble cabeza) {
        this.cabeza = cabeza;
    }

}