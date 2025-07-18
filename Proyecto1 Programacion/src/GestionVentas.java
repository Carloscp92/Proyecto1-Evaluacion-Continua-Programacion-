import java.util.ArrayList;

public class GestionVentas {

    private ArrayList<Venta> ventas;

    public GestionVentas() {
        this.ventas = new ArrayList<>();
    }

    public boolean noHayventas(){
        return ventas.isEmpty();
    }

    public void realizarVenta(Venta v) {
        ventas.add(v);
    }

    public void mostrarVentasRealizadas() {
        for (Venta v : ventas) {
            v.mostrarInfoVenta();
        }
    }

    public void mostrarVentasPorCliente(String dni) {
        for (Venta v : ventas) {
            if (v.getCliente().getDni().equals(dni)) {
                v.mostrarInfoVenta();
            }
        }
    }

    public Venta eliminarVenta(String idVenta){
        for(int i = 0; i< ventas.size(); i++){
            Venta v= ventas.get(i);
            if (v.getIdVenta().equals(idVenta.toLowerCase())) {
                ventas.remove(i);
                return v;
            }
        }
        return null;
    }

    public boolean existeIdVenta(String idVenta){
        for (Venta v : ventas) {
            if (v.getIdVenta().equals(idVenta.toLowerCase())) {
               return true;
            }
        }
        return false;
    }
}
