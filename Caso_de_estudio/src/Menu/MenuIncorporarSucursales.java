package Menu;
import Estructuras.CadenaDeSupermercados;
import Estructuras.Sucursal;
import Builders.BuilderSucursales;

import java.util.Scanner;

public class MenuIncorporarSucursales {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu sucursales:");
            System.out.println("1: Incorporar sucursal manualmente");
            System.out.println("2: Incorporar sucursales desde archivo");
            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese nombre de la sucursal: ");
                        String nombre = scannerStr.nextLine();
                        System.out.println("Ingrese telefono de la sucursal: ");
                        String telefono = scannerStr.nextLine();
                        System.out.println("Ingrese direccion de la sucursal: ");
                        String direccion = scannerStr.nextLine();
                        System.out.println("Ingrese barrio de la sucursal: ");
                        String barrio = scannerStr.nextLine();
                        System.out.println("Ingrese ciudad de la sucursal: ");
                        String ciudad = scannerStr.nextLine();                    
                        try {
                            Sucursal suc = new Sucursal(direccion, telefono, nombre, barrio, ciudad);
                            cadena.incorporarSucursal(suc);
                            System.out.println("La sucursal fue incorporada con éxito \n");
                            
                        } catch (Exception ex) {
                            System.out.println("Hubo un error en el ingreso de la sucursal deseada, intentelo nuevamente  \n ");
                            
                        }
                        break;
                    case 2:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: nombre,telefono,direccion,barrio,ciudad ;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de sucursales");
                        String ruta = scannerStr.nextLine();
                        try {
                            BuilderSucursales.build(ruta, cadena);
                            
                        } catch (Exception ex) {
                            System.out.println("Ocurrio un error inesperado al ingresar el archivo, revise que tenga el formato correcto");
                            
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
