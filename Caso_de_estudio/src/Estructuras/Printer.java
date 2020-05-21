package Estructuras;

public class Printer {

    public static void imprimirListaSucursalesConStock(TArbolBB<String> arbol) {
        if (arbol.esVacio()) {
            System.out.println("Lo siento, no disponemos de sucursales con el stock requerido");
        } else {
            Lista<String> listaSuc = arbol.inorden();
            String productosSuc = "";
            Nodo<String> aux = listaSuc.getPrimero();
            while (aux != null) {
                productosSuc = productosSuc + aux.getDato() + ",stock :" + aux.getEtiqueta() + " ||";
                aux = aux.getSiguiente();
            }
            System.out.println(productosSuc + "\n");
        }

    }

    public static void imprimirExistenciasPorSucursal(Comparable codigo, Lista<Integer> lista) {
        System.out.println("Las existencias del producto: " + codigo.toString() + " por sucursal son: \n");
        Nodo<Integer> aux = lista.getPrimero();
        while (aux != null) {
            String nombreSuc = aux.getEtiqueta().toString();
            System.out.println(nombreSuc + " stock: " + aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public static void imprimirExistenciasTotales(Comparable codigo, int numero) {
        System.out.println("Las existencias totales del producto: " + codigo.toString() + " son " + numero + "\n");
    }


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
