package controller;

import model.Motor_modelo;

public class Motor_controlador {

    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        return new Motor_modelo(tipo, caballosFuerza, numeroSerie);
    }

    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }
}
