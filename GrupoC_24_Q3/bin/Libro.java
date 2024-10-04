package GrupoC_24_Q3.bin;

public class Libro {
    private String Titulo;
    private String Autor;
    private Integer ISB ; // Un numero de identificador del libro 
    private String FechaPublicacion; // Se usa de esta manera "2 de septiembre del 1990"
    
    public Libro(String titulo, String autor, Integer iSB, String fechaPublicacion) {
        Titulo = titulo;
        Autor = autor;
        ISB = iSB;
        FechaPublicacion = fechaPublicacion;
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
    public Integer getISB() {
        return ISB;
    }
    public void setISB(Integer iSB) {
        ISB = iSB;
    }
    public String getFechaPublicacion() {
        return FechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

}
