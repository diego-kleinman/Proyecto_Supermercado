package Interfaces;

import Estructuras_Básicas.Producto;
import Estructuras_Básicas.TArbolBB;

public interface ISucursal {

    /**
     * Retorna la direccion de la sucursal
     *
     * @return Direccion
     */
    public String getDireccion();

    /**
     * Retorna el teléfono de la sucursal
     *
     * @return Teléfono
     */
    public String getTelefono();

    /**
     * Retorna el nombre de la sucursal
     *
     * @return Nombre
     */
    public String getNombre();

    /**
     * Retorna el barrio de la sucursal
     *
     * @return Barrio
     */
    public String getBarrio();

    /**
     * Retorna la ciudad de la sucursal
     *
     * @return Ciudad
     */
    public String getCiudad();

    /**
     * Retorna el arbol de productos de la sucursal
     *
     * @return TArbolBB
     */
    public TArbolBB<Producto> getArbolProductos();

    /**
     * Inserta un producto en el arbol de productos de la sucursal la sucursal
     *
     * @param unProducto Producto a insertar
     */
    public void insertarProducto(Producto unProducto);

    /**
     * Agrega stock a un producto de la sucursal
     *
     * @param etiqueta Etiqueta a la cual agregar stock
     * @param cantidad Cantidad a agregar
     * @return True o False dependiendo si se agregó o no el stock
     */
    public Boolean agregarStock(Comparable etiqueta, Integer cantidad);

    /**
     * Vende un producto en la sucursal
     *
     * @param etiqueta Etiqueta sobre la cual realizar la venta
     * @param cantidad Cantidad a vender
     */
    public void vender(Comparable etiqueta, Integer cantidad);

    /**
     * Método que dice si un producto se puede vender en la sucursal (si tiene
     * el stock suficiente)
     *
     * @param etiqueta Etiqueta sobre la cual verificar si se puede vender
     * @param cantidad Cantidad que se intenta vender
     * @return True o False dependiendo si se puede vender o no
     */
    public boolean sePuedeVender(Comparable etiqueta, Integer cantidad);

    /**
     * Método que busca un producto en el arbol de productos de la sucursal
     *
     * @param etiqueta Etiqueta sobre la cual realizar la búsqueda
     * @return Devuelve el producto si lo encuentra y sino devuelve null
     */
    public Producto buscarPorCodigo(Comparable etiqueta);

    /**
     * Método que elimina un producto de la sucursal
     *
     * @param clave Clave sobre la cual realizar la eliminacion
     * @return True o False dependiendo si se eliminó o no el producto.
     */
    public boolean eliminarProducto(Comparable clave);
}
