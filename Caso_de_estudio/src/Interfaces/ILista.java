package Interfaces;

import Estructuras.Nodo;

public interface ILista<T> {

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */
    public void insertar(Nodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public Nodo<T> buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Retorna la cantidad de elementos de la lista.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Asigna el primer nodo de la lista
     *
     * @param unNodo - el nodo indicado
     */
    public void setPrimero(Nodo<T> unNodo);

}
