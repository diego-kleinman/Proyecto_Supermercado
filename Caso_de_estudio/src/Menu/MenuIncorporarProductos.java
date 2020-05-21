package Menu;

import Builders.BuilderProductos;
import Estructuras.CadenaDeSupermercados;
import Estructuras.Producto;
import java.util.Scanner;

/**
 * Menú encargado de las operaciónes relacionadas a la incorporación de
 * productos
 *
 * @author Diego
 */
public class MenuIncorporarProductos {

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
            System.out.println("Menu Productos:");
            System.out.println("1: Incorporar producto manualmente a la cadena de supermercados (en todas las sucursales)");
            System.out.println("2: Incorporar producto manualmente en una sucursal específica");
            System.out.println("3: Incorporar productos desde archivo a la cadena de supermercados (en todas las sucursales)");
            System.out.println("4: Incorporar productos desde archivo en una sucursal específica");

            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese codigo del producto: ");
                        String codigo = scannerStr.nextLine();
                        System.out.println("Ingrese descripcion del producto: ");
                        String descripcion = scannerStr.nextLine();
                        System.out.println("Ingrese precio del producto: ");
                        Double precio = Double.valueOf(scannerStr.nextLine());
                        try {
                            Producto prod = new Producto(codigo, descripcion, precio);
                            cadena.incorporarProductoEnCadena(prod);
                            System.out.println("El producto fue ingresado con exito a la cadena de supermercados \n");

                        } catch (Exception ex) {
                            System.out.println("El producto no pudo ser ingresado en la cadena de supermercados, intentelo nuevamente \n");

                        }
                        break;
                    case 2:
                        System.out.println("Ingrese codigo del producto: ");
                        String codigo2 = scannerStr.nextLine();
                        System.out.println("Ingrese descripcion del producto: ");
                        String descripcion2 = scannerStr.nextLine();
                        System.out.println("Ingrese precio del producto: ");
                        Double precio2 = Double.valueOf(scannerStr.nextLine());
                        System.out.println("Ingrese el nombre de la sucursal donde lo quiere agregar");
                        String nombreSuc = scannerStr.nextLine();
                        try {
                            Producto prod = new Producto(codigo2, descripcion2, precio2);
                            cadena.incorporarProductoEnSucursal(prod, nombreSuc);
                            System.out.println("El producto: " + descripcion2 + " fue ingresado correctamente en la sucursal " + nombreSuc + "\n");

                        } catch (Exception ex) {
                            System.out.println("El producto no pudo ser ingresado en la sucursal \n verifique los datos ingresados");

                        }
                        break;
                    case 3:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: codigo,\"nombre\",precio ;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de productos");
                        String ruta = scannerStr.nextLine();
                        try {
                            BuilderProductos.buildCadena(ruta, cadena);
                            System.out.println("Los productos fueron ingresados correctamente a la cadena de supermercados");

                        } catch (Exception ex) {
                            System.out.println("Error al ingresar el archivo, asegurese de que cumpla con el formato correcto");

                        }
                        break;
                    case 4:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: codigo,\"nombre\",precio ;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de productos");
                        String ruta2 = scannerStr.nextLine();
                        System.out.println("Ingrese nombre de la sucursal: ");
                        String nombreSuc2 = scannerStr.nextLine();
                        try {
                            BuilderProductos.buildSucursal(ruta2, cadena, nombreSuc2);
                            System.out.println("Los productos fueron ingresados correctamente en la sucursal: " + nombreSuc2);

                        } catch (Exception ex) {
                            System.out.println("Error al ingresar el archivo, asegurese de que cumpla con el formato correcto");

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
