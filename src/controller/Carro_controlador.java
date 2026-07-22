package controller;

import model.Carro_modelo;

public class Carro_controlador {

    public Carro_modelo registrarCarro(String placa, String color, String marca, String modelo){
        return new Carro_modelo(placa, color, marca, modelo);
    }

    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        return registrarCarro(placa, "No especificado", marca, modelo);
    }
}
