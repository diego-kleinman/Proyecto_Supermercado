package Menu;

import Builders.BuilderProductos;
import Estructuras.CadenaDeSupermercados;
import Estructuras.Printer;
import Estructuras.Producto;
import Estructuras.Sucursal;
import Exceptions.SucursalNotFound;
import java.util.Scanner;

public class MenuIncorporarProductos {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu sucursales:");
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
                            break;
                        } catch (Exception ex) {
                            System.out.println("El producto no pudo ser ingresado en la cadena de supermercados \n");
                            break;
                        }

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
                            cadena.incorporarProductoEnSucursal(prod,nombreSuc);
                            System.out.println("El producto fue ingresado con exito a la cadena de supermercados \n");
                            Printer.imprimirPorCodigo(cadena.getListaSucursales());
                            break;
                        } 
                        catch (SucursalNotFound ex){
                            System.out.println("La sucursal indicada no fue encontrada, verifiquela + \n");
                            break;
                        }
                        catch (Exception ex) {
                            System.out.println("El producto no pudo ser ingresado en la sucursal \n verifique los datos ingresados");
                            break;
                        }

                    case 3:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: codigo,\"nombre\",precio ;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de productos");
                        String ruta = scannerStr.nextLine();
                        try{
                            BuilderProductos.buildCadena(ruta, cadena);
                            break;
                        }
                        catch (Exception ex){
                            System.out.println("Error al ingresar el archivo, asegurese de que cumpla los requerimientos necesarios");
                            break;
                        }
                        

                    case 4:

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
