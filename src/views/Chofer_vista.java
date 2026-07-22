package views;

import java.util.Scanner;
import controller.Chofer_controlador;

public class Chofer_vista {

    public void registrar_chofer(Scanner obj_teclado) {
        System.out.print("Ingrese el nombre del chofer: ");
        String nombre_chofer = obj_teclado.nextLine();

        System.out.print("Ingrese el apellido del chofer: ");
        String apellido_chofer = obj_teclado.nextLine();

        System.out.print("Ingrese la cédula del chofer: ");
        String cedula_chofer = obj_teclado.nextLine();

        System.out.print("Ingrese la licencia del chofer: ");
        String licencia_chofer = obj_teclado.nextLine();

        Chofer_controlador obj_controller = new Chofer_controlador(); 
        String respuesta = obj_controller.datosRegistrarChofer(nombre_chofer, apellido_chofer, cedula_chofer, licencia_chofer);
        
        System.out.println(respuesta);
    }

    public void registrar_chofer() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_chofer(obj_teclado);
    }
}