
package Builders;
import Estructuras.CadenaDeSupermercados;
import Estructuras.ManejadorArchivosGenerico;


public class BuilderEliminar {

    public static void eliminar(String ruta,CadenaDeSupermercados cadena) {

        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas3.length; i++) {
            String codigo = lineas3[i];
            try {
                cadena.eliminarProductoEnCadena(codigo);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas3[i]);

            }

        }
        System.out.println("Los productos deseados se eliminaron correctamente correctamente");
        System.out.println("***************************************************************************************");
    }
}
