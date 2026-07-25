package views;

import java.util.Scanner;
import controller.Controlador;
import model.chofer_modelo;

// Vista para registrar un chofer. Aquí solo se pide y "pre-valida" la entrada
// por consola (para no molestar al usuario pidiendo datos que ya se sabe que
// van a fallar); la validación real y definitiva vuelve a ocurrir en
// chofer_modelo cuando el controlador arma el objeto.
public class Chofer_vista {

    public void registrar_chofer(Scanner obj_teclado) {
        System.out.println("REGISTRO DE CHOFER");

        // Pide el nombre hasta que no venga vacío
        String nombre_chofer = "";
        while (nombre_chofer.trim().isEmpty()) {
            System.out.print("Ingrese el nombre del chofer: ");
            nombre_chofer = obj_teclado.nextLine();
            if (nombre_chofer.trim().isEmpty()) {
                System.out.println("  El nombre no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide el apellido hasta que no venga vacío
        String apellido_chofer = "";
        while (apellido_chofer.trim().isEmpty()) {
            System.out.print("Ingrese el apellido del chofer: ");
            apellido_chofer = obj_teclado.nextLine();
            if (apellido_chofer.trim().isEmpty()) {
                System.out.println("  El apellido no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide la cédula hasta que no esté vacía y sea solo números
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

        // Pide la licencia hasta que no venga vacía
        String licencia_chofer = "";
        while (licencia_chofer.trim().isEmpty()) {
            System.out.print("Ingrese la licencia del chofer: ");
            licencia_chofer = obj_teclado.nextLine();
            if (licencia_chofer.trim().isEmpty()) {
                System.out.println("  La licencia no puede estar vacía. Intente de nuevo.");
            }
        }

        // Con los datos ya recolectados, se delega el registro al controlador.
        // El try/catch atrapa cualquier validación que igual falle en el modelo
        // (última línea de defensa, por si la pre-validación de arriba se saltó algo).
        Controlador obj_controller = new Controlador();
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

    // Sobrecarga de conveniencia: crea su propio Scanner si no le pasan uno
    public void registrar_chofer() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_chofer(obj_teclado);
    }
}