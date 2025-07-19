/**
 * Gestión de clientes, incluyendo alta, baja, modificación,
 * búsqueda y listado de clientes registrados.
 * @author Carlos Pérez
 * @version 1.0.0
 */

import java.util.ArrayList;

public class GestionClientes {

    private ArrayList<Cliente>clientes;


    public GestionClientes(){
        clientes= new ArrayList<>();
    }

    /**
     * Da de alta a un cliente si no está registrado previamente.
     * Comprueba si el DNI ya existe antes de añadirlo a la lista.
     * @param C Cliente a dar de alta.
     */
    public void altaCliente(Cliente C) {
        Cliente c = buscarClienteporDni(C.getDni());
        if(c != null){
            System.out.println("El cliente ya esta registrado");
        } else{
            clientes.add(C);
            int numeroCliente = clientes.size();
            System.out.println("Cliente "+ numeroCliente + " ("+C.getNombre()+")"+ " añadido con exito");
        }
    }

    /**
     * Elimina al cliente con el DNI proporcionado, si está registrado.
     * @param dni DNI del cliente a eliminar.
     * @return true si se encontró y eliminó el cliente, false si no estaba registrado.
     */
    public boolean bajaCliente(String dni){
        boolean encontrado = false;
        for (Cliente ce: clientes){
            if(ce.getDni().equals(dni)){
                clientes.remove(ce);
                encontrado= true;
                break;
            }
        }
            return encontrado;
    }

    /**
     * Busca un cliente por DNI y lo muestra por consola si existe.
     * @param dni DNI del cliente a buscar.
     * @return Cliente encontrado, o null si no existe.
     */
    public Cliente modificarCliente(String dni) {
        Cliente c = buscarClienteporDni(dni);
        if(c != null){
            System.out.println(c);
            return c;
        }
        return null;
    }
    /**
     * Busca un cliente en la lista por su DNI.
     * @param dni DNI a buscar.
     * @return Cliente encontrado, o null si no existe.
     */
    public Cliente buscarClienteporDni (String dni) {
        for (Cliente ce : clientes) {
            if (ce.getDni().equals(dni)) {
                return ce;
            }
        }
        return null;
    }

    public void listarClientes(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
        for (Cliente ce : clientes) {
            System.out.println(ce);
            }
        }
    }

    /**
     * Verifica si un cliente con el DNI dado está registrado.
     * @param dni DNI a verificar.
     * @return true si existe, false si no.
     */
    public boolean existeDni(String dni){
        for (Cliente ce : clientes) {
            if (ce.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
}
