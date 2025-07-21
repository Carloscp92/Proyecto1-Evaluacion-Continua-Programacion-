/**
 * Representa un instrumento musical con sus atributos básicos:
 * nombre, marca, modelo, identificador único y precio.
 * Proporciona métodos para acceder y modificar estos atributos.
 * @author Carlos Pérez
 * @version 1.0.0
 */


public class Instrumento {


private String nombreInstrumento;
private String marca;
private String modelo;
private String identificador;
private double precio;


public Instrumento (String nombreInstrumento, String marca, String modelo, String identificador, double precio){
    this.nombreInstrumento= nombreInstrumento;
    this.marca= marca;
    this.modelo= modelo;
    this.identificador = identificador;
    this.precio= precio;
    }

    /**
     * Devuelve informacion en forma de cadena del instrumento,
     * mostrando sus atributos principales de manera legible.
     * @return Cadena con la información del instrumento.
     */
    public String toString(){
        return "\nNombre: "+ nombreInstrumento+ "\nMarca: "+ marca+ "\nModelo: "+ modelo+ "\nIdentificador: "+ identificador + "\nPrecio: "+ precio+"€";
    }

    public String getNombreInstrumento() {
        return nombreInstrumento;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombreInstrumento(String nombreInstrumento) {
        this.nombreInstrumento = nombreInstrumento;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
