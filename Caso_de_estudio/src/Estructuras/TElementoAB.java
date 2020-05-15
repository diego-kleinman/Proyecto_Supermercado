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

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

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

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {

        String temp = "";

        if (getHijoIzq() != null) {
            temp += getHijoIzq().inOrden() + ",";
        }

        temp += this.getEtiqueta();

        if (getHijoDer() != null) {
            temp += "," + getHijoDer().inOrden();
        }
        return temp;
    }

    @Override
    public String preOrden() {

        String temp = "";

        temp += this.getEtiqueta();

        if (getHijoIzq() != null) {
            temp += "," + getHijoIzq().preOrden();
        }

        if (getHijoDer() != null) {
            temp += "," + getHijoDer().preOrden();
        }
        return temp;
    }

    @Override
    public String postOrden() {

        String temp = "";

        if (getHijoIzq() != null) {
            temp += getHijoIzq().postOrden() + ",";
        }

        if (getHijoDer() != null) {
            temp += getHijoDer().postOrden() + ",";
        }

        temp += this.getEtiqueta();

        return temp;
    }
    @Override
    public void inOrden(Lista<T> unaLista) {

        if (getHijoIzq() != null) {
            getHijoIzq().inOrden(unaLista);
        }

        Nodo aux = new Nodo(this.getEtiqueta(), null);
        unaLista.insertar(aux);

        if (getHijoDer() != null) {
            getHijoDer().inOrden(unaLista);
        }

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    public boolean esHoja() {
        if (this.getHijoDer() == null && this.getHijoIzq() == null) {
            return true;
        }
        return false;
    }

    public int getMaximo(int a, int b) {
        return (a > b) ? a : b;
    }

    @Override
    public int obtenerAltura() {
        int a = 1;
        int b = 1;
        if (hijoIzq != null) {
            a += hijoIzq.obtenerAltura();
        }

        if (hijoDer != null) {
            b += hijoDer.obtenerAltura();
        }
        return Integer.max(a, b);
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

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = 0;

        if (Integer.parseInt(unaEtiqueta.toString()) == Integer.parseInt(this.getEtiqueta().toString())) {
            return nivel;
        } else {
            if (Integer.parseInt(unaEtiqueta.toString()) < Integer.parseInt(this.getEtiqueta().toString())) {
                if (this.getHijoIzq() != null) {
                    nivel = 1 + this.getHijoIzq().obtenerNivel(unaEtiqueta);
                }
            } else {
                if (this.getHijoDer() != null) {
                    nivel = 1 + this.getHijoDer().obtenerNivel(unaEtiqueta);
                }
            }
        }
        // En caso de que llegue a una hoja y no encuentre la etiqueta, retorna -1 y
        // empieza a restar en la recursión
        // Si encuentra la etiqueta retorna el nivel actual y se va sumando en la
        // recusión hasta retornar el nivel final.
        return (nivel == 0 ? -1 : nivel);
    }

    @Override
    public int obtenerCantidadHojas() {
        int[] hojas = new int[1];

        if (this.esHoja()) {
            return hojas[0] += 1;
        }

        if (this.getHijoIzq() != null) {
            hojas[0] += this.getHijoIzq().obtenerCantidadHojas();
        }

        if (this.getHijoDer() != null) {
            hojas[0] += this.getHijoDer().obtenerCantidadHojas();
        }

        return hojas[0];

    }
    
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
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
            elHijo.hijoIzq= hijoIzq;
        }
        
        elHijo.hijoDer = hijoDer;
        return elHijo;
        
        
    }

}
