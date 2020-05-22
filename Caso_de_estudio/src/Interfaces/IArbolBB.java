package Interfaces;

import Estructuras_Básicas.Lista;
import Estructuras_Básicas.TElementoAB;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacion
     */
    public boolean insertar(TElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * @return una Lista con los elementos del recorrido.
     */
    public Lista<T> inOrden();

    /**
     * Retorna el tamanio del arbol.
     *
     * @return Tamanio del arbol.
     */
    public int obtenerTamanio();

}
