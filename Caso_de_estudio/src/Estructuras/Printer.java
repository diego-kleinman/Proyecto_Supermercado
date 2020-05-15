package Estructuras;

public class Printer {

//    public static void Imprimir(Lista<Producto> lista) {
//
//        if (!lista.esVacia()) {
//            Nodo<Producto> temp = lista.getPrimero();
//            while (temp != null) {
//                System.out.println(temp.getEtiqueta());
//                temp = temp.getSiguiente();
//            }
//        }
//
//    }
    public static void ImprimirPorCodigo(TArbolBB<Producto> arbol) {
        
        Lista<Producto> listaAux = arbol.inorden();
        if (!listaAux.esVacia()) {
            Nodo<Producto> temp = listaAux.getPrimero();
            while (temp != null) {
                System.out.println(temp.getEtiqueta());
                temp = temp.getSiguiente();
            }
        }
       
    }

    public static void imprimirPorCodigo(TArbolBB<Producto> arbol, String separador) {
        String aux = "";
        Lista<Producto> listaAux = arbol.inorden();
        if (!listaAux.esVacia()) {
            Nodo<Producto> temp = listaAux.getPrimero();
            while (temp != null) {
                aux += temp.getEtiqueta() + separador;
                temp = temp.getSiguiente();
            }
        }
        System.out.println(aux);
    }
    
    public static void ImprimirNombres(TArbolBB<Producto> arbol) {
        
        Lista<Producto> listaAux = arbol.inorden();
        if (!listaAux.esVacia()) {
            Nodo<Producto> temp = listaAux.getPrimero();
            while (temp != null) {
                System.out.println(temp.getDato().getNombre());
                temp = temp.getSiguiente();
            }
        }
       
    }

    public static void imprimirNombres(TArbolBB<Producto> arbol, String separador) {
        String aux = "";
        Lista<Producto> listaAux = arbol.inorden();
        if (!listaAux.esVacia()) {
            Nodo<Producto> temp = listaAux.getPrimero();
            while (temp != null) {
                aux += temp.getDato().getNombre() + separador;
                temp = temp.getSiguiente();
            }
        }
        System.out.println(aux);
    }

}
