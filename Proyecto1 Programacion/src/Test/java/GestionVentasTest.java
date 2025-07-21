import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class GestionVentasTest {


    private GestionClientes gestionClientes;
    private Cliente c1test;
    private GestionVentas gestionVentas;
    private Venta v1test;
    private GestionInstrumentos gestionInstrumentos;
    private Instrumento i1test;

    @BeforeEach
    void setup (){

        gestionClientes = new GestionClientes();
        c1test = new Cliente("Andrés Trozado", "45567823K","699486754", "andresito99@gmail.com");
        gestionInstrumentos = new GestionInstrumentos();
        i1test= new Instrumento("Pianola", "Steinway & Sons","A","A1",1500.00);
        gestionVentas =new GestionVentas();
        v1test = new Venta(c1test,i1test.getIdentificador(),"1");
        gestionVentas.realizarVenta(v1test);
    }

    @Test
    void testEliminarUnaVenta(){
        Venta resultado = gestionVentas.eliminarVenta(v1test.getIdVenta());
        assertNotNull(resultado);
    }
    @Test
    void testEliminarUnaVentaInexistente(){
        Venta resultado = gestionVentas.eliminarVenta("000");
        assertNull(resultado);
    }
    @Test
    void testNoHayVentas (){
        gestionVentas.eliminarVenta(v1test.getIdVenta());
        boolean resultado = gestionVentas.noHayventas();
            assertTrue(resultado);
        }

    @Test
    void testNoHayVentasFalse(){
        boolean resultado = gestionVentas.noHayventas();
        assertFalse(resultado);
    }
    @Test
    void testExisteIdVenta(){
        boolean resultado = gestionVentas.existeIdVenta(v1test.getIdVenta());
        assertTrue(resultado);
    }
    @Test
    void testExisteIdventaFalse(){
        boolean resultado = gestionVentas.existeIdVenta("0000X");
        assertFalse(resultado);
    }
}

