package Practica;

import java.util.ArrayList;

public class Controlador { 
    private Repositorio<Persona> repoPersona = new Repositorio<>();

    public String registrarAdministrativo(String nombre, String cedulaStr, String cargo) {
        try {
            if (nombre.isEmpty() || cedulaStr.isEmpty() || cargo.isEmpty()) {
                return "Error: Todos los campos son obligatorios [RF-06].";
            }
            if (cedulaStr.length() != 10) {
                return "Error: La cédula debe tener exactamente 10 dígitos [RF-06].";
            }
            long cedula = Long.parseLong(cedulaStr); // Parsing / Boxing
            if (repoPersona.validarDuplicado(cedula)) {
                return "Error: La cédula ya se encuentra registrada [RF-06].";
            }

            Administrativo adm = new Administrativo(nombre, cedula, cargo);
            repoPersona.registrar(adm);
            return "Administrativo registrado exitosamente [RF-01].";
        } catch (NumberFormatException e) {
            return "Error: La cédula debe contener solo números [RF-06].";
        }
    }

    public String registrarObrero(String nombre, String cedulaStr, String codigo) {
        try {
            if (nombre.isEmpty() || cedulaStr.isEmpty() || codigo.isEmpty()) {
                return "Error: Todos los campos son obligatorios [RF-06].";
            }
            if (cedulaStr.length() != 10) {
                return "Error: La cédula debe tener exactamente 10 dígitos [RF-06].";
            }
            long cedula = Long.parseLong(cedulaStr);
            if (repoPersona.validarDuplicado(cedula)) {
                return "Error: La cédula ya se encuentra registrada [RF-06].";
            }

            Obrero obr = new Obrero(nombre, cedula, codigo);
            repoPersona.registrar(obr);
            return "Obrero registrado exitosamente [RF-02].";
        } catch (NumberFormatException e) {
            return "Error: La cédula debe contener solo números [RF-06].";
        }
    }

    public String registrarTecnico(String nombre, String cedulaStr, String codigo, String clave) {
        try {
            if (nombre.isEmpty() || cedulaStr.isEmpty() || codigo.isEmpty() || clave.isEmpty()) {
                return "Error: Todos los campos son obligatorios [RF-06].";
            }
            if (cedulaStr.length() != 10) {
                return "Error: La cédula debe tener exactamente 10 dígitos [RF-06].";
            }
            long cedula = Long.parseLong(cedulaStr);
            if (repoPersona.validarDuplicado(cedula)) {
                return "Error: La cédula ya se encuentra registrada [RF-06].";
            }

            Tecnico tec = new Tecnico(nombre, cedula, codigo, clave);
            repoPersona.registrar(tec);
            return "Técnico registrado exitosamente [RF-03].";
        } catch (NumberFormatException e) {
            return "Error: La cédula debe contener solo números [RF-06].";
        }
    }

    public String consultarPorCedula(String cedulaStr) {
        try {
            long cedula = Long.parseLong(cedulaStr);
            Persona p = repoPersona.consultar(cedula);
            if (p != null) {
                return "Empleado Encontrado [RF-04] -> Nombre: " + p.getNombre() + " | Cédula: " + p.getCedula();
            }
            return "No se encontró ningún empleado con esa cédula [RF-04].";
        } catch (NumberFormatException e) {
            return "Error: Ingrese una cédula válida para consultar.";
        }
    }

    public String listarTodos() {
        StringBuilder sb = new StringBuilder("=== LISTADO DE EMPLEADOS [RF-05] ===\n");
        ArrayList<Persona> lista = repoPersona.listar();
        if (lista.isEmpty()) {
            return "No hay empleados registrados.";
        }
        for (Persona p : lista) {
            sb.append("- ").append(p.getNombre()).append(" (Cédula: ").append(p.getCedula()).append(")\n");
        }
        return sb.toString();
    }
}
