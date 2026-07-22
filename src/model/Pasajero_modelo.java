package model;

public class Pasajero_modelo {
    //inicializar variables
    public String nombre_pasajero = "";
    String apellido_pasajero = "";
    String cedula_pasajero = "";

    //constructor
    public Pasajero_modelo(String dato_nombre_pasajero, String dato_apellido_pasajero, String dato_cedula_pasajero){
        this.nombre_pasajero = validarNombre(dato_nombre_pasajero);
        this.apellido_pasajero = validarApellido(dato_apellido_pasajero);
        this.cedula_pasajero = validarCedula(dato_cedula_pasajero);
    }

    // holis aca van las Reglas de negocio / Validaciones
    public String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del pasajero no puede estar vacío.");
        }
        return nombre.trim();
    }

    public String validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del pasajero no puede estar vacío.");
        }
        return apellido.trim();
    }

    public String validarCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula del pasajero no puede estar vacía.");
        }
        if (!cedula.trim().matches("\\d+")) {
            throw new IllegalArgumentException("La cédula del pasajero debe contener solo números.");
        }
        return cedula.trim();
    }

    //getters
    public String getNombre_pasajero() { return nombre_pasajero; }
    public String getApellido_pasajero() { return apellido_pasajero; }
    public String getCedula_pasajero() { return cedula_pasajero; }

    //setters
    public void setNombre_pasajero(String nombre_pasajero) { this.nombre_pasajero = validarNombre(nombre_pasajero); }
    public void setApellido_pasajero(String apellido_pasajero) { this.apellido_pasajero = validarApellido(apellido_pasajero); }
    public void setCedula_pasajero(String cedula_pasajero) { this.cedula_pasajero = validarCedula(cedula_pasajero); }
}
