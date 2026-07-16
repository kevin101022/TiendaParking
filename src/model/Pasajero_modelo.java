package model;
public class Pasajero_modelo {
    //inicializar variables
    public String nombre_pasajero = "";
    String apellido_pasajero = "";
    String cedula_pasajero = "";

    //constructor
    public Pasajero_modelo(String dato_nombre_pasajero, String dato_apellido_pasajero, String dato_cedula_pasajero){
        this.nombre_pasajero = dato_nombre_pasajero;
        this.apellido_pasajero = dato_apellido_pasajero;
        this.cedula_pasajero = dato_cedula_pasajero;
    }

    //getters
    public String getNombre_pasajero() { return nombre_pasajero; }
    public String getApellido_pasajero() { return apellido_pasajero; }
    public String getCedula_pasajero() { return cedula_pasajero; }

    //setters
    public void setNombre_pasajero(String nombre_pasajero) { this.nombre_pasajero = nombre_pasajero; }
    public void setApellido_pasajero(String apellido_pasajero) { this.apellido_pasajero = apellido_pasajero; }
    public void setCedula_pasajero(String cedula_pasajero) { this.cedula_pasajero = cedula_pasajero; }
}
