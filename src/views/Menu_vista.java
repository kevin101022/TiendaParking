package views;

import java.util.Scanner;

// Vista del menú principal. Solo se encarga de mostrar opciones y leer lo que
// escribe el usuario; no conoce modelos ni controlador (eso lo maneja el main).
public class Menu_vista {

    // Imprime el menú y devuelve la opción elegida como número.
    // Si el usuario escribe algo que no es un número, devuelve -1 (opción inválida).
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

    // Mensaje cuando la opción no está entre 0 y 4
    public void mostrarOpcionInvalida() {
        System.out.println("  Opción inválida. Ingrese un número del 0 al 4.");
    }

    // Mensaje de despedida cuando se elige la opción 0
    public void mostrarSalida() {
        System.out.println("Saliendo...");
    }
}
