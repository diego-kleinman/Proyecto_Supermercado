package Estructuras;

import java.util.Random;

/**
 * Clase encargada de intercambiar los ordenes de los elementos de un array, se
 * utiliza para asegurar que los arboles no queden desbalanceados.
 *
 * Se hizo a partir de métodos vistos en clase
 * @author Diego
 */
public class IntercambiadorDeOrden {

    public static void cambiarLugar(String[] arrayInicial, int i, int j) {

        String aux = arrayInicial[i];
        String aux2 = arrayInicial[j];
        arrayInicial[i] = aux2;
        arrayInicial[j] = aux;
    }

    public static void desordenar(String[] array) {
        int largo = array.length;
        int j;
        Random rand = new Random();
        for (int i = 0; i < largo; i++) {
            if (i != 0) {
                j = rand.nextInt(i);
                cambiarLugar(array, i, j);
            }

        }

    }

}
