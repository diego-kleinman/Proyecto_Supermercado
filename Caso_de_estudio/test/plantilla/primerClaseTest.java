package plantilla;

import org.junit.Test;
import static org.junit.Assert.*;

public class primerClaseTest {
    
    public primerClaseTest() {
    }

    @Test
    public void testSomeMethod() {
        primerClase aux = new primerClase();
        assertEquals(aux.primerTest(), 1);
    }
    
}
