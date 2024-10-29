package proyectodeestructura;

public class Cola {
    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(String socio) {
        NodoCola nuevoNodo = new NodoCola(socio);
        if (fin == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public String desencolar() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        String socio = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return socio;
    }

    public String frente() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
