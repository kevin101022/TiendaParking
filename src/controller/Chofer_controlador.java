package controller;

import model.chofer_modelo;

public class Chofer_controlador {

    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        return new chofer_modelo(nombre, apellido, cedula, licencia);
    }
}
