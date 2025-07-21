/**
 * Gestiona una lista de ventas, permitiendo realizar,
 * eliminar, consultar y mostrar ventas realizadas o filtradas por cliente.
 * @author Carlos Pérez
 * @version 1.0.0
 */

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

    /**
     * Elimina una venta de la lista según su identificador.
     * @param idVenta Identificador de la venta a eliminar.
     * @return La venta eliminada si existía, o null si no se encontró.
     */
    public Venta eliminarVenta(String idVenta){
        for(int i = 0; i< ventas.size(); i++){
            Venta v= ventas.get(i);
            if (v.getIdVenta().equalsIgnoreCase(idVenta)) {
                ventas.remove(i);
                return v;
            }
        }
        return null;
    }

    public boolean existeIdVenta(String idVenta){
        for (Venta v : ventas) {
            if (v.getIdVenta().equalsIgnoreCase(idVenta)) {
               return true;
            }
        }
        return false;
    }
}
