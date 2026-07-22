package controller;

import model.Carro_modelo;

public class Carro_controlador {
    
    public String datosRegistrarCarro(String placa, String color, String marca, String modelo){
        try {
            Carro_modelo obj_carro = new Carro_modelo(placa, color, marca, modelo);
            
            return "Carro registrado correctamente:\n"
                    + "Placa del carro: " + obj_carro.getPlaca_carro() + "\n"
                    + "Color del carro: " + obj_carro.getColor_carro() + "\n"
                    + "Marca del carro: " + obj_carro.getMarca_carro() + "\n"
                    + "Modelo del carro: " + obj_carro.getModelo_carro();

        } catch (IllegalArgumentException e) {
            return "Error de validación: " + e.getMessage();
        }
    }

    public String datosRegistrarCarro(String placa, String marca, String modelo){
        return datosRegistrarCarro(placa, "No especificado", marca, modelo);
    }
}
