package Menu;

import Builders.BuilderProductos;
import Builders.BuilderStock;
import Builders.BuilderSucursales;
import Estructuras_Básicas.CadenaDeSupermercados;
import java.util.Scanner;

/**
 * Menú encargado de ejecutar todas las funciones del sistema software, Está
 * formado por varios submenues referentes a todas las posibles operaciones que
 * se pueden hacer en el sistema.
 *
 * En este menú principal se instancia una nueva cadenaDeSupermercados de nombre
 * geant y se pasa como parámetro a cada submenú cuando el uso de este es
 * requerido con el fin de que todas las operaciones actuen sobre la misma
 * CadenaDeSupermercados
 *
 * @author Diego
 */
public class Menu {

    public static void main(String[] args) {

        CadenaDeSupermercados geant = new CadenaDeSupermercados();

        Scanner entrada = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu principal:");
            System.out.println("1: Incorporar sucursales");
            System.out.println("2: Incorporar productos");
            System.out.println("3: Agregar Stock");
            System.out.println("4: Simular ventas");
            System.out.println("5: Eliminacion de productos");
            System.out.println("6: Operaciones de listados");
            System.out.println("7: Inicializar cadena con archivos proporcionados por el cuerpo docente");
            System.out.println("0: Salir");

            respuesta = entrada.nextInt();

            switch (respuesta) {
                case 1:
                    MenuIncorporarSucursales.display(geant);
                    break;
                case 2:
                    MenuIncorporarProductos.display(geant);
                    break;
                case 3:
                    MenuAgregarStock.display(geant);
                    break;
                case 4:
                    MenuSimularVentas.display(geant);
                    break;
                case 5:
                    MenuEliminarProductos.display(geant);
                    break;
                case 6:
                    MenuListados.display(geant);
                    break;
                case 7:
                    /*Esta opcion fue creada para inicializar rapidamente todos
                    los archivos proporcionados por el cuerpo docente*/
                    try {
                        BuilderSucursales.build("src/Archivos/sucursales.txt", geant);
                        BuilderProductos.buildCadena("src/Archivos/productos.txt", geant);
                        BuilderStock.build("src/Archivos/stock.txt", geant);
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error inesperado al inicializar la cadena");
                    }
                    break;
                case 0:
                    flag = false;
                    break;

            }

        }

    }

}
