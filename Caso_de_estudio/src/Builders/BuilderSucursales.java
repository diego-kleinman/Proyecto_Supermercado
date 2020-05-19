package Builders;

import Estructuras.*;

public class BuilderSucursales {

    public static void build(String ruta, CadenaDeSupermercados cadena) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        for (int i = 0; i < lineas.length; i++) {
            String[] aux = lineas[i].split(",");
            try {
                // Creamos las variables necesarias para instanciar un objeto de la clase sucursal
                String nombre = aux[0].toUpperCase();
                String telefono = aux[1];
                String direccion = aux[2];
                String barrio = aux[3];
                String ciudad = aux[4];

                // Instanciamos el objeto sucursal
                Sucursal sucursal = new Sucursal(direccion, telefono, nombre, barrio, ciudad);
                // Lo insertamos en la cadena de supermercados
                cadena.incorporarSucursal(sucursal);
            } catch (Exception ex) {

                System.out.println("Error de lectura de sucursal: \n" + "linea: " + lineas[i]);

            }

        }

    }

}
