package proyectodeestructura.models;

import proyectodeestructura.structures.ListaDobleEnlazada;
import proyectodeestructura.structures.ListaElementos;
import proyectodeestructura.structures.ListaEsperaCOLA;
import proyectodeestructura.structures.elemento;

public class Libro extends elemento {
    private String Titulo;
    private String Autor;
    private Boolean Disponible;
    private String ISB;
    private String YearPublication; // 19/10/20 En este formato
    public static ListaElementos libros = new ListaElementos();
    public static ListaEsperaCOLA listaEspera = new ListaEsperaCOLA();
    public static ListaDobleEnlazada listaDeAutores = new ListaDobleEnlazada();

    public Libro(String titulo, String autor, String iSB, String fechaPublicacion) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.Disponible = true;
        this.ISB = iSB;
        this.YearPublication = fechaPublicacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getISB() {
        return ISB;
    }

    public void setISB(String iSB) {
        ISB = iSB;
    }

    public String getYearPublication() {
        return YearPublication;
    }

    public void setYearPublication(String yearPublication) {
        YearPublication = yearPublication;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    @Override
    public String toString() {
        return "La informacion de " + Titulo + ", Autor=" + Autor + ", Disponible=" + Disponible + ", ISB=" + ISB
                + ", YearPublication=" + YearPublication + "]";
    }

}
