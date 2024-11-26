package proyectodeestructura.structures;

import proyectodeestructura.models.Bibliotecario;
import proyectodeestructura.models.Libro;
import proyectodeestructura.models.Socio;

public class ListaElementos {
    private NodoElemento cabeza;

    public void add(elemento elemento) {
        NodoElemento nuevoNodo = new NodoElemento(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoElemento actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void imprimirLista() {
        NodoElemento actual = cabeza;
        System.out.println("Elementos en la lista:");
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    // De aca en adelante se aniaden metodos especificos para cada clase

    // Clase socio
    public Socio Encontrar(int numSocio) {
        NodoElemento auxiliar = cabeza;
        while (auxiliar != null) {
            if (auxiliar.getDato() instanceof Socio) {
                Socio socio = (Socio) auxiliar.getDato();
                if (socio.getNumeroSocio() == numSocio) {
                    return socio;
                }
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return null;
    }

    public Socio Encontrar(String contra) {
        NodoElemento auxiliar = cabeza;
        while (auxiliar != null) {
            if (auxiliar.getDato() instanceof Socio) {
                Socio socio = (Socio) auxiliar.getDato();
                if (socio.getPassword().equals(contra)) {
                    return socio;
                }
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return null;
    }

    // Clase Libro
    public Libro EncontrarL(String titulo) {
        NodoElemento auxiliar = cabeza;
        while (auxiliar != null) {
            if (auxiliar.getDato() instanceof Libro) {
                Libro libro = (Libro) auxiliar.getDato();
                if (libro.getTitulo().equals(titulo)) {
                    return libro;
                }
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return null;
    }

    // Clase Bibliotecario
    public Bibliotecario EncontrarB(String titulo) {
        NodoElemento auxiliar = cabeza;
        while (auxiliar != null) {
            if (auxiliar.getDato() instanceof Bibliotecario) {
                Bibliotecario bibliotecario = (Bibliotecario) auxiliar.getDato();
                if (bibliotecario.getPassword().equals(titulo)) {
                    return bibliotecario;
                }
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return null;
    }

    // Clase Prestamo

}
