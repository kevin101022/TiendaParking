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

    // Estructuras temporales para armar la Ficha de Viaje antes de guardarla
    private chofer_modelo tempChofer = null;
    private Carro_modelo tempCarro = null;
    private Motor_modelo tempMotor = null;
    private Pasajero_modelo tempPasajero = null;

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
                case 5:
                    confirmarViaje(teclado);
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

    // Método para validar que todo esté listo y enviarlo al API
    public void confirmarViaje(Scanner teclado) {
        System.out.println("\n--- VALIDANDO FICHA DE VIAJE ---");
        boolean completo = true;
        boolean hayAlgo = false;

        if (tempChofer == null) {
            System.out.println("- ERROR: Falta registrar el Chofer.");
            completo = false;
        } else { hayAlgo = true; }
        
        if (tempCarro == null) {
            System.out.println("- ERROR: Falta registrar el Carro.");
            completo = false;
        } else { hayAlgo = true; }
        
        if (tempMotor == null) {
            System.out.println("- ERROR: Falta registrar el Motor.");
            completo = false;
        } else { hayAlgo = true; }
        
        if (tempPasajero == null) {
            System.out.println("- ERROR: Falta registrar el Pasajero.");
            completo = false;
        } else { hayAlgo = true; }

        if (!hayAlgo) {
            System.out.println("\n[!] No hay ningún registro temporal para guardar.");
            return;
        }

        if (completo) {
            // Todos los datos están, procedemos a guardarlos en la BD (API)
            api.registrar_chofer(tempChofer);
            api.ingresar_carro(tempCarro);
            api.ingresar_motor(tempMotor);
            api.ingresar_pasajero(tempPasajero);

            System.out.println("\n¡ÉXITO! La ficha de viaje ha sido guardada en la base de datos central.");
            System.out.println("Los registros temporales se han limpiado. Puede registrar un nuevo viaje.");

            // Limpiamos la memoria para un nuevo registro
            tempChofer = null;
            tempCarro = null;
            tempMotor = null;
            tempPasajero = null;
        } else {
            System.out.println("\n[!] Advertencia: La Ficha de Viaje no cumple con los requisitos completos.");
            System.out.print("¿Desea forzar el guardado individual de los datos que SÍ registró? (S/N): ");
            String respuesta = teclado.nextLine();
            
            if (respuesta.trim().equalsIgnoreCase("S")) {
                if (tempChofer != null) api.registrar_chofer(tempChofer);
                if (tempCarro != null) api.ingresar_carro(tempCarro);
                if (tempMotor != null) api.ingresar_motor(tempMotor);
                if (tempPasajero != null) api.ingresar_pasajero(tempPasajero);
                
                System.out.println("Registros individuales guardados en la BD exitosamente.");
                
                tempChofer = null;
                tempCarro = null;
                tempMotor = null;
                tempPasajero = null;
            } else {
                System.out.println("Guardado cancelado. Complete los datos faltantes e intente guardar de nuevo (Opción 5).");
            }
        }
    }

    //carro
    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        Carro_modelo obj_carro = new Carro_modelo(placa, marca, modelo); // Se valida al instanciar
        this.tempCarro = obj_carro; // Guardado temporal
        return obj_carro;
    }

    // Sobrecarga
    public Carro_modelo registrarCarro(String placa, String marca){
        return registrarCarro(placa, marca, "No especificado");
    }

    //chofer
    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia); // Se valida al instanciar
        this.tempChofer = obj_chofer; // Guardado temporal
        return obj_chofer;
    }

    //motor
    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie); // Se valida al instanciar
        this.tempMotor = obj_motor; // Guardado temporal
        return obj_motor;
    }

    // Sobrecarga: usa 100 HP por defecto
    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }

    //pasajero
    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula); // Se valida al instanciar
        this.tempPasajero = obj_pasajero; // Guardado temporal
        return obj_pasajero;
    }
}
