package proyectodeestructura;

public class Cola {
    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Prestamo socio) {
        NodoCola nuevoNodo = new NodoCola(socio);
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

    public void mostrar(){
        frente = this.frente;
        while(fin == null){
            System.out.println(frente.getDato().getFechaDevolucion());
            frente = frente.getSiguiente();
        }
    }
}
