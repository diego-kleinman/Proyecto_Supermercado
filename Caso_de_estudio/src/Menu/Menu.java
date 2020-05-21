package Menu;

import Builders.BuilderProductos;
import Builders.BuilderStock;
import Builders.BuilderSucursales;
import Estructuras.CadenaDeSupermercados;
import java.util.Scanner;

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
                    MenuListadosYBusquedas.display(geant);
                    break;
                case 7:
                    try {
                        BuilderSucursales.build("src/Archivos/5sucursales.txt", geant);
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
