package Estructuras;

import Interfaces.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    public TElementoAB<T> getRaiz() {
        return this.raiz;
    }

    /**
     * @param unElemento
     * @return
     */
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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones. Esta
     * clase llama al metodo inOrden de la clase TElementoAB
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    @Override
    public String inOrden() {

        if (raiz == null) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inorden(listaInorden);
        }
        return listaInorden;
    }


    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public int obtenerAltura() {
        if (this.raiz == null) {
            return -1;
        }
        return raiz.obtenerAltura() - 1;
    }

    @Override
    public int obtenerTamanio() {
        if (!esVacio()) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }

    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {

        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);

        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
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
            arbol = new TArbolBB<Integer>();
            raiz.inordenQueDevuelveArbolPorNombre(arbol,array);
        }
        return arbol;
    }

    public void inordenQueImprime(String suc,String ruta) {
        String[] array = new String[this.obtenerTamanio() + 1];
        array[0] = suc.toUpperCase();
        int[] contador = new int [1];
        contador[0] = 1;
        if (!esVacio()) {
            raiz.inordenQueImprime(array,contador);
        }
        ManejadorArchivosGenerico.escribirArchivo(ruta, array);
    }

}
