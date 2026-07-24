package controller;

import model.Api_Modelo;
import model.Carro_modelo;
import model.chofer_modelo;
import model.Motor_modelo;
import model.Pasajero_modelo;

public class Controlador {

    private static final Api_Modelo api = new Api_Modelo("root", "http://localhost", "1234");
    static {
        api.validar_conexion();
    }

    public Carro_modelo registrarCarro(String placa, String color, String marca, String modelo){
        Carro_modelo obj_carro = new Carro_modelo(placa, color, marca, modelo);
        api.ingresar_carro(obj_carro);
        return obj_carro;
    }

    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        return registrarCarro(placa, "No especificado", marca, modelo);
    }

    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia);
        api.registrar_chofer(obj_chofer);
        return obj_chofer;
    }

    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie);
        api.ingresar_motor(obj_motor);
        return obj_motor;
    }

    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }

    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula);
        api.ingresar_pasajero(obj_pasajero);
        return obj_pasajero;
    }
}
