package views;

import java.util.Scanner;
import controller.Motor_controlador;
import model.Motor_modelo;

public class Motor_vista {

    public void registrar_motor(Scanner obj_teclado) {

        String tipo_motor = "";
        while (tipo_motor.trim().isEmpty()) {
            System.out.print("Ingrese el tipo de motor: ");
            tipo_motor = obj_teclado.nextLine();
            if (tipo_motor.trim().isEmpty()) {
                System.out.println("  El tipo de motor no puede estar vacío. Intente de nuevo.");
            }
        }

        String caballos_fuerza = "";
        boolean caballosValidos = false;
        while (!caballosValidos) {
            System.out.print("Ingrese los caballos de fuerza del motor: ");
            caballos_fuerza = obj_teclado.nextLine();
            if (caballos_fuerza.trim().isEmpty()) {
                System.out.println("  Los caballos de fuerza no pueden estar vacíos. Intente de nuevo.");
            } else {
                try {
                    double valor = Double.parseDouble(caballos_fuerza.trim());
                    if (valor <= 0) {
                        System.out.println("  Los caballos de fuerza deben ser mayor a 0. Intente de nuevo.");
                    } else {
                        caballosValidos = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  Debe ingresar un valor numérico. Intente de nuevo.");
                }
            }
        }

        String numero_serie = "";
        while (numero_serie.trim().isEmpty()) {
            System.out.print("Ingrese el número de serie del motor: ");
            numero_serie = obj_teclado.nextLine();
            if (numero_serie.trim().isEmpty()) {
                System.out.println("  El número de serie no puede estar vacío. Intente de nuevo.");
            }
        }

        Motor_controlador obj_controller = new Motor_controlador();
        try {
            Motor_modelo obj_motor = obj_controller.registrarMotor(tipo_motor, caballos_fuerza, numero_serie);
            System.out.println("Motor registrado correctamente:\n"
                    + "Tipo de motor: " + obj_motor.getTipo_motor() + "\n"
                    + "Caballos de fuerza: " + obj_motor.getCaballos_fuerza() + "\n"
                    + "Número de serie: " + obj_motor.getNumero_serie());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void registrar_motor() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_motor(obj_teclado);
    }
}
