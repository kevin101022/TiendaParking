package views;

import java.util.Scanner;
import controller.Controlador;
import model.Carro_modelo;

// Vista para registrar un carro. Pre-valida por consola los mismos criterios
// que aplica Carro_modelo, así el usuario no llega al controlador con datos
// que sabemos que van a fallar; la validación definitiva sigue viviendo en el modelo.
public class Carro_vista {

    public void registrar_carro(Scanner obj_teclado) {
        System.out.println("REGISTRO DE CARRO");

        // Pide la placa hasta que tenga al menos 3 caracteres (misma regla que Carro_modelo.validarPlaca)
        String placa_carro = "";
        while (placa_carro.trim().isEmpty() || placa_carro.trim().length() < 3) {
            System.out.print("Ingrese la placa del carro (mín. 3 caracteres): ");
            placa_carro = obj_teclado.nextLine();
            if (placa_carro.trim().isEmpty()) {
                System.out.println("  La placa no puede estar vacía. Intente de nuevo.");
            } else if (placa_carro.trim().length() < 3) {
                System.out.println("  La placa debe tener al menos 3 caracteres. Intente de nuevo.");
            }
        }

        // Pide el color hasta que no venga vacío
        String color_carro = "";
        while (color_carro.trim().isEmpty()) {
            System.out.print("Ingrese el color del carro: ");
            color_carro = obj_teclado.nextLine();
            if (color_carro.trim().isEmpty()) {
                System.out.println("  El color no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pide la marca hasta que no venga vacía
        String marca_carro = "";
        while (marca_carro.trim().isEmpty()) {
            System.out.print("Ingrese la marca del carro: ");
            marca_carro = obj_teclado.nextLine();
            if (marca_carro.trim().isEmpty()) {
                System.out.println("  La marca no puede estar vacía. Intente de nuevo.");
            }
        }

        // Pide el modelo hasta que no venga vacío
        String modelo_carro = "";
        while (modelo_carro.trim().isEmpty()) {
            System.out.print("Ingrese el modelo del carro: ");
            modelo_carro = obj_teclado.nextLine();
            if (modelo_carro.trim().isEmpty()) {
                System.out.println("  El modelo no puede estar vacío. Intente de nuevo.");
            }
        }

        // Se delega el registro al controlador; el try/catch atrapa cualquier
        // validación que igual falle en el modelo (última línea de defensa)
        Controlador obj_controller = new Controlador();
        try {
            Carro_modelo obj_carro = obj_controller.registrarCarro(placa_carro, color_carro, marca_carro, modelo_carro);
            System.out.println("Carro registrado correctamente:\n"
                    + "Placa del carro: " + obj_carro.getPlaca_carro() + "\n"
                    + "Color del carro: " + obj_carro.getColor_carro() + "\n"
                    + "Marca del carro: " + obj_carro.getMarca_carro() + "\n"
                    + "Modelo del carro: " + obj_carro.getModelo_carro());
        } catch (RuntimeException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    // Sobrecarga de conveniencia: crea su propio Scanner si no le pasan uno
    public void registrar_carro() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_carro(obj_teclado);
    }
}
