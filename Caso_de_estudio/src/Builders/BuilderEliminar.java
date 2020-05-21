package Builders;

import Estructuras.CadenaDeSupermercados;
import Estructuras.IntercambiadorDeOrden;
import Estructuras.ManejadorArchivosGenerico;

/**
 * Clase encargada de los métodos referentes a la eliminacion de productos
 *
 * @author Diego
 */
public class BuilderEliminar {

    /**
     * Método que elimina productos de toda la cadena de supermercados (de cada
     * sucursal) a partir de un archivo
     *
     * @param ruta Ruta de archivo
     * @param cadena CadenaDeSupermercados en la cual eliminar los productos
     */
    public static void eliminarEnCadena(String ruta, CadenaDeSupermercados cadena) {
        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo(ruta);
        //Desordeno las lineas del archivo de entrada
        IntercambiadorDeOrden.desordenar(lineas3);
        for (int i = 0; i < lineas3.length; i++) {
            String codigo = lineas3[i];
            try {
                cadena.eliminarProductoEnCadena(codigo);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas3[i]);

            }

        }

    }

    /**
     * Método que elimina productos de una sucursal específica a partir de un
     * archivo
     *
     * @param ruta Ruta de archivo
     * @param cadena CadenaDeSupermercados
     * @param nombreSuc Nombre de sucursal en la cual eliminar los productos
     */
    public static void eliminarEnSucursal(String ruta, CadenaDeSupermercados cadena, String nombreSuc) {

        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo(ruta);
        //Desordeno las lineas del archivo de entrada
        IntercambiadorDeOrden.desordenar(lineas3);
        for (int i = 0; i < lineas3.length; i++) {
            String codigo = lineas3[i];
            try {
                cadena.eliminarProductoEnSucursal(codigo, nombreSuc);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas3[i]);

            }

        }

    }
}
