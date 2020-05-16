package Estructuras;

import org.apache.commons.lang3.StringUtils;

import Exceptions.SucursalNotFound;

public class Main {

    public static void main(String[] args) {
        CadenaDeSupermercados geant = new CadenaDeSupermercados();

        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/ArchivosDePrueba/1Sucursal.txt");
        for (int i = 0; i < lineas2.length; i++) {
            String[] aux = lineas2[i].split(",");
            try {
                // Creamos las variables necesarias para instanciar un objeto de la clase sucursal
                String nombre = aux[0].toUpperCase();
                String telefono = aux[1];
                String direccion = StringUtils.stripAccents(aux[2]);
                String barrio = aux[3];
                String ciudad = StringUtils.stripAccents(aux[4]);

                // Instanciamos el objeto sucursal
                Sucursal sucursal = new Sucursal(direccion, telefono, nombre, barrio, ciudad);
                // Lo insertamos en la cadena de supermercados
                geant.incorporarSucursal(sucursal);
            } catch (Exception ex) {

                System.out.println("Error de lectura de sucursal: \n" + "linea: " + lineas2[i]);

            }

        }

        System.out.println("Las sucursales fueron incorporadas a la cadena de supermercados");
        System.out.println("***************************************************************************************");

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/ArchivosDePrueba/20Productos.txt");
        for (int i = 0; i < lineas.length; i++) {
            String[] prod = lineas[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                Comparable codigo = prod[0];
                String descripcion = prod[1].replace("\"", "");
                Double precio = Double.valueOf(prod[2]);

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Producto producto = new Producto(codigo, descripcion, precio);
                geant.incorporarProductoEnCadena(producto);

            } catch (Exception ex) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i]);

            }

        }
        System.out.println("Los productos deseados se incorporaron correctamente");
        System.out.println("***************************************************************************************");

        Lista<Sucursal> aux = geant.getListaSucursales();
        Printer.imprimirNombres(aux, ";");
//----------------------------------------------------------------------------------------------------------------
          //Test de incorporar producto en una sucursal
//        Producto test = new Producto("123", "Galletas", 103.0);
//
//        try {
//            geant.incorporarProductoEnSucursal(test, "local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//
//        Producto test2 = new Producto("123", "Galletas", 103.0);
//
//        try {
//            geant.incorporarProductoEnSucursal(test2, "local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//        Lista<Sucursal> aux2 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux2);
        
        //-------------------------------------------------------------------------------------------------------------
    
        //Eliminacion de productos por txt
//        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo("src/ArchivosDePrueba/elimPrueba.txt");
//        for (int i = 0; i < lineas3.length; i++) {
//            String codigo = lineas3[i];
//            try {
//                geant.eliminarProductoEnCadena(codigo);
//
//            } catch (Exception ex) {
//
//                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i]);
//
//            }
//
//        }
//        System.out.println("Los productos deseados se eliminaron correctamente correctamente");
//        System.out.println("***************************************************************************************");
//
//        Lista<Sucursal> aux3 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux3);

//        -------------------------------------------------------------------------------------------------------------

//        Nodo<Sucursal> aux = geant.getListaSucursales().getPrimero();
//        while (aux != null) {
//            System.out.print(aux.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(aux.getDato().getArbolProductos(), ";");
//            aux = aux.getSiguiente();
//        }
//        System.out.println("****************************************");
//        System.out.println("Elimino un producto el 123 y el 1000073");
//        geant.eliminarProductoEnCadena("123");
//        geant.eliminarProductoEnCadena("1000073");
//        Nodo<Sucursal> b = geant.getListaSucursales().getPrimero();
//        while (b != null) {
//            System.out.print(b.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(b.getDato().getArbolProductos(), ";");
//            b = b.getSiguiente();
//        }
//        Comparable test3 = "8971892994";
//        System.out.println("****************************************");
//        System.out.println("Elimino producto 1000073 de la sucursal 1");
//        try {
//            geant.eliminarProductoEnSucursal(test3, "local 104");
//            
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//        Lista<Sucursal> aux4 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux4);
//
//        Nodo<Sucursal> aux2 = geant.getListaSucursales().getPrimero();
//        while (aux2 != null) {
//            System.out.print(aux2.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(aux2.getDato().getArbolProductos(), ";");
//            aux2 = aux2.getSiguiente();
//        }
        //TArbolBB<Producto> aux = a.getArbolProductos();
        //Printer.imprimirPorCodigo(aux, ";");
        //Printer.ImprimirPorCodigo(aux);
//        Printer.imprimirPorCodigo(aux, ";");
//        Printer.ImprimirNombres(aux);
//        Printer.imprimirNombres(aux, "--");
    }

}
