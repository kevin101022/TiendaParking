package model;

public class FichaViaje_modelo {
    private Carro_modelo carro;
    private Motor_modelo motor;
    private chofer_modelo chofer;
    private Pasajero_modelo pasajero;

    public FichaViaje_modelo(Carro_modelo carro, Motor_modelo motor, chofer_modelo chofer, Pasajero_modelo pasajero) {
        this.carro = carro;
        this.motor = motor;
        this.chofer = chofer;
        this.pasajero = pasajero;
    }

    // Getters
    public Carro_modelo getCarro() { return carro; }
    public Motor_modelo getMotor() { return motor; }
    public chofer_modelo getChofer() { return chofer; }
    public Pasajero_modelo getPasajero() { return pasajero; }

    // Setters
    public void setCarro(Carro_modelo carro) { this.carro = carro; }
    public void setMotor(Motor_modelo motor) { this.motor = motor; }
    public void setChofer(chofer_modelo chofer) { this.chofer = chofer; }
    public void setPasajero(Pasajero_modelo pasajero) { this.pasajero = pasajero; }
}
