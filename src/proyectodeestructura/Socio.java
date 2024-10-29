package proyectodeestructura;

import java.util.ArrayList;

public class Socio {
    static int numeroSocioGlobal = 0;
    private String nombre;
    private String password;
    private String direccion;
    private int numero;
    private int numeroSocio;
    private int edad;
    public static ArrayList<Socio> socios = new ArrayList<>();

    public Socio(String nombre, String password, int numero, int edad) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.numero = numero;
        this.edad = edad;
        this.numeroSocio = ++numeroSocioGlobal;
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

    public static Socio Encontrar(int numSocio) {
        for (Socio socio : socios) {
            if (socio.getNumeroSocio() == numSocio) {
                return socio;
            }
        }
        return null;
    }

    public static Socio Encontrar(String contra) {
        for (Socio socio : socios) {
            if (socio.getPassword().equals(contra)) {
                return socio;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Socio [nombre=" + nombre + ", numero=" + numero + ", numeroSocio=" + numeroSocio + ", edad=" + edad
                + "]";
    }
}
