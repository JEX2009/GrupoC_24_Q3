package proyectodeestructura.models;

import proyectodeestructura.structures.ListaElementos;
import proyectodeestructura.structures.Pila;
import proyectodeestructura.structures.elemento;

public class Socio extends elemento {
    static int numeroSocioGlobal = 0;
    private String nombre;
    private String password;
    private int numero;
    private int numeroSocio;
    private int edad;
    public static ListaElementos socios = new ListaElementos();
    private Pila historialBusqueda = new Pila();

    public Socio(String nombre, String password, int numero, int edad) {
        this.nombre = nombre;
        this.password = password;
        this.numero = numero;
        this.edad = edad;
        this.numeroSocio = ++numeroSocioGlobal;
    }

    public Pila getHistorialBusqueda() {
        return historialBusqueda;
    }

    public void setHistorialBusqueda(Pila historialBusqueda) {
        this.historialBusqueda = historialBusqueda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Socio [nombre=" + nombre + ", numero=" + numero + ", numeroSocio=" + numeroSocio + ", edad=" + edad
                + "]";
    }
}
