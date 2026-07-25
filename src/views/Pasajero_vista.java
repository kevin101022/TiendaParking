package views;

import java.util.Scanner;
import controller.Controlador;
import model.Pasajero_modelo;

// Vista para registrar un pasajero. Pre-valida por consola los mismos criterios
// que aplica Pasajero_modelo; la validación definitiva sigue viviendo en el modelo.
public class Pasajero_vista {

    public void registrar_pasajero(Scanner obj_teclado) {
        System.out.println("REGISTRO DE PASAJERO");

        // Pide el nombre hasta que no venga vacío
        String nombre_pasajero = "";
        while (nombre_pasajero.trim().isEmpty()) {
            System.out.print("Ingrese el nombre del pasajero: ");
            nombre_pasajero = obj_teclado.nextLine();
            if (nombre_pasajero.trim().isEmpty()) {
                System.out.println("  El nombre no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide el apellido hasta que no venga vacío
        String apellido_pasajero = "";
        while (apellido_pasajero.trim().isEmpty()) {
            System.out.print("Ingrese el apellido del pasajero: ");
            apellido_pasajero = obj_teclado.nextLine();
            if (apellido_pasajero.trim().isEmpty()) {
                System.out.println("  El apellido no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide la cédula hasta que no esté vacía y sea solo números
        String cedula_pasajero = "";
        while (cedula_pasajero.trim().isEmpty() || !cedula_pasajero.trim().matches("\\d+")) {
            System.out.print("Ingrese la cédula del pasajero (solo números): ");
            cedula_pasajero = obj_teclado.nextLine();
            if (cedula_pasajero.trim().isEmpty()) {
                System.out.println("  La cédula no puede estar vacía. Intente de nuevo.");
            } else if (!cedula_pasajero.trim().matches("\\d+")) {
                System.out.println("  La cédula solo puede contener números. Intente de nuevo.");
            }
        }

        // Se delega el registro al controlador; el try/catch atrapa cualquier
        // validación que igual falle en el modelo (última línea de defensa)
        Controlador obj_controller = new Controlador();
        try {
            Pasajero_modelo obj_pasajero = obj_controller.registrarPasajero(nombre_pasajero, apellido_pasajero, cedula_pasajero);
            System.out.println("Pasajero registrado correctamente:\n"
                    + "Nombre del pasajero: " + obj_pasajero.getNombre_pasajero() + "\n"
                    + "Apellido del pasajero: " + obj_pasajero.getApellido_pasajero() + "\n"
                    + "Cédula del pasajero: " + obj_pasajero.getCedula_pasajero());
        } catch (RuntimeException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    // Sobrecarga de conveniencia: crea su propio Scanner si no le pasan uno
    public void registrar_pasajero() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_pasajero(obj_teclado);
    }
}
