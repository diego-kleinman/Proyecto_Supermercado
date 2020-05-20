package Estructuras;

import Interfaces.IElementoAB;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;

    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {

        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    public void inordenQueDevuelveArbolPorNombre(TArbolBB<Integer> arbol, int[] array) {

        if (getHijoIzq() != null) {
            getHijoIzq().inordenQueDevuelveArbolPorNombre(arbol, array);
        }
        Producto prod = (Producto) this.getDatos();
        //Hay productos que tienen el mismo nombre pero distinto código
        if (arbol.buscar(prod.getNombre()) != null) {
            TElementoAB<Integer> elem = new TElementoAB<Integer>(prod.getNombre() + array[0], prod.getStock());
            arbol.insertar(elem);
            array[0] += 1;
        } else {
            TElementoAB<Integer> elem = new TElementoAB<Integer>(prod.getNombre(), prod.getStock());
            arbol.insertar(elem);
        }

        if (getHijoDer() != null) {
            getHijoDer().inordenQueDevuelveArbolPorNombre(arbol, array);
        }
    }

    public void inordenQueImprime(String[] array, int[] contador) {

        if (getHijoIzq() != null) {
            getHijoIzq().inordenQueImprime(array, contador);
        }

        Integer stock = (Integer) this.getDatos();
        array[contador[0]] = this.getEtiqueta() + " stock: " + stock.toString();
        contador[0] = contador[0] + 1;

        if (getHijoDer() != null) {
            getHijoDer().inordenQueImprime(array, contador);
        }

    }

    @Override
    public void inorden(Lista<T> unaLista) {

        if (getHijoIzq() != null) {
            getHijoIzq().inorden(unaLista);
        }
        Nodo aux = new Nodo(this.getEtiqueta(), this.getDatos());
        unaLista.insertar(aux);

        if (getHijoDer() != null) {
            getHijoDer().inorden(unaLista);
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    public void setDatos(T dato) {
        this.datos = dato;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerTamanio() {
        int tamaño = 1;
        if (hijoDer != null) {
            tamaño += hijoDer.obtenerTamanio();
        }
        if (hijoIzq != null) {
            tamaño += hijoIzq.obtenerTamanio();
        }
        return tamaño;
    }

    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }

        return this.quitaElNodo();

    }

    public TElementoAB<T> quitaElNodo() {

        if (this.hijoIzq == null) {
            return this.hijoDer;
        }

        if (this.hijoDer == null) {
            return this.hijoIzq;
        }

        TElementoAB<T> elHijo = this.hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }

        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }

        elHijo.hijoDer = hijoDer;
        return elHijo;

    }

}
