package plantilla;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
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
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    /**
    * Imprime en PreOrden los elementos del árbol, separados por guiones.
    * Esta clase llama al metodo preOrden de la clase TElementoAB
    * @return String conteniendo el preorden separado por guiones.
    */
   @Override
   public String preOrden() {
      if (raiz == null) {
         return null;
      } else {
         return raiz.preOrden();
      }
   }

   /**
    * Imprime en InOrden los elementos del árbol, separados por guiones.
    * Esta clase llama al metodo inOrden de la clase TElementoAB
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

   /**
    * Imprime en PostOrden los elementos del árbol, separados por guiones.
    * Esta clase llama al metodo postOrden de la clase TElementoAB
    * @return String conteniendo el preorden separado por guiones.
    */
   @Override
   public String postOrden() {
      if (raiz == null) {
         return null;
      } else {
         return raiz.postOrden();
      }
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
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    @Override
    public int obtenerAltura() {
        if (this.raiz == null) {
            return -1;
        }
        return raiz.obtenerAltura() -1;
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
        if (raiz==null) {
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

}
