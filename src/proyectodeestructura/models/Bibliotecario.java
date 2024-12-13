package proyectodeestructura.models;

import proyectodeestructura.structures.ListaElementos;
import proyectodeestructura.structures.elemento;

public class Bibliotecario extends elemento {
    private String Nombre;
    private String Password; // Se puede hacer un validador para que no se puedan poner contrasenas debiles
    public static ListaElementos bibliotecarios = new ListaElementos();

    public Bibliotecario(String nombre, String password) {
        Nombre = nombre;
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Bibliotecario [Nombre=" + Nombre + ", Password=" + Password + "]";
    }

}
