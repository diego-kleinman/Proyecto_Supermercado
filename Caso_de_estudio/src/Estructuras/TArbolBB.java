package Estructuras;

import Interfaces.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB<T> getRaiz() {
        return this.raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<>();
            raiz.inorden(listaInorden);
        }
        return listaInorden;
    }

    @Override
    public int obtenerTamanio() {
        if (!esVacio()) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }

    }

    public boolean eliminar(Comparable unaEtiqueta) {
        if (this.raiz != null) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
            return true;
        } else {
            return false;
        }
    }

    public TArbolBB<Integer> inordenQueDevuelveArbolPorNombre() {
        TArbolBB<Integer> arbol = null;
        int[] array = new int[1];
        array[0] = 0;
        if (!esVacio()) {
            arbol = new TArbolBB<>();
            raiz.inordenQueDevuelveArbolPorNombre(arbol, array);
        }
        return arbol;
    }

    public void inordenQueImprime(String suc, String ruta) {
        String[] array = new String[this.obtenerTamanio() + 1];
        array[0] = suc.toUpperCase();
        int[] contador = new int[1];
        contador[0] = 1;
        if (!esVacio()) {
            raiz.inordenQueImprime(array, contador);
        }
        ManejadorArchivosGenerico.escribirArchivo(ruta, array);
    }

}
