package main;

import java.util.Scanner;
import views.Carro_vista;
import views.Chofer_vista;
import views.Menu_vista;
import views.Motor_vista;
import views.Pasajero_vista;

public class Tiendaparking {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Menu_vista vistaMenu = new Menu_vista();
        Chofer_vista vistaChofer = new Chofer_vista();
        Carro_vista vistaCarro = new Carro_vista();
        Motor_vista vistaMotor = new Motor_vista();
        Pasajero_vista vistaPasajero = new Pasajero_vista();

        int opcion = -1;
        while (opcion != 0) {
            opcion = vistaMenu.mostrarMenu(teclado);

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
                    vistaMenu.mostrarSalida();
                    break;
                default:
                    vistaMenu.mostrarOpcionInvalida();
            }
        }

        teclado.close();
    }
}
