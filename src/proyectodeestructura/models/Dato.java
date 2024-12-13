package proyectodeestructura.models;

public class Dato {
    private Socio persona;

    public Dato(Socio persona) {
        this.persona = persona;
    }

    public Socio getPersona() {
        return persona;
    }

    public void setPersona(Socio persona) {
        this.persona = persona;
    }
}
