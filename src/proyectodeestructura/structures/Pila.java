package proyectodeestructura.structures;

public class Pila {
    private NodoBusqueda tope;

    public Pila() {
        this.tope = null;
    }

    public void add(String busqueda) {
        NodoBusqueda nuevoNodo = new NodoBusqueda(busqueda);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public String desapilar() {
        if (estaVacia()) {
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
