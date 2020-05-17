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
                    productosSuc += temp.getEtiqueta() + "; stock: " + temp.getDato().getStock().toString() + "\n";
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
                    productosSuc += temp.getEtiqueta() + " stock: " + temp.getDato().getStock().toString() + separador;
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
                    productosSuc += temp.getDato().getNombre() + "; stock: " + temp.getDato().getStock().toString() + "\n";
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
                    productosSuc += temp.getDato().getNombre() + " stock: " + temp.getDato().getStock().toString() + separador;
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

    public static void imprimirExistenciasPorSucursal(Comparable codigo,Lista<Integer> lista) {
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

}
