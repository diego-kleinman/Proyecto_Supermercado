package Estructuras;

import Interfaces.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Constructos de la clase TArbolBB
     */
    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB<T> getRaiz() {
        return this.raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Método que llama al método inorden de TElementoAB y devuelve una lista
     *
     * @return Lista
     */
    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<>();
            raiz.inorden(listaInorden);
        }
        return listaInorden;
    }

    /**
     * Método que llama al método obtenerTamanio de TElementoAB y devuelve el
     * tamanio
     *
     * @return Tamanio
     */
    @Override
    public int obtenerTamanio() {
        if (!esVacio()) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }

    }

    /**
     * Método que llama al método eliminar de TElementoAB
     *
     * @param unaEtiqueta etiqueta a eliminar
     * @return True si se eliminó el elemento, False en caso contrario
     */
    public boolean eliminar(Comparable unaEtiqueta) {
        if (this.raiz != null) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que llama al método inordenQueDevuelveArbolPorNombre de
     * TElementoAB
     *
     * @return TArbolBB
     */
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

    /**
     * Método que llama al método inordenQueDevuelveArray de TElementoAB
     *
     * @return Array de String
     */
    public String[] inordenQueDevuelveArray() {
        String[] array = new String[this.obtenerTamanio() + 1];
        int[] contador = new int[1];
        contador[0] = 1;
        if (!esVacio()) {
            raiz.inordenQueDevuelveArray(array, contador);
        }
        return array;
    }

}
