package proyectodeestructura;

import java.util.ArrayList;

public class Socio {
    static int NumeroSocioGlobal = 0;
    private String Nombre;
    private String Password;
    private int Numero;
    private int NumeroSocio; // Se puede hacer una combinacion de letras y numeros
    private int Edad;
    public static ArrayList<Socio> socios = new ArrayList<Socio>();
    public Socio(String nombre, String password, int numero, int edad) {
        Nombre = nombre;
        Password = password;
        Numero = numero;
        NumeroSocioGlobal ++;
        NumeroSocio = NumeroSocioGlobal;
        Edad = edad;
        
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
    public int getNumero() {
        return Numero;
    }
    public void setNumero(int numero) {
        Numero = numero;
    }
    public int getNumeroSocio() {
        return NumeroSocio;
    }
    public void setNumeroSocio(int numeroSocio) {
        NumeroSocio = numeroSocio;
    }
    public int getEdad() {
        return Edad;
    }
    public void setEdad(int edad) {
        Edad = edad;
    }
    public static Socio Encontrar(int numSoci){
        for(Socio soci:socios ){
            if(soci.getNumeroSocio() == numSoci){
                return soci;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Socio [Nombre=" + Nombre + ", Password=" + Password + ", Numero=" + Numero + ", NumeroSocio="
                + NumeroSocio + ", Edad=" + Edad + "]";
    }
    public static Socio Encontrar(String contra){
        for(Socio soci:socios ){
            if(soci.getPassword().equals(contra)){
                return soci;
            }
        }
        return null;
    }
}
