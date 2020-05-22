package Estructuras_Básicas;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TArbolBBTest {

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
    public void testInordenQueDevuelveArbolPorNombreVacio() {
        TArbolBB<Producto> arbol = new TArbolBB();
        //Genero la lista de salida con el arbol que me da el método recorrido en inOrden
        TArbolBB<Integer> salidaObtenida = arbol.inordenQueDevuelveArbolPorNombre();
        assertNull(salidaObtenida);
    }

    @Test
    public void testInordenQueDevuelveArbolPorNombreTresElementos() {
        //Genero el Arbol de entrada al método
        TArbolBB<Producto> arbol = new TArbolBB();
        Producto prod = new Producto(1, "a", 20.0);
        Producto prod2 = new Producto(1, "b", 20.0);
        Producto prod3 = new Producto(1, "c", 20.0);
        TElementoAB<Producto> uno = new TElementoAB(1, prod);
        TElementoAB<Producto> dos = new TElementoAB(2, prod2);
        TElementoAB<Producto> tres = new TElementoAB(3, prod3);
        arbol.insertar(uno);
        arbol.insertar(dos);
        arbol.insertar(tres);

        //Genero la lista de salida con el arbol que me da el método recorrido en inOrden
        Lista<Integer> salidaObtenida = arbol.inordenQueDevuelveArbolPorNombre().inorden();

        //Recorro la lista obtenida metiendo los elementos en un array para comparar después
        String[] arrayObtenido = new String[3];
        int contador = 0;
        Nodo<Integer> nodo = salidaObtenida.getPrimero();
        while (nodo != null) {
            arrayObtenido[contador] = nodo.getEtiqueta().toString();
            contador++;
            nodo = nodo.getSiguiente();
        }

        String[] arrayEsperado = {"a", "b", "c"};

        assertArrayEquals(arrayEsperado, arrayObtenido);

    }

    @Test
    public void testInordenQueDevuelveArrayVacio() {
        TArbolBB<Producto> arbol = new TArbolBB();
        //Genero la lista de salida con el arbol que me da el método recorrido en inOrden
        String[] salidaObtenida = arbol.inordenQueDevuelveArray();
        assertNull(salidaObtenida);
    }

    @Test
    public void testInordenQueDevuelveArrayTresElementos() {

        //Genero el Arbol de entrada al método
        TArbolBB<Integer> arbol = new TArbolBB();
        TElementoAB<Integer> uno = new TElementoAB("a", 1);
        TElementoAB<Integer> dos = new TElementoAB("b", 2);
        TElementoAB<Integer> tres = new TElementoAB("c", 3);
        arbol.insertar(uno);
        arbol.insertar(dos);
        arbol.insertar(tres);
        
        /*Genero el array de salida del método, se genera desde el indice 1 al tamanio del arbol
        en el indice 0 puedo poner lo que quiera*/
        String[] arrayObtenido = arbol.inordenQueDevuelveArray();
        arrayObtenido[0] = "aa";

        String[] arrayEsperado = {"aa","a stock: 1","b stock: 2", "c stock: 3"};

        assertArrayEquals(arrayEsperado, arrayObtenido);

    }

}
