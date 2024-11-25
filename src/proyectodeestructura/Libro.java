package proyectodeestructura;

import java.util.ArrayList;

public class Libro {
    private String Titulo;
    private String Autor;
    private Boolean Disponible;
    private String ISB;
    private String YearPublication; // 19/10/20 En este formato
    public static ArrayList<Libro> libros = new ArrayList<>();
    public static ListaEsperaCOLA listaEspera = new ListaEsperaCOLA();

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
        return "Libro [Titulo=" + Titulo + ", Autor=" + Autor + ", Disponible=" + Disponible + ", ISB=" + ISB
                + ", YearPublication=" + YearPublication + "]";
    }

    public static Libro Encontrar(String titulo) {
        for (Libro titu : libros) {
            if (titu.getTitulo().equalsIgnoreCase(titulo) && titu.getDisponible()) {
                return titu;
            }
        }
        return null;
    }
}
