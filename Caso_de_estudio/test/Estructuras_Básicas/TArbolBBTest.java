package Estructuras_Básicas;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TArbolBBTest {


    @Before
    public void setUp() {
        TArbolBB arbol = new TArbolBB();
        TElementoAB uno = new TElementoAB(1, null);
        TElementoAB dos = new TElementoAB(2, null);
        TElementoAB tres = new TElementoAB(3, null);
    }

    @Test
    public void testObtenerTamanioArbolVacio() {
        TArbolBB arbol = new TArbolBB();
        assertEquals(0, arbol.obtenerTamanio());

    }

    @Test
    public void testObtenerTamanioUnElemento() {
        TArbolBB arbol = new TArbolBB();
        TElementoAB uno = new TElementoAB(1, null);
        arbol.insertar(uno);
        assertEquals(1, arbol.obtenerTamanio());
    }

    @Test
    public void testObtenerTamanioDosElementos() {
        TArbolBB arbol = new TArbolBB();
        TElementoAB uno = new TElementoAB(1, null);
        TElementoAB dos = new TElementoAB(2, null);
        arbol.insertar(uno);
        arbol.insertar(dos);
        assertEquals(2, arbol.obtenerTamanio());
    }

    @Test
    public void testObtenerTamanioTresElementos() {
        TArbolBB arbol = new TArbolBB();
        TElementoAB uno = new TElementoAB(1, null);
        TElementoAB dos = new TElementoAB(2, null);
        TElementoAB tres = new TElementoAB(3, null);
        arbol.insertar(uno);
        arbol.insertar(dos);
        arbol.insertar(tres);
        assertEquals(3, arbol.obtenerTamanio());
    }

    @Test
    public void testInordenQueDevuelveArbolPorNombre() {
    }

    @Test
    public void testInordenQueDevuelveArray() {
    }

}
