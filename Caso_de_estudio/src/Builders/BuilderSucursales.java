package Builders;

import Estructuras.CadenaDeSupermercados;
import Estructuras.ManejadorArchivosGenerico;
import Estructuras.Sucursal;

/**
 * Clase encargada de instanciar sucursales
 *
 * @author Diego
 */
public class BuilderSucursales {

    /**
     * Método encargado de construir sucursales a partir de un archivo
     *
     * @param ruta Ruta del archivo
     * @param cadena CadenaDeSupermercados a la cual agregar las sucursales
     */
    public static void build(String ruta, CadenaDeSupermercados cadena) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas.length; i++) {
            String[] aux = lineas[i].split(",");
            try {
                //Intento crear las variables necesarias para instanciar un objeto de la clase sucursal
                String nombre = aux[0].toUpperCase();
                String telefono = aux[1];
                String direccion = aux[2];
                String barrio = aux[3].toLowerCase();
                String ciudad = aux[4].toLowerCase();

                // Instancio el objeto sucursal
                Sucursal sucursal = new Sucursal(direccion, telefono, nombre, barrio, ciudad);
                // Lo intento insertar en la cadena de supermercados
                cadena.incorporarSucursal(sucursal);
            } catch (Exception ex) {

                System.out.println("Error de lectura de sucursal: \n" + "linea: " + lineas[i]);

            }

        }

    }

}
