package views;

import java.util.Scanner;
import controller.Pasajero_controlador;

public class Pasajero_vista {

    public void registrar_pasajero(Scanner obj_teclado) {
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre_pasajero = obj_teclado.nextLine();

        System.out.print("Ingrese el apellido del pasajero: ");
        String apellido_pasajero = obj_teclado.nextLine();

        System.out.print("Ingrese la cédula del pasajero: ");
        String cedula_pasajero = obj_teclado.nextLine();

        Pasajero_controlador obj_controller = new Pasajero_controlador();
        String respuesta = obj_controller.datosRegistrarPasajero(nombre_pasajero, apellido_pasajero, cedula_pasajero);

        System.out.println(respuesta);
    }

    public void registrar_pasajero() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_pasajero(obj_teclado);
    }
}
