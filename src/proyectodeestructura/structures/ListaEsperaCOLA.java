package proyectodeestructura.structures;

import proyectodeestructura.models.Prestamo;

public class ListaEsperaCOLA {
    private NodoPrestamo frente;
    private NodoPrestamo fin;

    public ListaEsperaCOLA() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Prestamo socio) {
        NodoPrestamo nuevoNodo = new NodoPrestamo(socio);
        if (fin == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public Prestamo desencolar() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        Prestamo socio = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return socio;
    }

    public Prestamo frente() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        NodoPrestamo frente = this.frente;
        // En caso de que este vacia no mostrar cola
        if (frente == null) {
            System.out.println("La lista de espera esta vacia puedes hacer el prestamo");
        } else {
            while (fin == null) {
                System.out.println(frente.getDato().getFechaDevolucion());
                frente = frente.getSiguiente();
            }
        }
    }
}
