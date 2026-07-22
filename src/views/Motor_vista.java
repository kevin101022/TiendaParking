package views;

import java.util.Scanner;
import controller.Motor_controlador;

public class Motor_vista {

    public void registrar_motor(Scanner obj_teclado) {
        System.out.print("Ingrese el tipo de motor: ");
        String tipo_motor = obj_teclado.nextLine();

        System.out.print("Ingrese los caballos de fuerza del motor: ");
        String caballos_fuerza = obj_teclado.nextLine();

        System.out.print("Ingrese el número de serie del motor: ");
        String numero_serie = obj_teclado.nextLine();

        Motor_controlador obj_controller = new Motor_controlador();
        String respuesta = obj_controller.datosRegistrarMotor(tipo_motor, caballos_fuerza, numero_serie);

        System.out.println(respuesta);
    }

    public void registrar_motor() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_motor(obj_teclado);
    }
}
