package Menu;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

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
                    System.out.println("hola");
                    break;
                case 2:
                    System.out.println("como");
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
