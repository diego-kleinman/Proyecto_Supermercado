
package Builders;
import Estructuras.CadenaDeSupermercados;
import Estructuras.ManejadorArchivosGenerico;


public class BuilderEliminar {

    public static void eliminarEnCadena(String ruta,CadenaDeSupermercados cadena) {

        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas3.length; i++) {
            String codigo = lineas3[i];
            try {
                cadena.eliminarProductoEnCadena(codigo);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas3[i]);

            }

        }

    }
    
    public static void eliminarEnSucursal(String ruta,CadenaDeSupermercados cadena,String nombreSuc) {

        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas3.length; i++) {
            String codigo = lineas3[i];
            try {
                cadena.eliminarProductoEnSucursal(codigo,nombreSuc);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas3[i]);

            }

        }

    }
}
