package Interfaces;

import Estructuras.Nodo;

public interface INodo<T> {

    /**
     * devuelve el dato del nodo
     *
     * @return
     */
    public T getDato();

    /**
     * devuelve el siguiente del nodo
     *
     * @return
     */
    public Nodo<T> getSiguiente();

    /**
     * "engancha" el nodo con otro nodo a continuacion
     *
     */
    public void setSiguiente(Nodo<T> nodo);

    /**
     * Devuelve la etiqueta del nodo
     *
     * @return
     */
    public Comparable getEtiqueta();

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
