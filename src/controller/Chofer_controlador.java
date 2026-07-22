package controller;

import model.chofer_modelo;

public class Chofer_controlador {
    
    public String datosRegistrarChofer(String nombre, String apellido, String cedula, String licencia){
        try {
            chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia);
            
            return "Chofer registrado correctamente:\n"
                    + "Nombre del chofer: " + obj_chofer.getNombre_chofer() + "\n"
                    + "Apellido del chofer: " + obj_chofer.getApellido_chofer() + "\n"
                    + "Cédula del chofer: " + obj_chofer.getCedula_chofer() + "\n"
                    + "Licencia del chofer: " + obj_chofer.getLicencia_chofer();

        } catch (IllegalArgumentException e) {
            return "Error de validación: " + e.getMessage();
        }
    }

    public String tomar_datos_chofer(String nombre, String apellido, String cedula, String licencia){
        return datosRegistrarChofer(nombre, apellido, cedula, licencia);
    }
}
