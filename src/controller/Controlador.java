package controller;

import model.Api_Modelo;
import model.Carro_modelo;
import model.chofer_modelo;
import model.Motor_modelo;
import model.Pasajero_modelo;

// El controlador es el puente entre las vistas (lo que ve el usuario) y los
// modelos (donde viven los datos y las reglas de negocio). No valida nada por
// su cuenta: solo arma el objeto del modelo correspondiente -que se autovalida
// en su constructor- y se lo entrega a Api_Modelo para que quede "guardado".
public class Controlador {

    // Conexión única y compartida para toda la app (se abre una sola vez al cargar la clase)
    private static final Api_Modelo api = new Api_Modelo("root", "http://localhost", "1234");
    static {
        api.validar_conexion();
    }

    //carro
    public Carro_modelo registrarCarro(String placa, String color, String marca, String modelo){
        Carro_modelo obj_carro = new Carro_modelo(placa, color, marca, modelo); // valida los datos al crearse
        api.ingresar_carro(obj_carro);
        return obj_carro;
    }

    // Sobrecarga: registrar un carro sin indicar color, usa un valor por defecto
    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        return registrarCarro(placa, "No especificado", marca, modelo);
    }

    //chofer
    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia); // valida los datos al crearse
        api.registrar_chofer(obj_chofer);
        return obj_chofer;
    }

    //motor
    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie); // valida los datos al crearse
        api.ingresar_motor(obj_motor);
        return obj_motor;
    }

    // Sobrecarga: registrar un motor solo con serie y tipo, usa 100 HP por defecto
    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }

    //pasajero
    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula); // valida los datos al crearse
        api.ingresar_pasajero(obj_pasajero);
        return obj_pasajero;
    }
}
