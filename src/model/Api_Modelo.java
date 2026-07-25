package model;

import java.util.ArrayList;
import java.util.List;

// Esta clase simula la "base de datos" del sistema: guarda en memoria todo lo
// que se va registrando (carros, choferes, pasajeros, motores) y controla el
// acceso mediante una conexión simulada.
public class Api_Modelo {
    //Inicializar variables
    public String root = "";
    String url = "";
    String clave = "";
    public boolean conectado = false; // true = hay "sesión abierta" con la API, false = no se puede operar

    // ArrayList: lista que crece sola; aquí guardamos los objetos ya registrados
    private final List<Carro_modelo> carros = new ArrayList<>();
    private final List<chofer_modelo> choferes = new ArrayList<>();
    private final List<Pasajero_modelo> pasajeros = new ArrayList<>();
    private final List<Motor_modelo> motores = new ArrayList<>();

    //Constructor
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
    // Solo se considera "conectado" si la clave guardada es exactamente "1234".
    public boolean validar_conexion() {
        this.conectado = this.clave.equals("1234");
        return this.conectado;
    }

    //desconexión: cierra la sesión si estaba abierta, si no hace nada
    public boolean desconexion() {
        if (this.conectado) {
            this.conectado = false;
            return true;
        }
        return false;
    }

    // Regla de negocio: nada de lo que hay abajo (registrar/buscar/eliminar)
    // puede ejecutarse sin conexión activa. Se llama al inicio de cada método.
    private void exigirConexion() {
        if (!this.conectado) {
            throw new IllegalStateException("No existe una conexión activa con la API.");
        }
    }

    //chofer
    // Registra un chofer ya validado (las validaciones las hizo chofer_modelo en su constructor).
    public boolean registrar_chofer(chofer_modelo chofer) {
        exigirConexion();
        return choferes.add(chofer); // .add() mete el objeto al final de la lista
    }

    // Búsqueda por cédula: recorre la lista uno por uno hasta encontrar la cédula
    // (mismo patrón de búsqueda lineal se repite en carro, pasajero y motor)
    public chofer_modelo buscar_chofer(String cedula) {
        exigirConexion();
        for (chofer_modelo chofer : choferes) {
            if (chofer.getCedula_chofer().equals(cedula)) {
                return chofer;
            }
        }
        return null;
    }

    // Busca primero y, si existe, lo quita de la lista
    public boolean eliminar_chofer(String cedula) {
        exigirConexion();
        chofer_modelo encontrado = buscar_chofer(cedula);
        return encontrado != null && choferes.remove(encontrado);
    }

    //carro
    public boolean ingresar_carro(Carro_modelo carro) {
        exigirConexion();
        return carros.add(carro);
    }

    // Búsqueda por placa
    public Carro_modelo buscar_carro(String placa) {
        exigirConexion();
        for (Carro_modelo carro : carros) {
            if (carro.getPlaca_carro().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    public boolean eliminar_carro(String placa) {
        exigirConexion();
        Carro_modelo encontrado = buscar_carro(placa);
        return encontrado != null && carros.remove(encontrado);
    }

    //pasajero
    public boolean ingresar_pasajero(Pasajero_modelo pasajero) {
        exigirConexion();
        return pasajeros.add(pasajero);
    }

    // Búsqueda por cédula
    public Pasajero_modelo buscar_pasajero(String cedula) {
        exigirConexion();
        for (Pasajero_modelo pasajero : pasajeros) {
            if (pasajero.getCedula_pasajero().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }

    public boolean eliminar_pasajero(String cedula) {
        exigirConexion();
        Pasajero_modelo encontrado = buscar_pasajero(cedula);
        return encontrado != null && pasajeros.remove(encontrado);
    }

    //motor
    public boolean ingresar_motor(Motor_modelo motor) {
        exigirConexion();
        return motores.add(motor);
    }

    // Búsqueda por número de serie
    public Motor_modelo buscar_motor(String numeroSerie) {
        exigirConexion();
        for (Motor_modelo motor : motores) {
            if (motor.getNumero_serie().equals(numeroSerie)) {
                return motor;
            }
        }
        return null;
    }

    public boolean eliminar_motor(String numeroSerie) {
        exigirConexion();
        Motor_modelo encontrado = buscar_motor(numeroSerie);
        return encontrado != null && motores.remove(encontrado);
    }
}
