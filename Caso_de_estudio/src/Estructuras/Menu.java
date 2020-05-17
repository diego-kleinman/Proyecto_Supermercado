package Estructuras;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int respuesta;
        boolean flag = true;

        while (flag) {
            System.out.println("Menu de operaciones");
            System.out.println("1: hola");
            System.out.println("2: como");
            System.out.println("3: andas");
            System.out.println("0: salir del menu");

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
                case 0:
                    flag = false;
                    break;

            }

        }

    }

}
