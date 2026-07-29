package model;

import java.util.ArrayList;
import java.util.List;

public class Api_Modelo {
    // Inicializar variables
    public String root = "";
    public String url = "";
    public String clave = "";
    public boolean conectado = false;

    // Estructuras dinámicas (ArrayList) 
    private final List<chofer_modelo> lista_chofer = new ArrayList<>();
    private final List<Pasajero_modelo> lista_pasajero = new ArrayList<>();

    // Estructuras estáticas (Matrices 3x3) 
    private final String[][] lista_carros = new String[3][3];
    private final String[][] lista_motores = new String[3][3];

    // Constructor
    public Api_Modelo(String url, String usuario, String clave) {
        this.url = url;
        this.root = usuario;
        this.clave = clave;
    }

    // Getters públicos
    public String getRoot() { return root; }
    public String getUrl() { return url; }
    public String getClave() { return clave; }
    public boolean isConectado() { return conectado; }

    // Setters públicos
    public void setRoot(String root) { this.root = root; }
    public void setUrl(String url) { this.url = url; }
    public void setClave(String clave) { this.clave = clave; }
    public void setConectado(boolean conectado) { this.conectado = conectado; }

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

  

    public boolean registrar_chofer(chofer_modelo chofer) {
        exigirConexion();
        return lista_chofer.add(chofer);
    }

    public chofer_modelo buscar_chofer(String cedula) {
        exigirConexion();
        for (int i = 0; i < lista_chofer.size(); i++) {
            chofer_modelo chofer = lista_chofer.get(i);
            if (chofer.getCedula_chofer().equals(cedula)) {
                return chofer;
            }
        }
        return null;
    }

    public boolean actualizar_chofer(String cedulaVieja, chofer_modelo nuevoChofer) {
        exigirConexion();
        for (int i = 0; i < lista_chofer.size(); i++) {
            if (lista_chofer.get(i).getCedula_chofer().equals(cedulaVieja)) {
                lista_chofer.set(i, nuevoChofer);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar_chofer(String cedula) {
        exigirConexion();
        for (int i = 0; i < lista_chofer.size(); i++) {
            if (lista_chofer.get(i).getCedula_chofer().equals(cedula)) {
                lista_chofer.remove(i);
                return true;
            }
        }
        return false;
    }

  

    public boolean ingresar_carro(Carro_modelo carro) {
        exigirConexion();
        // Insertar en la matriz desarmando el objeto en 3 columnas
        for (int i = 0; i < 3; i++) {
            if (lista_carros[i][0] == null) { // Si la fila está libre
                lista_carros[i][0] = carro.getPlaca_carro();
                lista_carros[i][1] = carro.getMarca_carro();
                lista_carros[i][2] = carro.getColor_carro();
                return true;
            }
        }
        return false; // Matriz llena
    }

    public Carro_modelo buscar_carro(String placa) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_carros[i][0] != null && lista_carros[i][0].equals(placa)) {
                // Reconstruimos el objeto para devolvérselo al controlador
                return new Carro_modelo(lista_carros[i][0], lista_carros[i][2], lista_carros[i][1]); // Placa, Color, Marca
            }
        }
        return null;
    }

    public boolean actualizar_carro(String placaVieja, Carro_modelo nuevoCarro) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_carros[i][0] != null && lista_carros[i][0].equals(placaVieja)) {
                lista_carros[i][0] = nuevoCarro.getPlaca_carro();
                lista_carros[i][1] = nuevoCarro.getMarca_carro();
                lista_carros[i][2] = nuevoCarro.getColor_carro();
                return true;
            }
        }
        return false;
    }

    public boolean eliminar_carro(String placa) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_carros[i][0] != null && lista_carros[i][0].equals(placa)) {
                // Para eliminar, vaciamos las 3 columnas
                lista_carros[i][0] = null;
                lista_carros[i][1] = null;
                lista_carros[i][2] = null;
                return true;
            }
        }
        return false;
    }

  

    public boolean ingresar_pasajero(Pasajero_modelo pasajero) {
        exigirConexion();
        return lista_pasajero.add(pasajero);
    }

    public Pasajero_modelo buscar_pasajero(String cedula) {
        exigirConexion();
        for (int i = 0; i < lista_pasajero.size(); i++) {
            Pasajero_modelo pasajero = lista_pasajero.get(i);
            if (pasajero.getCedula_pasajero().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }

    public boolean actualizar_pasajero(String cedulaVieja, Pasajero_modelo nuevoPasajero) {
        exigirConexion();
        for (int i = 0; i < lista_pasajero.size(); i++) {
            if (lista_pasajero.get(i).getCedula_pasajero().equals(cedulaVieja)) {
                lista_pasajero.set(i, nuevoPasajero);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar_pasajero(String cedula) {
        exigirConexion();
        for (int i = 0; i < lista_pasajero.size(); i++) {
            if (lista_pasajero.get(i).getCedula_pasajero().equals(cedula)) {
                lista_pasajero.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean ingresar_motor(Motor_modelo motor) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_motores[i][0] == null) {
                lista_motores[i][0] = motor.getNumero_serie();
                lista_motores[i][1] = motor.getTipo_motor();
                lista_motores[i][2] = motor.getCaballos_fuerza();
                return true;
            }
        }
        return false;
    }

    public Motor_modelo buscar_motor(String numeroSerie) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_motores[i][0] != null && lista_motores[i][0].equals(numeroSerie)) {
                // Reconstruimos el objeto 
                return new Motor_modelo(lista_motores[i][1], lista_motores[i][2], lista_motores[i][0]); // Tipo, Caballos, Serie
            }
        }
        return null;
    }

    public boolean actualizar_motor(String serieVieja, Motor_modelo nuevoMotor) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_motores[i][0] != null && lista_motores[i][0].equals(serieVieja)) {
                lista_motores[i][0] = nuevoMotor.getNumero_serie();
                lista_motores[i][1] = nuevoMotor.getTipo_motor();
                lista_motores[i][2] = nuevoMotor.getCaballos_fuerza();
                return true;
            }
        }
        return false;
    }

    public boolean eliminar_motor(String numeroSerie) {
        exigirConexion();
        for (int i = 0; i < 3; i++) {
            if (lista_motores[i][0] != null && lista_motores[i][0].equals(numeroSerie)) {
                lista_motores[i][0] = null;
                lista_motores[i][1] = null;
                lista_motores[i][2] = null;
                return true;
            }
        }
        return false;
    }
}
