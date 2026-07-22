package views;

import java.util.Scanner;
import controller.Carro_controlador;

public class Carro_vista {

    public void registrar_carro(Scanner obj_teclado) {
        System.out.print("Ingrese la placa del carro: ");
        String placa_carro = obj_teclado.nextLine();

        System.out.print("Ingrese el color del carro: ");
        String color_carro = obj_teclado.nextLine();

        System.out.print("Ingrese la marca del carro: ");
        String marca_carro = obj_teclado.nextLine();

        System.out.print("Ingrese el modelo del carro: ");
        String modelo_carro = obj_teclado.nextLine();

        Carro_controlador obj_controller = new Carro_controlador();
        String respuesta = obj_controller.datosRegistrarCarro(placa_carro, color_carro, marca_carro, modelo_carro);

        System.out.println(respuesta);
    }

    public void registrar_carro() {
        Scanner obj_teclado = new Scanner(System.in);
        registrar_carro(obj_teclado);
    }
}
