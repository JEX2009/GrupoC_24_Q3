package proyectodeestructura;

public class Prestamo {
    private Libro LibroPrestado;
    private Bibliotecario BibliotecarioTurno;
    private Socio SocioPresto;
    private String FechaPrestamo;
    private String FechaDevolucion;
    
    public Prestamo(Libro libroPrestado, Bibliotecario bibliotecarioTurno, Socio socioPresto, String fechaPrestamo,
            String fechaDevolucion) {
        LibroPrestado = libroPrestado;
        BibliotecarioTurno = bibliotecarioTurno;
        SocioPresto = socioPresto;
        FechaPrestamo = fechaPrestamo;
        FechaDevolucion = fechaDevolucion;
    }
    public Libro getLibroPrestado() {
        return LibroPrestado;
    }
    public void setLibroPrestado(Libro libroPrestado) {
        LibroPrestado = libroPrestado;
    }
    public Bibliotecario getBibliotecarioTurno() {
        return BibliotecarioTurno;
    }
    public void setBibliotecarioTurno(Bibliotecario bibliotecarioTurno) {
        BibliotecarioTurno = bibliotecarioTurno;
    }
    public Socio getSocioPresto() {
        return SocioPresto;
    }
    public void setSocioPresto(Socio socioPresto) {
        SocioPresto = socioPresto;
    }
    public String getFechaPrestamo() {
        return FechaPrestamo;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        FechaPrestamo = fechaPrestamo;
    }
    public String getFechaDevolucion() {
        return FechaDevolucion;
    }
    public void setFechaDevolucion(String fechaDevolucion) {
        FechaDevolucion = fechaDevolucion;
    }
    @Override
    public String toString() {
        return "Prestamo [LibroPrestado=" + LibroPrestado + ", BibliotecarioTurno=" + BibliotecarioTurno
                + ", SocioPresto=" + SocioPresto + ", FechaPrestamo=" + FechaPrestamo + ", FechaDevolucion="
                + FechaDevolucion + "]";
    }

    
}
