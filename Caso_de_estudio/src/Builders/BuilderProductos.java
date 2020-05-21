package Builders;

import Estructuras.CadenaDeSupermercados;
import Estructuras.IntercambiadorDeOrden;
import Estructuras.ManejadorArchivosGenerico;
import Estructuras.Producto;

/**
 * Clase encargada de los métodos referentes a la incorporación de productos
 *
 * @author Diego
 */
public class BuilderProductos {

    /**
     * Método de incorpora productos de un archivo a la cadena de supermercados
     * (a cada sucursal)
     *
     * @param ruta Ruta de archivo
     * @param cadena CadenaDeSupermercados en la cual incorporar los productos
     */
    public static void buildCadena(String ruta, CadenaDeSupermercados cadena) {
        try {
            String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
            //Desordeno las lineas del archivo de entrada
            IntercambiadorDeOrden.desordenar(lineas);
            for (int i = 0; i < lineas.length; i++) {
                String[] prod = lineas[i].split("\"");
                try {
                    /*Intento crear todas las variables para poder instanciar un
                    objeto de la clase Producto */
                    Comparable codigo = prod[0].replace(",", "");
                    String descripcion = prod[1].replace("\"", "");
                    Double precio = Double.valueOf(prod[2].replace(",", ""));

                    //Intento instanciar el objeto producto con las variables creadas anteriormente
                    Producto producto = new Producto(codigo, descripcion, precio);
                    //Intento incorporarlo a la cadena de supermercados
                    cadena.incorporarProductoEnCadena(producto);
                } catch (Exception ex) {
                    System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i] + "\n");

                }
            }

        } catch (Exception ex) {
            System.out.println("Error inesperado");
        }

    }

    /**
     * M{etodo que incorpora productos de un archivo a una sucursal específica
     * de la cadena de supermercados
     *
     * @param ruta Ruta del archivo
     * @param cadena CadenaDeSupermercados
     * @param nombreSuc Nombre de la sucursal en la cual agregar los productos
     */
    public static void buildSucursal(String ruta, CadenaDeSupermercados cadena, String nombreSuc) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        //Desordeno las lineas del archivo de entrada
        IntercambiadorDeOrden.desordenar(lineas);
        for (int i = 0; i < lineas.length; i++) {
            String[] prod = lineas[i].split("\"");
            try {
                /*Intento crear todas las variables para poder instanciar un 
                objeto de la clase Producto */
                Comparable codigo = prod[0].replace(",", "");
                String descripcion = prod[1].replace("\"", "");
                Double precio = Double.valueOf(prod[2].replace(",", ""));

                //Intento instanciar el objeto producto con las variables creadas anteriormente
                Producto producto = new Producto(codigo, descripcion, precio);
                //Intento incorporarlo a la cadena de supermercados
                cadena.incorporarProductoEnSucursal(producto, nombreSuc);
            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i] + "\n");

            }

        }
    }

}
