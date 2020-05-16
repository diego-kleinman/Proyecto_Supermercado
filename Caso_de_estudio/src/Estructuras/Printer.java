package Estructuras;

public class Printer {

    public static void imprimirPorCodigo(Lista<Sucursal> listaSuc) {

        String productosSuc = "";

        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            TArbolBB arbol = aux.getDato().getArbolProductos();
            Lista<Producto> listaAux = arbol.inorden();
            if (listaAux != null) {
                Nodo<Producto> temp = listaAux.getPrimero();
                while (temp != null) {
                    productosSuc += temp.getEtiqueta() + "\n";
                    //System.out.println(temp.getEtiqueta());
                    temp = temp.getSiguiente();
                }
                System.out.println(aux.getDato().getNombre() + "\n" + productosSuc);
                productosSuc = "";
            } else {
                System.out.println(aux.getDato().getNombre());
            }

            aux = aux.getSiguiente();
        }

    }

    public static void imprimirPorCodigo(Lista<Sucursal> listaSuc, String separador) {
        String productosSuc = "";

        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            TArbolBB arbol = aux.getDato().getArbolProductos();
            Lista<Producto> listaAux = arbol.inorden();
            if (listaAux != null) {
                Nodo<Producto> temp = listaAux.getPrimero();
                while (temp != null) {
                    productosSuc += temp.getEtiqueta() + separador;
                    //System.out.println(temp.getEtiqueta());
                    temp = temp.getSiguiente();
                }
                System.out.println(aux.getDato().getNombre() + ": " + productosSuc);
                productosSuc = "";
            } else {
                System.out.println(aux.getDato().getNombre());
            }

            aux = aux.getSiguiente();
        }
    }

    public static void imprimirNombres(Lista<Sucursal> listaSuc) {

        String productosSuc = "";

        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            TArbolBB arbol = aux.getDato().getArbolProductos();
            Lista<Producto> listaAux = arbol.inorden();
            if (listaAux != null) {
                Nodo<Producto> temp = listaAux.getPrimero();
                while (temp != null) {
                    productosSuc += temp.getDato().getNombre() + "\n";
                    //System.out.println(temp.getEtiqueta());
                    temp = temp.getSiguiente();
                }
                System.out.println(aux.getDato().getNombre() + "\n" + productosSuc);
                productosSuc = "";
            } else {
                System.out.println(aux.getDato().getNombre());
            }

            aux = aux.getSiguiente();
        }

    }
    
    public static void imprimirNombres(Lista<Sucursal> listaSuc, String separador) {
        String productosSuc = "";

        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            TArbolBB arbol = aux.getDato().getArbolProductos();
            Lista<Producto> listaAux = arbol.inorden();
            if (listaAux != null) {
                Nodo<Producto> temp = listaAux.getPrimero();
                while (temp != null) {
                    productosSuc += temp.getDato().getNombre() + separador;
                    //System.out.println(temp.getEtiqueta());
                    temp = temp.getSiguiente();
                }
                System.out.println(aux.getDato().getNombre() + ": " + productosSuc);
                productosSuc = "";
            } else {
                System.out.println(aux.getDato().getNombre());
            }

            aux = aux.getSiguiente();
        }
    }

}
