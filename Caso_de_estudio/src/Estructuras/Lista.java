package Estructuras;

import Interfaces.ILista;
import Interfaces.INodo;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public void insertar(Nodo<T> unNodo) {

        if (esVacia()) {
            primero = unNodo;
            ultimo = unNodo;
        } else {
            ultimo.setSiguiente(unNodo);
            ultimo = unNodo;
        }

    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        } else if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                ultimo = null;
                return true;
            }
        } else if (ultimo.getEtiqueta().equals(clave)) {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != ultimo) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            ultimo = aux;
            return true;
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

}
