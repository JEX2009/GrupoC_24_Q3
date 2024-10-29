package proyectodeestructura;

public class Pila {
    private NodoPila tope;

    public Pila() {
        this.tope = null;
    }

    public void apilar(String busqueda) {
        NodoPila nuevoNodo = new NodoPila(busqueda);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public String desapilar() {
        if (tope == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        String busqueda = tope.getDato();
        tope = tope.getSiguiente();
        return busqueda;
    }

    public String cima() {
        if (tope == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return tope.getDato();
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
