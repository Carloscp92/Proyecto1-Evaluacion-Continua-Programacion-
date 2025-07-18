import java.util.ArrayList;

public class GestionClientes {

    private ArrayList<Cliente>clientes;


    public GestionClientes(){
        clientes= new ArrayList<>();
    }

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

    public Cliente modificarCliente(String dni) {
        Cliente c = buscarClienteporDni(dni);
        if(c != null){
            System.out.println(c);
            return c;
        }
        return null;
    }

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

    public boolean existeDni(String dni){
        for (Cliente ce : clientes) {
            if (ce.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
}
