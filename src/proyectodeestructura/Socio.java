package proyectodeestructura;

public class Socio {
    private String Nombre;
    private String Dirección;
    private int Numero;
    private String NumeroSocio; // Se puede hacer una combinacion de letras y numeros
    private Integer Edad;

    public Socio(String nombre, String dirección, int numero, String numeroSocio, Integer edad) {
        Nombre = nombre;
        Dirección = dirección;
        Numero = numero;
        NumeroSocio = numeroSocio;
        Edad = edad;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDirección() {
        return Dirección;
    }
    public void setDirección(String dirección) {
        Dirección = dirección;
    }
    public int getNumero() {
        return Numero;
    }
    public void setNumero(int numero) {
        Numero = numero;
    }
    public String getNumeroSocio() {
        return NumeroSocio;
    }
    public void setNumeroSocio(String numeroSocio) {
        NumeroSocio = numeroSocio;
    }
    public Integer getEdad() {
        return Edad;
    }
    public void setEdad(Integer edad) {
        Edad = edad;
    }
}
