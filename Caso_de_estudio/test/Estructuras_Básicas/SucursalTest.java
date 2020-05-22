package Estructuras_Básicas;

import org.junit.Test;
import static org.junit.Assert.*;

public class SucursalTest {

    @Test
    public void testInsertarProductoTresProductos() {
        //Instancio la sucursal, los productos y se los agrego
        Sucursal suc = new Sucursal("aa", "123", "suc", "2", "2");
        Producto prod1 = new Producto(123, "prod", 1.0);
        Producto prod2 = new Producto(456, "prod", 1.0);
        Producto prod3 = new Producto(789, "prod", 1.0);
        suc.insertarProducto(prod1);
        suc.insertarProducto(prod2);
        suc.insertarProducto(prod3);

        //Genero una lista recorriendo el arbol de productos de la sucursal en inOrden
        Lista<Producto> salidaObtenida = suc.getArbolProductos().inOrden();

        //Recorro la lista obtenida metiendo los elementos en un array para comparar después
        String[] arrayObtenido = new String[3];
        int contador = 0;
        Nodo<Producto> nodo = salidaObtenida.getPrimero();
        while (nodo != null) {
            arrayObtenido[contador] = nodo.getEtiqueta().toString();
            contador++;
            nodo = nodo.getSiguiente();
        }

        String[] arrayEsperado = {"123", "456", "789"};

        assertArrayEquals(arrayEsperado, arrayObtenido);

    }

    @Test
    public void testAgregarStockTresProductos() {
        //Instancio la sucursal, los productos y se los agrego
        Sucursal suc = new Sucursal("aa", "123", "suc", "2", "2");
        Producto prod1 = new Producto(123, "prod", 1.0);
        Producto prod2 = new Producto(456, "prod", 1.0);
        Producto prod3 = new Producto(789, "prod", 1.0);
        suc.insertarProducto(prod1);
        suc.insertarProducto(prod2);
        suc.insertarProducto(prod3);

        //Agrego stock a los productos
        suc.agregarStock(123, 2);
        suc.agregarStock(456, 3);
        suc.agregarStock(789, 5);

        //Genero una lista recorriendo el arbol de productos de la sucursal en inOrden
        Lista<Producto> salidaObtenida = suc.getArbolProductos().inOrden();

        //Recorro la lista obtenida metiendo los elementos en un array para comparar después
        String[] arrayObtenido = new String[3];
        int contador = 0;
        Nodo<Producto> nodo = salidaObtenida.getPrimero();
        while (nodo != null) {
            arrayObtenido[contador] = nodo.getDato().getStock().toString();
            contador++;
            nodo = nodo.getSiguiente();
        }

        String[] arrayEsperado = {"2", "3", "5"};

        assertArrayEquals(arrayEsperado, arrayObtenido);

    }

    @Test
    public void testSePuedeVenderNoSePuede() {
        //Instancio la sucursal, los productos y se los agrego
        Sucursal suc = new Sucursal("aa", "123", "suc", "2", "2");
        Producto prod1 = new Producto(123, "prod", 1.0);
        suc.insertarProducto(prod1);
        //Agrego stock al producto
        suc.agregarStock(123, 2);
        assertFalse(suc.sePuedeVender(123, 3));
    }

    @Test
    public void testSePuedeVenderSiSePuede() {
        //Instancio la sucursal, los productos y se los agrego
        Sucursal suc = new Sucursal("aa", "123", "suc", "2", "2");
        Producto prod1 = new Producto(123, "prod", 1.0);
        suc.insertarProducto(prod1);
        //Agrego stock al producto
        suc.agregarStock(123, 2);
        assertTrue(suc.sePuedeVender(123, 1));
    }

}
