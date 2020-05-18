package Builders;

import Estructuras.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BuilderProductos {

    public static void buildCadena(String ruta, CadenaDeSupermercados cadena) throws FileNotFoundException, IOException {
        try {
            String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
            IntercambiadorDeOrden.desordenar(lineas);
            for (int i = 0; i < lineas.length; i++) {
                String[] prod = lineas[i].split("\"");
                try {
                    // Creamos todas las variables para poder instanciar un objeto de la clase
                    // Producto
                    Comparable codigo = prod[0].replace(",", "");
                    String descripcion = prod[1].replace("\"", "");
                    Double precio = Double.valueOf(prod[2].replace(",", ""));

                    // Instanciamos el objeto producto con las variables creadas anteriormente.
                    Producto producto = new Producto(codigo, descripcion, precio);
                    cadena.incorporarProductoEnCadena(producto);

                } catch (Exception ex) {
                    System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i] + "\n");

                }
            }
            System.out.println("Los productos del archivo: " + ruta + " fueron incorporados correctamente");
            System.out.println("***************************************************************************************\n");

        } 
            catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            System.out.println("Los productos no fueron ingresados");
        }

        }

    

    public static void buildSucursal(String ruta, CadenaDeSupermercados cadena, String nombreSuc) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        IntercambiadorDeOrden.desordenar(lineas);
        for (int i = 0; i < lineas.length; i++) {
            String[] prod = lineas[i].split("\"");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                Comparable codigo = prod[0].replace(",", "");
                String descripcion = prod[1].replace("\"", "");
                Double precio = Double.valueOf(prod[2].replace(",", ""));

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Producto producto = new Producto(codigo, descripcion, precio);
                cadena.incorporarProductoEnSucursal(producto, nombreSuc);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i] + "\n");

            }

        }
        System.out.println("Los productos del archivo: " + ruta + " fueron incorporados correctamente");
        System.out.println("***************************************************************************************\n");
    }

}
