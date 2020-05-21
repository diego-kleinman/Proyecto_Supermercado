package Estructuras;

/**
 * Clase encargada de generar un Array auxiliar para mandar al manejador de
 * archivos cuando se necesitan listados por ciudad o barrio
 *
 * @author Diego
 */
public class GeneradorArray {

    /**
     * Método encargado de generar un array, se usa para los listados ordenados
     * por ciudad y por barrio
     *
     * @param lista Lista
     * @param contador contador auxiliar
     * @return String[]
     */
    public static String[] generarArray(Lista<TArbolBB<Integer>> lista, int contador) {
        if (lista.esVacia()) {
            System.out.println("No hay productos en la cadena de supermercados");
            return null;
        } else {
            String[] salida = new String[contador];
            int contadorInterno = 0;

            Nodo<TArbolBB<Integer>> nodo = lista.getPrimero();
            while (nodo != null) {
                //Pongo el nombre de la ciudad
                salida[contadorInterno] = nodo.getEtiqueta().toString();
                contadorInterno++;
                //Genero una lista con todos los elementos del arbol de ese nodo
                Lista<Integer> listaAux = nodo.getDato().inorden();
                Nodo<Integer> nodoAux = listaAux.getPrimero();
                //Recorro los elementos y los voy agregando a la salida
                while (nodoAux != null) {
                    salida[contadorInterno] = nodoAux.getEtiqueta() + "stock: " + nodoAux.getDato();
                    contadorInterno++;
                    nodoAux = nodoAux.getSiguiente();
                }
                nodo = nodo.getSiguiente();
            }
            return salida;
        }

    }

}
