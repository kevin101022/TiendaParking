package views;

import java.util.Scanner;

public class Menu_vista {

    public int mostrarMenu(Scanner obj_teclado) {
        System.out.println("\n===== MENÚ TIENDAPARKING =====");
        System.out.println("1. Registrar chofer");
        System.out.println("2. Registrar carro");
        System.out.println("3. Registrar motor");
        System.out.println("4. Registrar pasajero");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        String entrada = obj_teclado.nextLine();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarOpcionInvalida() {
        System.out.println("  Opción inválida. Ingrese un número del 0 al 4.");
    }

    public void mostrarSalida() {
        System.out.println("Saliendo...");
    }
}
