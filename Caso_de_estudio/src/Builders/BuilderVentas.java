package Builders;

import Estructuras.CadenaDeSupermercados;
import Estructuras.IntercambiadorDeOrden;
import Estructuras.ManejadorArchivosGenerico;
import Exceptions.SucursalNotFound;

/**
 * Clase encargada de simular ventas
 *
 * @author Diego
 */
public class BuilderVentas {
    
    /**
     * Método encargado de simular ventas a partir de un archivo
     * @param ruta Ruta del archivo
     * @param cadena CadenaDeSupermercados sobre la cual simular las ventas
     */
    public static void build(String ruta, CadenaDeSupermercados cadena) {
        String[] lineas5 = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas5.length; i++) {
            String[] str = lineas5[i].split(",");
            try {
                //Intento crear las variables para poder simular la venta
                String nombreSuc = str[0];
                Comparable codigo = str[1];
                Integer nroVenta = Integer.valueOf(str[2]);
                
                //Controlo que el nroVenta no sea negativo
                if (nroVenta > 0) {
                    //Intento hacer la venta
                    cadena.VenderProductoEnSucursal(codigo, nroVenta, nombreSuc);
                }

            } catch (SucursalNotFound ex) {

                System.out.println("La sucursal: " + str[0] + " no fue encontrada en la lista de sucursales de la cadena de supermercados");

            } catch (Exception e) {
                System.out.println("Error de lectura de stock: \n" + "linea: " + lineas5[i]);

            }

        }

    }
}
