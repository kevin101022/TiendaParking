public class Motor_modelo {
    //Inicializar variables
    public String tipo_motor = "";
    String caballos_fuerza = "";

    //Constructor
    public Motor_modelo(String dato_tipo_motor, String dato_caballos_fuerza){
        this.tipo_motor = dato_tipo_motor;
        this.caballos_fuerza = dato_caballos_fuerza;
    }

    //Getters
    public String getTipo_motor() { return tipo_motor; }
    public String getCaballos_fuerza() { return caballos_fuerza; }

    //Setters
    public void setTipo_motor(String tipo_motor) { this.tipo_motor = tipo_motor; }
    public void setCaballos_fuerza(String caballos_fuerza) { this.caballos_fuerza = caballos_fuerza; }
}
