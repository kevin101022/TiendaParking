package controller;

import model.Pasajero_modelo;

public class Pasajero_controlador {
    
    public String datosRegistrarPasajero(String nombre, String apellido, String cedula){
        try {
            Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula);
            
            return "Pasajero registrado correctamente:\n"
                    + "Nombre del pasajero: " + obj_pasajero.getNombre_pasajero() + "\n"
                    + "Apellido del pasajero: " + obj_pasajero.getApellido_pasajero() + "\n"
                    + "Cédula del pasajero: " + obj_pasajero.getCedula_pasajero();

        } catch (IllegalArgumentException e) {
            return "Error de validación: " + e.getMessage();
        }
    }

    public String datosRegistrarPasajero(String nombre, String cedula){
        return datosRegistrarPasajero(nombre, "No especificado", cedula);
    }
}
