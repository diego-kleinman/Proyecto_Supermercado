package Menu;

import Builders.BuilderEliminar;
import Estructuras.CadenaDeSupermercados;
import Estructuras.Printer;
import java.util.Scanner;

public class MenuEliminarProductos {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu stock:");
            System.out.println("1: Eliminar productos de la cadena por archivo");
            System.out.println("2: Eliminar producto de la cadena manualmente");
            System.out.println("3: Eliminar productos de una sucursal por archivo");
            System.out.println("4: Eliminar producto de una sucursal manualmente");
            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: codigo de producto;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de eliminacion");
                        String ruta = scannerStr.nextLine();
                        try {
                            BuilderEliminar.eliminarEnCadena(ruta, cadena);
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al cargar el archivo, revise que esté en el formato correcto");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese código a eliminar:");
                        String codigo = scannerStr.nextLine();
                        try {
                            cadena.eliminarProductoEnCadena(codigo);
                        } catch (Exception ex) {
                            System.out.println("Error al eliminar el producto,repita la operacion");
                        }
                        break;
                    case 3:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: codigo de producto;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de eliminacion");
                        String ruta2 = scannerStr.nextLine();
                        System.out.println("Ingrese sucursal en la cual eliminar:");
                        String nombreSuc = scannerStr.nextLine();
                        try {
                            BuilderEliminar.eliminarEnSucursal(ruta2, cadena, nombreSuc);
                            Printer.imprimirPorCodigo(cadena.getListaSucursales());
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al ejecutar la eliminacion, compruebe los campos ingresados");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese código a eliminar:");
                        String codigo2 = scannerStr.nextLine();
                        System.out.println("Ingrese sucursal en la cual eliminar:");
                        String nombreSuc2 = scannerStr.nextLine();
                        try {
                            cadena.eliminarProductoEnSucursal(codigo2, nombreSuc2);
                            Printer.imprimirPorCodigo(cadena.getListaSucursales());
                        } catch (Exception ex) {
                            System.out.println("Error al eliminar el producto,repita la operacion");
                        }
                        break;
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
