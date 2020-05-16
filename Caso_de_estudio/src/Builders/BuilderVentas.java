
package Builders;
import Estructuras.*;


public class BuilderVentas {
    public static void build(String ruta, CadenaDeSupermercados cadena) {
    String[] lineas5 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas5.length; i++) {
            String[] str = lineas5[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                String nombreSuc = str[0];
                Comparable codigo = str[1];
                Integer stock = Integer.valueOf(str[2]);

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                cadena.VenderProductoEnSucursal(codigo, stock, nombreSuc);

            } catch (Exception ex) {

                System.out.println("Error de lectura de stock: \n" + "linea: " + lineas5[i]);

            }

        }
        System.out.println("Las ventas del archivo: " + ruta + " fueron realizadas con éxito");
        System.out.println("***************************************************************************************\n");
    }
}