package views;

import java.util.Scanner;
import controller.Controlador;
import model.chofer_modelo;

// Vista para registrar un chofer. Pre-valida entrada por consola.
public class Chofer_vista {

    public void registrar_chofer(Scanner obj_teclado, Controlador obj_controller) {
        System.out.println("REGISTRO DE CHOFER");

        // Pedir nombre
        String nombre_chofer = "";
        while (nombre_chofer.trim().isEmpty()) {
            System.out.print("Ingrese el nombre del chofer: ");
            nombre_chofer = obj_teclado.nextLine();
            if (nombre_chofer.trim().isEmpty()) {
                System.out.println("  El nombre no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pedir apellido
        String apellido_chofer = "";
        while (apellido_chofer.trim().isEmpty()) {
            System.out.print("Ingrese el apellido del chofer: ");
            apellido_chofer = obj_teclado.nextLine();
            if (apellido_chofer.trim().isEmpty()) {
                System.out.println("  El apellido no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pedir y validar cédula (solo números)
        String cedula_chofer = "";
        while (cedula_chofer.trim().isEmpty() || !cedula_chofer.trim().matches("\\d+")) {
            System.out.print("Ingrese la cédula del chofer (solo números): ");
            cedula_chofer = obj_teclado.nextLine();
            if (cedula_chofer.trim().isEmpty()) {
                System.out.println("  La cédula no puede estar vacía. Intente de nuevo.");
            } else if (!cedula_chofer.trim().matches("\\d+")) {
                System.out.println("  La cédula solo puede contener números. Intente de nuevo.");
            }
        }

        // Pedir licencia
        String licencia_chofer = "";
        while (licencia_chofer.trim().isEmpty()) {
            System.out.print("Ingrese la licencia del chofer: ");
            licencia_chofer = obj_teclado.nextLine();
            if (licencia_chofer.trim().isEmpty()) {
                System.out.println("  La licencia no puede estar vacía. Intente de nuevo.");
            }
        }

        try {
            chofer_modelo obj_chofer = obj_controller.registrarChofer(nombre_chofer, apellido_chofer, cedula_chofer, licencia_chofer);
            System.out.println("Chofer registrado correctamente:\n"
                    + "Nombre del chofer: " + obj_chofer.getNombre_chofer() + "\n"
                    + "Apellido del chofer: " + obj_chofer.getApellido_chofer() + "\n"
                    + "Cédula del chofer: " + obj_chofer.getCedula_chofer() + "\n"
                    + "Licencia del chofer: " + obj_chofer.getLicencia_chofer());
        } catch (RuntimeException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}