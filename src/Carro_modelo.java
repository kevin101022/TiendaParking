public class Carro_modelo {
    //Inicializar variables
    public String placa_carro = "";
    String color_carro = "";
    String marca_carro = "";
    String modelo_carro = "";

    //Constructor
    public Carro_modelo(String dato_placa, String dato_color, String dato_marca, String dato_modelo){
        this.placa_carro = dato_placa;
        this.color_carro = dato_color;
        this.marca_carro = dato_marca;
        this.modelo_carro = dato_modelo;
    }

    //Getters
    public String getPlaca_carro() { return placa_carro; }
    public String getColor_carro() { return color_carro; }
    public String getMarca_carro() { return marca_carro; }
    public String getModelo_carro() { return modelo_carro; }

    //Setters
    public void setPlaca_carro(String placa_carro) { this.placa_carro = placa_carro; }
    public void setColor_carro(String color_carro) { this.color_carro = color_carro; }
    public void setMarca_carro(String marca_carro) { this.marca_carro = marca_carro; }
    public void setModelo_carro(String modelo_carro) { this.modelo_carro = modelo_carro; }
}
