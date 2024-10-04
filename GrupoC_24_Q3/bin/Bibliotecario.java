package GrupoC_24_Q3.bin;

public class Bibliotecario {
    private String Nombre;
    private String Password; // Se puede hacer un validador para que no se puedan poner contrasenas debiles
    
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

    
}
