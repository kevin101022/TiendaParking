
public class Tiendaparking {
    public static void main(String[] args) {
        
        //clase chofer_modelo
        chofer_modelo chofer = new chofer_modelo("Kevin", "Rivera", " 1122334455");
        chofer.setNombre_chofer("Andres");

        String dato_nombre = chofer.getNombre_chofer();
        System.out.println("Nombre chofer: " + dato_nombre);
        
        //clase carro_modelo
        Carro_modelo carro = new Carro_modelo("xjh-1010", "Negro", "Mustang", "2024");
        carro.setPlaca_carro("xjh-1010");

        String dato_placa = carro.getPlaca_carro();
        System.out.println("Placa carro: " + dato_placa);

        //clase Motor_modelo
        Motor_modelo motor = new Motor_modelo("Eléctrico", "500");
        motor.setTipo_motor("Eléctrico");
        motor.setCaballos_fuerza("500");

        String dato_tipo_motor = motor.getTipo_motor();
        System.out.println("Tipo de motor: " + dato_tipo_motor);

        String dato_caballos_fuerza = motor.getCaballos_fuerza();
        System.out.println("Caballos de fuerza: " + dato_caballos_fuerza);

    }
}
