package proyectodeestructura;

public class Libro {
    private String Titulo;
    private String Autor;
    private Integer Cantidad;
    private String ISB; // Un numero de identificador del libro
    private String YearPublication; // Se usa de esta manera "2 de septiembre del 1990"

    public Libro(String titulo, String autor, Integer cantidad, String iSB, String fechaPublicacion) {
        Titulo = titulo;
        Autor = autor;
        Cantidad = cantidad;
        ISB = iSB;
        YearPublication = fechaPublicacion;
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

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

}
