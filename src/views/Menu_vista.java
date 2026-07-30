package views;

import java.util.Scanner;

public class Menu_vista {

    // Muestra menú y lee opción
    public int mostrarMenu(Scanner obj_teclado) {
        System.out.println("\n===== MENÚ TIENDAPARKING =====");
        System.out.println("1. Registrar chofer");
        System.out.println("2. Registrar carro");
        System.out.println("3. Registrar motor");
        System.out.println("4. Registrar pasajero");
        System.out.println("0. Salir");
        System.out.println("\n* NOTA: Cuando termines de registrar los 4 datos, presiona '5' para GUARDAR LA FICHA DE VIAJE.");
        System.out.print("\nSeleccione una opción: ");

        String entrada = obj_teclado.nextLine();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Opción fuera de rango
    public void mostrarOpcionInvalida() {
        System.out.println("  Opción inválida. Ingrese un número del 0 al 5.");
    }

    // Salida
    public void mostrarSalida() {
        System.out.println("Saliendo...");
    }
}
