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
