package main;

import controller.Controlador;

// Punto de entrada de la aplicación (Void Main)
public class Tiendaparking {
    public static void main(String[] args) {
        // Main delega todo el flujo al Controlador (como en el diagrama)
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
