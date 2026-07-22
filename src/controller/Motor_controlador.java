package controller;

import model.Motor_modelo;

public class Motor_controlador {
    
    public String datosRegistrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        try {
            Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie);
            
            return "Motor registrado correctamente:\n"
                    + "Tipo de motor: " + obj_motor.getTipo_motor() + "\n"
                    + "Caballos de fuerza: " + obj_motor.getCaballos_fuerza() + "\n"
                    + "Número de serie: " + obj_motor.getNumero_serie();

        } catch (IllegalArgumentException e) {
            return "Error de validación: " + e.getMessage();
        }
    }

    public String datosRegistrarMotor(String serie, String tipo){
        return datosRegistrarMotor(tipo, "100", serie);
    }
}
