package Menu;

import Builders.BuilderVentas;
import Estructuras.CadenaDeSupermercados;
import java.util.Scanner;

public class MenuSimularVentas {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu ventas:");
            System.out.println("1: Simular ventas por archivo");
            System.out.println("2: Simular venta manual");
            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: nombre de sucursal,codigo de producto,cantidad a vender;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de ventas:");
                        String ruta = scannerStr.nextLine();
                        try {
                            BuilderVentas.build(ruta, cadena);
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al cargar el archivo, asegurese de que cumpla con el formato correcto");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese codigo del producto: ");
                        String codigo = scannerStr.nextLine();
                        System.out.println("Ingrese cantidad a vender: ");
                        Integer cantidad = Integer.valueOf(scannerStr.nextLine());
                        System.out.println("Ingrese sucursal: ");
                        String nombreSuc = scannerStr.nextLine();
                        try {
                            cadena.VenderProductoEnSucursal(codigo, cantidad, nombreSuc);
                        } catch (Exception ex) {
                            System.out.println("Hubo un error al simular la venta, intente nuevamente");
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
