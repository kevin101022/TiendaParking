package main;

import java.util.Scanner;
import views.Carro_vista;
import views.Chofer_vista;
import views.Motor_vista;
import views.Pasajero_vista;

public class Tiendaparking {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("REGISTRO DE CHOFER");
        Chofer_vista vistaChofer = new Chofer_vista();
        vistaChofer.registrar_chofer(teclado);

        System.out.println("\nREGISTRO DE CARRO");
        Carro_vista vistaCarro = new Carro_vista();
        vistaCarro.registrar_carro(teclado);

        System.out.println("REGISTRO DE MOTOR");
        Motor_vista vistaMotor = new Motor_vista();
        vistaMotor.registrar_motor(teclado);

        System.out.println("REGISTRO DE PASAJERO");
        Pasajero_vista vistaPasajero = new Pasajero_vista();
        vistaPasajero.registrar_pasajero(teclado);

        teclado.close();
    }
}
