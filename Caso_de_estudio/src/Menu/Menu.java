package Menu;
import Estructuras.*;
import Builders.*;

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
            System.out.println("7: Salir a menu anterior");
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
                    System.out.println("andas");
                    break;
                case 4:
                    System.out.println("andas");
                    break;
                case 5:
                    System.out.println("andas");
                    break;
                case 6:
                    System.out.println("andas");
                    break;
                case 7:
                    System.out.println("andas");
                    break;
                case 0:
                    flag = false;
                    break;

            }

        }

    }

}