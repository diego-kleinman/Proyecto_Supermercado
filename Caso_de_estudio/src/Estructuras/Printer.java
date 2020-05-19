package Estructuras;

public class Printer {

    public static void imprimirPorCodigo(Lista<Sucursal> listaSuc) {
        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            System.out.println("Sucursal : " + aux.getDato().getNombre());
            TArbolBB<Producto> arbol = aux.getDato().getArbolProductos();
            Printer.imprimirArbolCodigo(arbol);
            aux = aux.getSiguiente();
        }
    }

    public static void imprimirPorCodigo(Lista<Sucursal> listaSuc, String separador) {
        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            System.out.println("Sucursal : " + aux.getDato().getNombre());
            TArbolBB<Producto> arbol = aux.getDato().getArbolProductos();
            Printer.imprimirArbolCodigoSeparador(arbol, separador);
            aux = aux.getSiguiente();
        }
    }

    public static void imprimirNombres(Lista<Sucursal> listaSuc) {
        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            System.out.println("Sucursal : " + aux.getDato().getNombre());
            TArbolBB<Producto> arbol = aux.getDato().getArbolProductos();
            Printer.imprimirArbolNombre(arbol);
            aux = aux.getSiguiente();
        }

    }

    public static void imprimirNombres(Lista<Sucursal> listaSuc, String separador) {
        Nodo<Sucursal> aux = listaSuc.getPrimero();
        while (aux != null) {
            System.out.println("Sucursal : " + aux.getDato().getNombre());
            TArbolBB<Producto> arbol = aux.getDato().getArbolProductos();
            Printer.imprimirArbolNombreSeparador(arbol, separador);
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

    private static void imprimirArbolCodigo(TArbolBB<Producto> arbol) {
        try {
            Lista<Producto> listaSuc = arbol.inorden();
            Nodo<Producto> aux = listaSuc.getPrimero();
            while (aux != null) {
                System.out.println(aux.getEtiqueta() + " stock: " + aux.getDato().getStock().toString());
                aux = aux.getSiguiente();
            }
        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }

    private static void imprimirArbolCodigoSeparador(TArbolBB<Producto> arbol, String separador) {
        try {
            Lista<Producto> listaSuc = arbol.inorden();
            Nodo<Producto> aux = listaSuc.getPrimero();
            while (aux != null) {
                System.out.print(aux.getEtiqueta() + " stock: " + aux.getDato().getStock().toString() + separador);
                aux = aux.getSiguiente();
            }

        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }

    private static void imprimirArbolNombre(TArbolBB<Producto> arbol) {

        try {
            Lista<Producto> listaSuc = arbol.inorden();
            Nodo<Producto> aux = listaSuc.getPrimero();
            while (aux != null) {
                Producto prod = aux.getDato();
                System.out.println(prod.getNombre() + " stock: " + prod.getStock().toString());
                aux = aux.getSiguiente();
            }

        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }

    private static void imprimirArbolNombreSeparador(TArbolBB<Producto> arbol, String separador) {
        try {
            Lista<Producto> listaSuc = arbol.inorden();
            Nodo<Producto> aux = listaSuc.getPrimero();
            while (aux != null) {
                Producto prod = aux.getDato();
                System.out.print(prod.getNombre() + " stock: " + prod.getStock().toString() + separador);
                aux = aux.getSiguiente();
            }

        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }

    public static void imprimirArbolInteger(TArbolBB<Integer> arbol) {
        try {
            Lista<Integer> listaSuc = arbol.inorden();
            Nodo<Integer> aux = listaSuc.getPrimero();
            while (aux != null) {
                Integer stock = aux.getDato();
                System.out.println(aux.getEtiqueta() + " stock: " + stock.toString());
                aux = aux.getSiguiente();
            }

        } catch (NullPointerException ex) {
            System.out.println("El arbol no tiene productos");
        }

    }


}
