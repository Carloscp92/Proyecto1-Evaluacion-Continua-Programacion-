
/**
 * Gestiona una colección de instrumentos, permitiendo
 * dar de alta, dar de baja, buscar, modificar y listar instrumentos.
 * @author Carlos Pérez
 * @version 1.0.0
 */

import java.util.ArrayList;

public class GestionInstrumentos {


    private ArrayList<Instrumento> instrumentos;


    public GestionInstrumentos(){
        this.instrumentos= new ArrayList<>();
    }

    /**
     * Añade un nuevo instrumento si su identificador no está registrado previamente.
     * @param it Instrumento a añadir.
     * @return true si se añadió correctamente, false si ya existía.
     */
    public boolean altaInstrumento(Instrumento it){
        Instrumento i = buscarInstrumentoPorId(it.getIdentificador());
         if(i!=null){
             return false;
         }else{
             instrumentos.add(it);
             return true;
         }
    }
    /**
     * Elimina un instrumento del listado según su identificador.
     * @param identificador Identificador del instrumento a eliminar.
     * @return true si se encontró y eliminó, false si no existía.
     */
    public boolean bajaInstrumento(String identificador) {
        boolean encontrado = false;
        for (Instrumento i : instrumentos) {
            if (i.getIdentificador().equals(identificador)) {
                instrumentos.remove(i);
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    /**
     * Busca un instrumento en la lista por su identificador.
     * @param identificador Identificador a buscar.
     * @return Instrumento encontrado, o null si no existe.
     */
    public Instrumento buscarInstrumentoPorId (String identificador) {
        for (Instrumento i : instrumentos) {
            if (i.getIdentificador().equals(identificador)) {
                return i;
            }
        }
        return null;
    }
    /**
     * Busca un instrumento por identificador y lo muestra por consola.
     * @param identificador Identificador del instrumento a modificar.
     * @return Instrumento encontrado, o null si no existe.
     */
    public Instrumento modificarInstrumento(String identificador) {
        Instrumento i = buscarInstrumentoPorId(identificador);
        if(i != null){
            System.out.println(i);
            return i;
        }
        return null;
    }

    public void listarInstrumentos(){

        if (instrumentos.isEmpty()){
            System.out.println("No hay instrumentos en el listado");
        }else {
            for (Instrumento i : instrumentos){
                System.out.println(i);
            }
        }
    }

    public boolean existeIdentificador(String identificador){
        for( Instrumento i: instrumentos){
            if(i.getIdentificador().equals(identificador)){
                return true;
            }
        }
        return false;
    }
}
