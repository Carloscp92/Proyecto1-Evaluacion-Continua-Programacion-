/**
 * Representa una venta, incluyendo cliente, instrumentos vendidos,
 * fecha, total e identificador. Proporciona métodos para gestión de venta.
 * @author Carlos Pérez
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Venta {

    private Cliente cliente;
    private ArrayList<Instrumento> instrumentoParaVenta;
    private String fechaVenta;
    private double total;
    private String idVenta;

    public Venta(Cliente cliente, String fechaVenta,String idVenta){
    this.cliente= cliente;
    this.fechaVenta= fechaVenta;
    this.idVenta= idVenta.toLowerCase();
    this.total= 0;
    this.instrumentoParaVenta= new ArrayList<>();
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public String getIdVenta() {
            return idVenta;
    }

    public boolean tieneInstrumentos() {
            return !this.instrumentoParaVenta.isEmpty();
    }

    public void anhadirInstrumento(Instrumento instrumentosvendidos){
    instrumentoParaVenta.add(instrumentosvendidos);
    calcularTotal();
    }

    /**
     * Calcula y devuelve la suma total de todos los instrumentos añadidos a la venta.
     * @return Suma total de la venta.
     */
    public double calcularTotal(){
        double suma=0;
        for(Instrumento i: instrumentoParaVenta) {
            i.getPrecio();
            suma += i.getPrecio();
        }
            this.total=suma;
        return this.total;
    }

    public double getTotal() {
            return total;
        }

    /**
     * Muestra por consola la información detallada de la venta,
     * incluyendo cliente, instrumentos, cantidades y total.
     * Internamente utiliza un HashMap para contar la cantidad de instrumentos por tipo.
     */

    public void mostrarInfoVenta(){
        HashMap<String,Integer> cantidadInstrumentos = new HashMap<>();
        for(Instrumento i : instrumentoParaVenta){
            String clave = i.getNombreInstrumento() + " Marca " + i.getMarca() + " Modelo " + i.getModelo() ;
            if(cantidadInstrumentos.containsKey(clave)){
                cantidadInstrumentos.put(clave,cantidadInstrumentos.get(clave)+1);
            }else {
                cantidadInstrumentos.put(clave,1);
            }
        }
        System.out.println("==Cliente==" + this.cliente);
        System.out.println("==Instrumentos==");
        for(Map.Entry<String,Integer> listaInstrumentos : cantidadInstrumentos.entrySet()){

            System.out.println(listaInstrumentos.getKey()+ " - Cantidad: "+ listaInstrumentos.getValue());
        }
        System.out.println("Total Venta: " + this.total+"€");
        System.out.println("Fecha de Venta: "+ this.fechaVenta);
        System.out.println("Venta: " + this.idVenta);
    }
}
