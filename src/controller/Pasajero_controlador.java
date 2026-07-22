package controller;

import model.Pasajero_modelo;

public class Pasajero_controlador {

    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        return new Pasajero_modelo(nombre, apellido, cedula);
    }
}
