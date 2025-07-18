import java.util.ArrayList;

public class GestionInstrumentos {


    private ArrayList<Instrumento> instrumentos;


    public GestionInstrumentos(){
        this.instrumentos= new ArrayList<>();
    }

    public boolean altaInstrumento(Instrumento it){
        Instrumento i = buscarInstrumentoPorId(it.getIdentificador());
         if(i!=null){
             return false;
         }else{
             instrumentos.add(it);
             return true;
         }
    }

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

    public Instrumento buscarInstrumentoPorId (String identificador) {
        for (Instrumento i : instrumentos) {
            if (i.getIdentificador().equals(identificador)) {
                return i;
            }
        }
        return null;
    }

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
