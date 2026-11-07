package Practica;


public class Tecnico extends Obrero { 
    private String clave_acceso;

    public Tecnico(String nombre, long cedula, String codigo, String clave_acceso) {
        super(nombre, cedula, codigo);
        this.clave_acceso = clave_acceso;
    }

    public String getClave_acceso() {
        return clave_acceso;
    }

    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }

    @Override
    public void informacion() {
        print("TÉCNICO - Nombre: " + getNombre() + " | Cédula: " + getCedula() + " | Código: " + codigo);
    }
}