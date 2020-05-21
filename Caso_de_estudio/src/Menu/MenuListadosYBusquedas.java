package Menu;

import Builders.BuilderStock;
import Estructuras.CadenaDeSupermercados;
import java.util.Scanner;

public class MenuListadosYBusquedas {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu listados y busquedas:");
            System.out.println("1: Indicar las existencias de un producto en la cadena de supermercados");
            System.out.println("2: Indicar las existencias de un producto ordenadas por sucursal");
            System.out.println("3: Listar todos los productos registrados ordenados por nombre y con su stock en la cadena de supermercados");
            System.out.println("4: Listar todos los productos de una sucursal ordenados por nombre y con su stock en esa sucursal");
            System.out.println("5: Listar todos los productos registrados ordenados por ciudad y con su stock en esa ciudad");
            System.out.println("6: Listar todos los productos registrados ordenados por barrio y con su stock en ese barrio");
            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese clave del producto");
                        String codigo = scannerStr.nextLine();
                        try {
                            cadena.indicarExistenciasTotales(codigo);
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }
                        break;

                    case 2:
                        System.out.println("Ingrese clave del producto");
                        String codigo2 = scannerStr.nextLine();
                        try {
                            cadena.indicarExistenciasPorSucursal(codigo2);
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }

                        break;

                    case 3:
                        System.out.println("Ingrese un nombre para su archivo de salida (El mismo se encontrará en la carpeta 'Archivos') :");
                        String nombre = scannerStr.nextLine();
                        try {
                            cadena.productosTotalesOrdenadosPorNombre(nombre);
                            System.out.println("Se generó el archivo con éxito");
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }
                        break;

                    case 4:
                        System.out.println("Ingrese una sucursal");
                        String suc = scannerStr.nextLine();
                        System.out.println("Ingrese un nombre para su archivo de salida (El mismo se encontrará en la carpeta 'Archivos') :");
                        String nombre2 = scannerStr.nextLine();
                        try {
                            cadena.productosSucursalOrdenadosPorNombre(suc, nombre2);
                            System.out.println("Se generó el archivo con éxito");
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }
                        break;

                    case 5:
                        System.out.println("Ingrese un nombre para su archivo de salida (El mismo se encontrará en la carpeta 'Archivos') :");
                        String nombre3 = scannerStr.nextLine();
                        try {
                            cadena.productosTotalesOrdenadosPorCiudad(nombre3);
                            System.out.println("Archivo generado con éxito");
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }

                    case 6:
                        System.out.println("Ingrese un nombre para su archivo de salida (El mismo se encontrará en la carpeta 'Archivos') :");
                        String nombre4 = scannerStr.nextLine();
                        try {
                            cadena.productosTotalesOrdenadosPorBarrio(nombre4);
                            System.out.println("Archivo generado con éxito");
                        } catch (Exception ex) {
                            System.out.println("Ocurrió un error inesperado, intente nuevamente");
                        }

                    case 0:
                        flag = false;
                        break;

                }

            } catch (Exception e) {
                System.out.println("Error al ingresar numero de opcion \n");
                flag = false;

            }

        }

    }

}
