package Practica;

public abstract class Persona {
    protected String nombre; 
    protected long cedula;   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void print(String texto) {
        System.out.println(texto);
    }

    public abstract void informacion();
}