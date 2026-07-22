package model;

public class Api_Modelo {
    // Inicializar variables
    public String root = "";
    String url = "";
    String clave = "";
    public boolean conectado = false;



    // Constructor
    public Api_Modelo(String root, String url, String clave) {
        this.root = root;
        this.url = url;
        this.clave = clave;
    }

    //Getters
    public String getRoot() { return root; }
    String getUrl() { return url; }
    String getClave() { return clave; }
    boolean isConectado() { return conectado; }

    //Setters
    public void setRoot(String root) { this.root = root; }
    void setUrl(String url) { this.url = url; }
    void setClave(String clave) { this.clave = clave; }
    void setConectado(boolean conectado) { this.conectado = conectado; }

    // Regla de negocio de conexión a la base de datos
    public boolean validar_conexion() {
        if (this.clave.equals("1234")) {
            this.conectado = true;
            return true;
        } else {
            this.conectado = false;
            return false;
        }
    }
    
    //desconexión
    public boolean desconexion() {
        if (this.conectado) {
            this.conectado = false;
            System.out.println("desconexion realizada...");
            return true;
        } else {
            System.out.println("No existe una conexión.");
            return false;
        }
    }

    //buscar chofer
    public void buscar_chofer(String info_cedula) {
        System.out.println("Cliente se esta buscando...");
    }

    //buscar carro
    public void buscar_carro(String placa_carro) {
        System.out.println("Vehiculo se esta buscando...");
    }
    //buscar pasajero
    public void buscar_pasajero(String info_cedula) {
        System.out.println("Pasajero se esta buscando...");
    }

    //buscar motor
    public void buscar_motor(String tipo_motor) {
        System.out.println("Motor se esta buscando...");
    }

    //registrar chofer
    public void registrar_chofer(String info_cedula) {
        System.out.println("Cliente se esta registrando...");
    }

    //ingresar carro
    public void ingresar_carro(String placa_carro) {
        System.out.println("Vehiculo se esta registrando...");
    }

    //ingresar pasajero
    public void ingresar_pasajero(String info_cedula) {
        System.out.println("Pasajero se esta registrando...");
    }

    //ingresar motor
    public void ingresar_motor(String tipo_motor) {
        System.out.println("Motor se esta registrando...");
    }

    //eliminar chofer
    public void eliminar_chofer(String info_cedula) {
        System.out.println("Cliente se esta eliminando...");
    }

    //eliminar carro
    public void eliminar_carro(String placa_carro) {
        System.out.println("Vehiculo se esta eliminando...");
    }

    //eliminar pasajero
    public void eliminar_pasajero(String info_cedula) {
        System.out.println("Pasajero se esta eliminando...");
    }

    //eliminar motor
    public void eliminar_motor(String tipo_motor) {
        System.out.println("Motor se esta eliminando...");
    }
}