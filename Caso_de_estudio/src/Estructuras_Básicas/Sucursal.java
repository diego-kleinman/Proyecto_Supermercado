package Estructuras_Básicas;

import Interfaces.ISucursal;

public class Sucursal implements ISucursal {

    private final String nombre;
    private final String telefono;
    private final String direccion;
    private final String barrio;
    private final String ciudad;
    private final TArbolBB<Producto> arbolProductos;

    /**
     * Constructor de la clase sucursal
     *
     * @param direccion Direccion
     * @param telefono Teléfono
     * @param nombre Nombre
     * @param barrio Barrio
     * @param ciudad Ciudad
     */
    public Sucursal(String direccion, String telefono, String nombre, String barrio, String ciudad) {
        this.arbolProductos = new TArbolBB<>();
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getBarrio() {
        return barrio;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public TArbolBB<Producto> getArbolProductos() {
        return this.arbolProductos;
    }

    /**
     * Método encargado de insertar un producto en el arbol de productos de la
     * sucursal
     *
     * @param unProducto Producto a insertar en la sucursal
     */
    @Override
    public void insertarProducto(Producto unProducto) {

        // Instancio un producto auxiliar a partir de la etiqueta (código) del
        // producto recibido como parámetro
        // En caso de no existir quedará null.
        Producto prodAux = buscarPorCodigo(unProducto.getEtiqueta());

        // Si no encuentro el producto en la lista, lo incorporo a la sucursal
        if (prodAux == null) {
            TElementoAB<Producto> aux = new TElementoAB<>(unProducto.getEtiqueta(), unProducto);
            this.arbolProductos.insertar(aux);
        }

    }

    /**
     * Método encargado de agregar stock de un cierto producto
     *
     * @param etiqueta Codigo de producto al cual agregar stock
     * @param cantidad Stock a agregar
     * @return
     */
    @Override
    public Boolean agregarStock(Comparable etiqueta, Integer cantidad) {

        //Busco el producto
        TElementoAB<Producto> elem = getArbolProductos().buscar(etiqueta);

        //Si no lo encuentro no hago nada, si lo encuentro asigno su stock al que tenía antes + el que le quiero agregar
        if (elem == null) {
            return false;
        } else {
            Producto aux = elem.getDatos();
            aux.setStock(aux.getStock() + cantidad);
            return true;

        }

    }

    /**
     * Método encargado de vender un producto
     *
     * @param etiqueta Código del producto a vender
     * @param cantidad Cantidad a vender
     */
    @Override
    public void vender(Comparable etiqueta, Integer cantidad) {

        TElementoAB<Producto> aux = getArbolProductos().buscar(etiqueta);
        Producto prod = aux.getDatos();
        prod.setStock(prod.getStock() - cantidad);

    }

    /**
     * Método encargado de discernir si se puede realizar una venta
     *
     * @param etiqueta Codigo del producto sobre el cual discernir
     * @param cantidad Cantidad a vender
     * @return
     */
    @Override
    public boolean sePuedeVender(Comparable etiqueta, Integer cantidad) {
        TElementoAB<Producto> nodo = getArbolProductos().buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDatos();
            if (aux.getStock() >= cantidad) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Método encargado de buscar un producto en el arbol de productos de la
     * sucursal
     *
     * @param etiqueta Codigo de producto a buscar
     * @return
     */
    @Override
    public Producto buscarPorCodigo(Comparable etiqueta) {
        TElementoAB<Producto> nodo = getArbolProductos().buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDatos();
            return aux;
        } else {
            return null;
        }
    }

    /**
     * Método encargado de eliminar un producto de la sucursal
     *
     * @param clave Codigo de producto a eliminar
     * @return
     */
    @Override
    public boolean eliminarProducto(Comparable clave) {
        this.getArbolProductos().eliminar(clave);
        return true;
    }

}
