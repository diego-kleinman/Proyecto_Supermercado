package Menu;

import Builders.BuilderStock;
import Estructuras.CadenaDeSupermercados;
import Estructuras.Printer;
import Estructuras.Producto;
import java.util.Scanner;

public class MenuAgregarStock {

    public static void display(CadenaDeSupermercados cadena) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu stock:");
            System.out.println("1: Agregar stock por archivo");
            System.out.println("0: Salir");

            try {
                respuesta = scannerInt.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Recuerde que el formato de las lineas del archivo debe ser: nombre de sucursal,codigo de producto,stock a agregar ;"
                                + "(con la extension '.txt' incluida) ; la ruta puede ser relativa o absoluta y debe ser de la forma "
                                + "forma X/y/z.txt , no de la forma X\\y\\z.txt): \n"
                                + "Ingrese ruta del archivo de stock");
                        String ruta = scannerStr.nextLine();
                        try{
                            BuilderStock.build(ruta, cadena);
                            break;
                        }
                        catch(Exception ex){
                            System.out.println("Hubo un error al cargar el archivo, revise que esté en el formato correcto");
                            break;
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
