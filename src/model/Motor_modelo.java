package model;
public class Motor_modelo {
    //Inicializar variables
    public String tipo_motor = "";
    String caballos_fuerza = "";
    String numero_serie = "";

    //Constructor
    public Motor_modelo(String dato_tipo_motor, String dato_caballos_fuerza, String dato_numero_serie){
        this.tipo_motor = dato_tipo_motor;
        this.caballos_fuerza = dato_caballos_fuerza;
        this.numero_serie = dato_numero_serie;
    }

    //Getters
    public String getTipo_motor() { return tipo_motor; }
    public String getCaballos_fuerza() { return caballos_fuerza; }
    public String getNumero_serie() { return numero_serie; }

    //Setters
    public void setTipo_motor(String tipo_motor) { this.tipo_motor = tipo_motor; }
    public void setCaballos_fuerza(String caballos_fuerza) { this.caballos_fuerza = caballos_fuerza; }
    public void setNumero_serie(String numero_serie) { this.numero_serie = numero_serie; }
}
