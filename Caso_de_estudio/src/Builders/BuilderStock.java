package Builders;

import Estructuras_Básicas.CadenaDeSupermercados;
import Estructuras_Auxiliares.IntercambiadorDeOrden;
import Estructuras_Auxiliares.ManejadorArchivosGenerico;
import Estructuras_Auxiliares.SucursalNotFound;

/**
 * Clase encargada de instanciar stocks en la cadena de supermercados
 *
 * @author Diego
 */
public class BuilderStock {

    /**
     * Método que se encarga de cargar stock a productos de la cadena de
     * supermercados a partir de un archivo
     *
     * @param ruta Ruta del archivo
     * @param cadena CadenaDeSupermercados a la cual agregar el stock
     */
    public static void build(String ruta, CadenaDeSupermercados cadena) {
        String[] lineas5 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas5.length; i++) {
            String[] str = lineas5[i].split(",");
            try {

                String nombreSuc = str[0];
                Comparable codigo = str[1];
                Integer stock = Integer.valueOf(str[2]);

                // Llamo al método para agregar stock
                cadena.agregarStock(codigo, stock, nombreSuc);
             
            //En caso de que la sucursal no se encuentre agarro la excepción
            } catch (SucursalNotFound ex) {

            } catch (Exception ex) {

                System.out.println("Error de lectura de stock: \n" + "linea: " + lineas5[i]);

            }

        }

    }

}
