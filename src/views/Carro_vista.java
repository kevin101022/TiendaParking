package views;

import java.util.Scanner;
import controller.Controlador;
import model.Carro_modelo; 

// Vista para registrar un carro. Pre-valida entrada por consola.
public class Carro_vista {

    public void registrar_carro(Scanner obj_teclado, Controlador obj_controller) {
        System.out.println("REGISTRO DE CARRO");

        // Pedir y validar placa
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

        // Pedir color
        String color_carro = "";
        while (color_carro.trim().isEmpty()) {
            System.out.print("Ingrese el color del carro: ");
            color_carro = obj_teclado.nextLine();
            if (color_carro.trim().isEmpty()) {
                System.out.println("  El color no puede estar vacío. Intente de nuevo.");
            }
        }

        // Pedir marca
        String marca_carro = "";
        while (marca_carro.trim().isEmpty()) {
            System.out.print("Ingrese la marca del carro: ");
            marca_carro = obj_teclado.nextLine();
            if (marca_carro.trim().isEmpty()) {
                System.out.println("  La marca no puede estar vacía. Intente de nuevo.");
            }
        }

        try {
            Carro_modelo obj_carro = obj_controller.registrarCarro(placa_carro, color_carro, marca_carro);
            System.out.println("Carro registrado correctamente:\n"
                    + "Placa del carro: " + obj_carro.getPlaca_carro() + "\n"
                    + "Color del carro: " + obj_carro.getColor_carro() + "\n"
                    + "Marca del carro: " + obj_carro.getMarca_carro());
        } catch (RuntimeException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}
