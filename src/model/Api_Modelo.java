package model;

import java.util.ArrayList;
import java.util.List;

public class Api_Modelo {
    //Inicializar variables
    public String root = "";
    String url = "";
    String clave = "";
    public boolean conectado = false; 

    // Estructuras dinámicas (ArrayList)
    private final List<chofer_modelo> choferes = new ArrayList<>();
    private final List<Pasajero_modelo> pasajeros = new ArrayList<>();

    // Estructuras estáticas (Matrices 3x3)
    private final Carro_modelo[][] carros = new Carro_modelo[3][3];
    private final Motor_modelo[][] motores = new Motor_modelo[3][3];

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

    // Validar conexión a BD simulada
    public boolean validar_conexion() {
        this.conectado = this.clave.equals("1234");
        return this.conectado;
    }

    // Cierra sesión abierta
    public boolean desconexion() {
        if (this.conectado) {
            this.conectado = false;
            return true;
        }
        return false;
    }

    // Requiere conexión para operar
    private void exigirConexion() {
        if (!this.conectado) {
            throw new IllegalStateException("No existe una conexión activa con la API.");
        }
    }

    //chofer
    // Registrar chofer
    public boolean registrar_chofer(chofer_modelo chofer) {
        exigirConexion();
        return choferes.add(chofer);
    }

    // Búsqueda por cédula 
    public chofer_modelo buscar_chofer(String cedula) {
        exigirConexion();
        for (int i = 0; i < choferes.size(); i++) {
            chofer_modelo chofer = choferes.get(i);
            if (chofer.getCedula_chofer().equals(cedula)) {
                return chofer;
            }
        }
        return null;
    }

    // Eliminar por cédula
    public boolean eliminar_chofer(String cedula) {
        exigirConexion();
        for (int i = 0; i < choferes.size(); i++) {
            if (choferes.get(i).getCedula_chofer().equals(cedula)) {
                choferes.remove(i);
                return true;
            }
        }
        return false;
    }

    //carro
    public boolean ingresar_carro(Carro_modelo carro) {
        exigirConexion();
        // Recorrido de matriz para insertar en el primer espacio vacío
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (carros[i][j] == null) {
                    carros[i][j] = carro;
                    return true;
                }
            }
        }
        return false; // Si la matriz 3x3 está llena
    }

    // Búsqueda por placa
    public Carro_modelo buscar_carro(String placa) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (carros[i][j] != null && carros[i][j].getPlaca_carro().equals(placa)) {
                    return carros[i][j];
                }
            }
        }
        return null;
    }

    public boolean eliminar_carro(String placa) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (carros[i][j] != null && carros[i][j].getPlaca_carro().equals(placa)) {
                    carros[i][j] = null; // Se elimina vaciando la posición
                    return true;
                }
            }
        }
        return false;
    }

    //pasajero
    public boolean ingresar_pasajero(Pasajero_modelo pasajero) {
        exigirConexion();
        return pasajeros.add(pasajero);
    }

    // Búsqueda por cédula  
    public Pasajero_modelo buscar_pasajero(String cedula) {
        exigirConexion();
        for (int i = 0; i < pasajeros.size(); i++) {
            Pasajero_modelo pasajero = pasajeros.get(i);
            if (pasajero.getCedula_pasajero().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }

    public boolean eliminar_pasajero(String cedula) {
        exigirConexion();
        for (int i = 0; i < pasajeros.size(); i++) {
            if (pasajeros.get(i).getCedula_pasajero().equals(cedula)) {
                pasajeros.remove(i);
                return true;
            }
        }
        return false;
    }

    //motor
    public boolean ingresar_motor(Motor_modelo motor) {
        exigirConexion();
        // Recorrido de matriz para insertar en el primer espacio vacío
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (motores[i][j] == null) {
                    motores[i][j] = motor;
                    return true;
                }
            }
        }
        return false; // Si la matriz está llena
    }

    // Búsqueda por número de serie
    public Motor_modelo buscar_motor(String numeroSerie) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (motores[i][j] != null && motores[i][j].getNumero_serie().equals(numeroSerie)) {
                    return motores[i][j];
                }
            }
        }
        return null;
    }

    public boolean eliminar_motor(String numeroSerie) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (motores[i][j] != null && motores[i][j].getNumero_serie().equals(numeroSerie)) {
                    motores[i][j] = null; // Eliminar dejando nulo
                    return true;
                }
            }
        }
        return false;
    }
}
