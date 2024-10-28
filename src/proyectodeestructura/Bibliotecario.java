package proyectodeestructura;

import java.util.ArrayList;

public class Bibliotecario {
    private String Nombre;
    private String Password; // Se puede hacer un validador para que no se puedan poner contrasenas debiles
    public static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<Bibliotecario>();
    
    public static void setBibliotecarios(ArrayList<Bibliotecario> Bibliotecarios) {
        bibliotecarios = Bibliotecarios;
    }
    public static ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

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
    public static Bibliotecario Encontrar(String contra){
        for(Bibliotecario bibi:bibliotecarios ){
            if(bibi.getPassword().equals(contra)){
                return bibi;
            }
        }
        return null;
    }
    
}
