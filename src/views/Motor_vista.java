package views;

import java.util.Scanner;
import controller.Controlador;
import model.Motor_modelo;

// Vista para registrar un motor. Pre-valida por consola los mismos criterios
// que aplica Motor_modelo (incluyendo que los caballos de fuerza sean un
// número mayor a 0); la validación definitiva sigue viviendo en el modelo.
public class Motor_vista {

    public void registrar_motor(Scanner obj_teclado) {
        System.out.println("REGISTRO DE MOTOR");

        // Pide el tipo hasta que no venga vacío
        String tipo_motor = "";
        while (tipo_motor.trim().isEmpty()) {
            System.out.print("Ingrese el tipo de motor: ");
            tipo_motor = obj_teclado.nextLine();
            if (tipo_motor.trim().isEmpty()) {
                System.out.println("  El tipo de motor no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide los caballos de fuerza: debe ser numérico y mayor a 0
        // (misma regla que Motor_modelo.validarCaballosFuerza)
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

        // Pide el número de serie hasta que no venga vacío
        String numero_serie = "";
        while (numero_serie.trim().isEmpty()) {
            System.out.print("Ingrese el número de serie del motor: ");
            numero_serie = obj_teclado.nextLine();
            if (numero_serie.trim().isEmpty()) {
                System.out.println("  El número de serie no puede estar vacío. Intente de nuevo.");
            }
        }

        // Se delega el registro al controlador; el try/catch atrapa cualquier
        // validación que igual falle en el modelo (última línea de defensa)
        Controlador obj_controller = new Controlador();
        try {
            Motor_modelo obj_motor = obj_controller.registrarMotor(tipo_motor, caballos_fuerza, numero_serie);
            System.out.println("Motor registrado correctamente:\n"
                    + "Tipo de motor: " + obj_motor.getTipo_motor() + "\n"
                    + "Caballos de fuerza: " + obj_motor.getCaballos_fuerza() + "\n"
                    + "Número de serie: " + obj_motor.getNumero_serie());
        } catch (RuntimeException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    // Sobrecarga de conveniencia: crea su propio Scanner si no le pasan uno
    public void registrar_motor() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_motor(obj_teclado);
    }
}
