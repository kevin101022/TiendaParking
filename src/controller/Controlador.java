package controller;

import model.Api_Modelo;
import model.Carro_modelo;
import model.chofer_modelo;
import model.Motor_modelo;
import model.Pasajero_modelo;
import views.Carro_vista;
import views.Chofer_vista;
import views.Menu_vista;
import views.Motor_vista;
import views.Pasajero_vista;
import java.util.Scanner;

// Puente entre las vistas y los modelos. Solo arma y envía el objeto para guardarlo.
public class Controlador {

    // Conexión única para toda la app
    private static final Api_Modelo api = new Api_Modelo("root", "http://localhost", "1234");
    static {
        api.validar_conexion();
    }

    // Punto de entrada del flujo (Controlador coordina las vistas)
    @SuppressWarnings("resource")
    public void iniciar() {
        Scanner teclado = new Scanner(System.in);

        // Instanciar vistas
        Menu_vista vistaMenu = new Menu_vista();
        Chofer_vista vistaChofer = new Chofer_vista();
        Carro_vista vistaCarro = new Carro_vista();
        Motor_vista vistaMotor = new Motor_vista();
        Pasajero_vista vistaPasajero = new Pasajero_vista();

        int opcion = -1;
        while (opcion != 0) {
            opcion = vistaMenu.mostrarMenu(teclado);

            switch (opcion) {
                case 1:
                    vistaChofer.registrar_chofer(teclado, this);
                    break;
                case 2:
                    vistaCarro.registrar_carro(teclado, this);
                    break;
                case 3:
                    vistaMotor.registrar_motor(teclado, this);
                    break;
                case 4:
                    vistaPasajero.registrar_pasajero(teclado, this);
                    break;
                case 0:
                    vistaMenu.mostrarSalida();
                    break;
                default:
                    vistaMenu.mostrarOpcionInvalida();
            }
        }
        teclado.close();
    }

    //carro
    public Carro_modelo registrarCarro(String placa, String color, String marca, String modelo){
        Carro_modelo obj_carro = new Carro_modelo(placa, color, marca, modelo); // Se valida al instanciar
        api.ingresar_carro(obj_carro);
        return obj_carro;
    }

    // Sobrecarga: usa color por defecto
    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        return registrarCarro(placa, "No especificado", marca, modelo);
    }

    //chofer
    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia); // Se valida al instanciar
        api.registrar_chofer(obj_chofer);
        return obj_chofer;
    }

    //motor
    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie); // Se valida al instanciar
        api.ingresar_motor(obj_motor);
        return obj_motor;
    }

    // Sobrecarga: usa 100 HP por defecto
    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }

    //pasajero
    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula); // Se valida al instanciar
        api.ingresar_pasajero(obj_pasajero);
        return obj_pasajero;
    }
}
