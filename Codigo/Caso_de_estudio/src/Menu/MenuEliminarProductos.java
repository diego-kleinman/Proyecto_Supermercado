package Menu;

import Builders.BuilderEliminar;
import Estructuras_Básicas.CadenaDeSupermercados;
import java.util.Scanner;

/**
 * Menú encargado de las operaciónes relacionadas a las eliminaciones de
 * productos
 *
 * @author Diego
 */
public class MenuEliminarProductos {

    /**
     * Método que recibe la cadenaDeSupermercados instanciada en el menú
     * principal y realiza las operaciones que se seleccionen
     *
     * @param cadena
     */
    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu eliminar:");
            System.out.println("1: Eliminar productos de la cadena de supermercados por archivo");
            System.out.println("2: Eliminar producto de la cadena de supermercados manualmente");
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
                            System.out.println("Eliminaciones realizadas con éxito");
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al cargar el archivo, asegurese de que cumpla con el formato correcto");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese código a eliminar:");
                        String codigo = scannerStr.nextLine();
                        try {
                            cadena.eliminarProductoEnCadena(codigo);
                            System.out.println("Eliminado con éxito");
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
                            System.out.println("Eliminado con éxito");
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al cargar el archivo, asegurese de que cumpla con el formato correcto");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese código a eliminar:");
                        String codigo2 = scannerStr.nextLine();
                        System.out.println("Ingrese sucursal en la cual eliminar:");
                        String nombreSuc2 = scannerStr.nextLine();
                        try {
                            cadena.eliminarProductoEnSucursal(codigo2, nombreSuc2);
                            System.out.println("Eliminado con éxito");
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
