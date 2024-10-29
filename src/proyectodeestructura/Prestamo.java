package proyectodeestructura;

public class Prestamo {
    private Libro libroPrestado;
    private Bibliotecario bibliotecarioTurno;
    private Socio socioPresto;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Prestamo(Libro libroPrestado, Bibliotecario bibliotecarioTurno, Socio socioPresto, String fechaPrestamo,
            String fechaDevolucion) {
        this.libroPrestado = libroPrestado;
        this.bibliotecarioTurno = bibliotecarioTurno;
        this.socioPresto = socioPresto;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public Bibliotecario getBibliotecarioTurno() {
        return bibliotecarioTurno;
    }

    public void setBibliotecarioTurno(Bibliotecario bibliotecarioTurno) {
        this.bibliotecarioTurno = bibliotecarioTurno;
    }

    public Socio getSocioPresto() {
        return socioPresto;
    }

    public void setSocioPresto(Socio socioPresto) {
        this.socioPresto = socioPresto;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo [libroPrestado=" + libroPrestado + ", bibliotecarioTurno=" + bibliotecarioTurno
                + ", socioPresto=" + socioPresto + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion="
                + fechaDevolucion + "]";
    }
}
