package Estructuras_Básicas;

/**
 * Clase encargada de imprimir por consola
 *
 * @author Diego
 */
public class Printer {

    /**
     * Método encargado de imprimir por consola una lista de sucursales
     *
     * @param arbol TArbolBB
     */
    public static void imprimirListaSucursales(TArbolBB<String> arbol) {
        if (arbol.esVacio()) {
            System.out.println("Lo siento, no disponemos de sucursales con el stock requerido");
        } else {
            Lista<String> listaSuc = arbol.inorden();
            String productosSuc = "";
            Nodo<String> aux = listaSuc.getPrimero();
            while (aux != null) {
                productosSuc += aux.getDato() + ",stock :" + aux.getEtiqueta() + " ||";
                aux = aux.getSiguiente();
            }
            System.out.println(productosSuc + "\n");
        }

    }

    /**
     * Método encargado de imprimir por consola las existencias de un producto
     * por cada sucursal de la cadena de supermercados
     *
     * @param codigo Código de producto
     * @param lista Lista
     */
    public static void imprimirExistenciasPorSucursal(Comparable codigo, Lista<Integer> lista) {
        System.out.println("Las existencias del producto: " + codigo.toString() + " por sucursal son: \n");
        Nodo<Integer> aux = lista.getPrimero();
        while (aux != null) {
            String nombreSuc = aux.getEtiqueta().toString();
            System.out.println(nombreSuc + " stock: " + aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    /**
     * Método encargado de imprimir por consola las existencias totales de un
     * producto
     *
     * @param codigo Codigo de producto
     * @param numero Existencias
     */
    public static void imprimirExistenciasTotales(Comparable codigo, int numero) {
        System.out.println("Las existencias totales del producto: " + codigo.toString() + " son " + numero + "\n");
    }

}
