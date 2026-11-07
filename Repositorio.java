package Practica;

import java.util.ArrayList;

public class Repositorio<T extends Persona> { 
    private ArrayList<T> elementos = new ArrayList<>(); 

    public void registrar(T item) {
        elementos.add(item);
    }

    public T consultar(long cedula) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getCedula() == cedula) {
                return elementos.get(i);
            }
        }
        return null;
    }

    public boolean validarDuplicado(long cedula) {
        for (T item : elementos) {
            if (item.getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> listar() {
        return elementos;
    }
}