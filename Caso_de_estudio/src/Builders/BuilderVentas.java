package Builders;

import Estructuras.CadenaDeSupermercados;
import Estructuras.IntercambiadorDeOrden;
import Estructuras.ManejadorArchivosGenerico;
import Exceptions.SucursalNotFound;

public class BuilderVentas {

    public static void build(String ruta, CadenaDeSupermercados cadena) {
        String[] lineas5 = ManejadorArchivosGenerico.leerArchivo(ruta);
        IntercambiadorDeOrden.desordenar(lineas5);
        for (int i = 0; i < lineas5.length; i++) {
            String[] str = lineas5[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                String nombreSuc = str[0];
                Comparable codigo = str[1];
                Integer nroVenta = Integer.valueOf(str[2]);

                if (nroVenta > 0) {
                    // Instanciamos el objeto producto con las variables creadas anteriormente.
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
