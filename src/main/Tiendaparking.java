package main;

import java.util.Scanner;
import views.Carro_vista;
import views.Chofer_vista;
import views.Motor_vista;
import views.Pasajero_vista;

public class Tiendaparking {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Chofer_vista vistaChofer = new Chofer_vista();
        Carro_vista vistaCarro = new Carro_vista();
        Motor_vista vistaMotor = new Motor_vista();
        Pasajero_vista vistaPasajero = new Pasajero_vista();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== MENÚ TIENDAPARKING =====");
            System.out.println("1. Registrar chofer");
            System.out.println("2. Registrar carro");
            System.out.println("3. Registrar motor");
            System.out.println("4. Registrar pasajero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = teclado.nextLine();
            try {
                opcion = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("  Opción inválida. Ingrese un número del 0 al 4.");
                continue;
            }

            switch (opcion) {
                case 1:
                    vistaChofer.registrar_chofer(teclado);
                    break;
                case 2:
                    vistaCarro.registrar_carro(teclado);
                    break;
                case 3:
                    vistaMotor.registrar_motor(teclado);
                    break;
                case 4:
                    vistaPasajero.registrar_pasajero(teclado);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("  Opción inválida. Ingrese un número del 0 al 4.");
            }
        }

        teclado.close();
    }
}
