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
import views.Viaje_vista;
import java.util.Scanner;

// Puente entre las vistas y los modelos. Solo arma y envía el objeto para guardarlo.
public class Controlador {

    // Conexión única para toda la app
    private static final Api_Modelo api = new Api_Modelo("root", "http://localhost", "1234");
    static {
        api.validar_conexion();
    }

    // Estructura temporal externa: array para armar la Ficha de Viaje antes de guardarla
    // Índices: 0=Carro, 1=Motor, 2=Chofer, 3=Pasajero
    private Object[] fichaTemporal = new Object[4];

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
        Viaje_vista vistaViaje = new Viaje_vista();

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
                    confirmarViaje(teclado, vistaViaje);
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
    public void confirmarViaje(Scanner teclado, Viaje_vista vistaViaje) {
        vistaViaje.mostrarValidando();
        boolean completo = true;
        boolean hayAlgo = false;

        // Validaciones: Carro(0), Motor(1), Chofer(2), Pasajero(3)
        if (fichaTemporal[0] == null) {
            vistaViaje.mostrarErrorFaltaDato("Carro");
            completo = false;
        } else { hayAlgo = true; }
        
        if (fichaTemporal[1] == null) {
            vistaViaje.mostrarErrorFaltaDato("Motor");
            completo = false;
        } else { hayAlgo = true; }
        
        if (fichaTemporal[2] == null) {
            vistaViaje.mostrarErrorFaltaDato("Chofer");
            completo = false;
        } else { hayAlgo = true; }
        
        if (fichaTemporal[3] == null) {
            vistaViaje.mostrarErrorFaltaDato("Pasajero");
            completo = false;
        } else { hayAlgo = true; }

        if (!hayAlgo) {
            vistaViaje.mostrarErrorVacio();
            return;
        }

        if (completo) {
            // Todos los datos están, procedemos a guardarlos en la BD (API)
            api.ingresar_carro((Carro_modelo) fichaTemporal[0]);
            api.ingresar_motor((Motor_modelo) fichaTemporal[1]);
            api.registrar_chofer((chofer_modelo) fichaTemporal[2]);
            api.ingresar_pasajero((Pasajero_modelo) fichaTemporal[3]);

            vistaViaje.mostrarExitoGuardado();

            // Limpiamos la memoria para un nuevo registro
            fichaTemporal = new Object[4];
        } else {
            boolean forzar = vistaViaje.preguntarForzarGuardado(teclado);
            
            if (forzar) {
                if (fichaTemporal[0] != null) api.ingresar_carro((Carro_modelo) fichaTemporal[0]);
                if (fichaTemporal[1] != null) api.ingresar_motor((Motor_modelo) fichaTemporal[1]);
                if (fichaTemporal[2] != null) api.registrar_chofer((chofer_modelo) fichaTemporal[2]);
                if (fichaTemporal[3] != null) api.ingresar_pasajero((Pasajero_modelo) fichaTemporal[3]);
                
                vistaViaje.mostrarGuardadoIndividualExito();
                
                fichaTemporal = new Object[4];
            } else {
                vistaViaje.mostrarGuardadoCancelado();
            }
        }
    }

    //carro (índice 0)
    public Carro_modelo registrarCarro(String placa, String marca, String modelo){
        Carro_modelo obj_carro = new Carro_modelo(placa, marca, modelo); 
        this.fichaTemporal[0] = obj_carro; 
        return obj_carro;
    }

    // Sobrecarga
    public Carro_modelo registrarCarro(String placa, String marca){
        return registrarCarro(placa, marca, "No especificado");
    }

    //chofer (índice 2)
    public chofer_modelo registrarChofer(String nombre, String apellido, String cedula, String licencia){
        chofer_modelo obj_chofer = new chofer_modelo(nombre, apellido, cedula, licencia); 
        this.fichaTemporal[2] = obj_chofer; 
        return obj_chofer;
    }

    //motor (índice 1)
    public Motor_modelo registrarMotor(String tipo, String caballosFuerza, String numeroSerie){
        Motor_modelo obj_motor = new Motor_modelo(tipo, caballosFuerza, numeroSerie); 
        this.fichaTemporal[1] = obj_motor; 
        return obj_motor;
    }

    // Sobrecarga: usa 100 HP por defecto
    public Motor_modelo registrarMotor(String serie, String tipo){
        return registrarMotor(tipo, "100", serie);
    }

    //pasajero (índice 3)
    public Pasajero_modelo registrarPasajero(String nombre, String apellido, String cedula){
        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, apellido, cedula); 
        this.fichaTemporal[3] = obj_pasajero; 
        return obj_pasajero;
    }
}
