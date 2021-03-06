package Menu;

import Builders.BuilderStock;
import Estructuras_Básicas.CadenaDeSupermercados;
import java.util.Scanner;

/**
 * Menú encargado de las operaciónes relacionadas al stock
 *
 * @author Diego
 */
public class MenuAgregarStock {

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
                        try {
                            BuilderStock.build(ruta, cadena);
                            System.out.println("El stock fue cargado correctamente en la cadena de supermercados");

                        } catch (Exception ex) {
                            System.out.println("Hubo un error al cargar el archivo, revise que cumpla con el formato correcto");

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
