package Estructuras;

import Exceptions.SucursalNotFound;

public class Main {

    public static void main(String[] args) {
        CadenaDeSupermercados geant = new CadenaDeSupermercados();

        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/ArchivosDePrueba/pruebaSucursales.txt");
        for (int i = 0; i < lineas2.length; i++) {
            String[] aux = lineas2[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                String nombre = aux[0].toUpperCase();
                String telefono = aux[1];
                String direccion = aux[2];
                String barrio = aux[3];
                String ciudad = aux[4];

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Sucursal sucursal = new Sucursal(direccion, telefono, nombre, barrio, ciudad);
                geant.incorporarSucursal(sucursal);
            } catch (Exception e) {

                System.out.println("Error de lectura de sucursal: \n" + "linea: " + lineas2[i]);

            }

        }

        System.out.println("Las sucursales fueron incorporadas a la cadena de supermercados");
        System.out.println("***************************************************************************************");

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/ArchivosDePrueba/altasPrueba.txt");
        for (int i = 0; i < lineas.length; i++) {
            String[] prod = lineas[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                Comparable codigo = prod[0];
                String descripcion = prod[1];
                int precio = Integer.valueOf(prod[2]);
                int cantidad = 0;

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Producto producto = new Producto(codigo, descripcion, precio, cantidad);
                geant.incorporarProductoEnCadena(producto);

            } catch (Exception e) {

                System.out.println("Error de lectura de producto: \n" + "linea: " + lineas[i]);

            }

        }
        System.out.println("Los productos deseados se incorporaron correctamente");
        System.out.println("***************************************************************************************");

        Producto test = new Producto("123", "Galletas", 103, 107);

        try {
            geant.incorporarProductoEnSucursal(test, "sUc12");
        } catch (SucursalNotFound e) {
            System.out.println("La sucursal no fue encontrada");
        }

        Producto test2 = new Producto("123", "Galletas", 103, 107);

        try {
            geant.incorporarProductoEnSucursal(test2, "sUc1");
        } catch (SucursalNotFound e) {
            System.out.println("La sucursal no fue encontrada");
        }

        Nodo<Sucursal> e = geant.getListaSucursales().getPrimero();
        while (e != null) {
            System.out.print(e.getDato().getNombre() + ": ");
            Printer.imprimirPorCodigo(e.getDato().getArbolProductos(), ";");
            e = e.getSiguiente();
        }
        System.out.println("****************************************");
        System.out.println("Elimino un producto el 123 y el 1000073");
        geant.eliminarProductoEnCadena("123");
        geant.eliminarProductoEnCadena("1000073");
        Nodo<Sucursal> b = geant.getListaSucursales().getPrimero();
        while (b != null) {
            System.out.print(b.getDato().getNombre() + ": ");
            Printer.imprimirPorCodigo(b.getDato().getArbolProductos(), ";");
            b = b.getSiguiente();
        }

        //TArbolBB<Producto> aux = a.getArbolProductos();
        //Printer.imprimirPorCodigo(aux, ";");
        //Printer.ImprimirPorCodigo(aux);
//        Printer.imprimirPorCodigo(aux, ";");
//        Printer.ImprimirNombres(aux);
//        Printer.imprimirNombres(aux, "--");
    }

}