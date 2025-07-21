
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestionClientesTest {

    private GestionClientes gestionClientes;
    private Cliente c1test;

    @BeforeEach
    void setup() {
    gestionClientes = new GestionClientes();
    c1test = new Cliente("Paco mer" , "30405294M","657938523", "paco@gmail.com");
    gestionClientes.altaCliente(c1test);
    }

    @Test
    void testAltaCliente (){
        Cliente c2test = new Cliente("Aitor menta", "20354621X", "657328943","aitormenta@gmail.com");
        boolean resultado = gestionClientes.altaCliente(c2test);
        assertTrue(resultado);
    }
    @Test
    void testAltaClienteRepetido (){
        gestionClientes.altaCliente(c1test);
        boolean resultado = gestionClientes.altaCliente(c1test);
        assertFalse(resultado);
    }

    @Test
    void testBajaCliente () {
        boolean resultado = gestionClientes.bajaCliente(c1test.getDni());
        assertTrue(resultado);
    }
    @Test
    void testBajaClienteNoexistente(){
        boolean resultado = gestionClientes.bajaCliente("0000000X");
        assertFalse(resultado);
    }
    @Test
    void testModificarCliente () {
        Cliente resultado = gestionClientes.modificarCliente(c1test.getDni());
        assertNotNull(resultado);
        assertEquals("Paco mer", resultado.getNombre());
    }
    @Test
    void testModificarClienteNull (){
        Cliente resultado = gestionClientes.modificarCliente("00000X");
        assertNull(resultado);
    }

}
