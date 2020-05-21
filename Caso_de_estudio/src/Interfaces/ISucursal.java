package Interfaces;

import Estructuras.Producto;
import Estructuras.TArbolBB;

public interface ISucursal {

    /**
     * Retorna la direccion de la sucursal
     *
     * @return
     */
    public String getDireccion();

    /**
     * Retorna el teléfono de la sucursal
     *
     * @return
     */
    public String getTelefono();

    /**
     * Retorna el nombre de la sucursal
     *
     * @return
     */
    public String getNombre();

    /**
     * Retorna el barrio de la sucursal
     *
     * @return
     */
    public String getBarrio();

    /**
     * Retorna la ciudad de la sucursal
     *
     * @return
     */
    public String getCiudad();

    /**
     * Retorna el arbol de productos de la sucursal
     *
     * @return
     */
    public TArbolBB<Producto> getArbolProductos();

    /**
     * Inserta un producto en el arbol de productos de la sucursal la sucursal
     *
     * @param unProducto
     */
    public void insertarProducto(Producto unProducto);

    /**
     * Agrega stock a un producto de la sucursal
     *
     * @param etiqueta
     * @param cantidad
     * @return True o False dependiendo si se agregó o no el stock
     */
    public Boolean agregarStock(Comparable etiqueta, Integer cantidad);

    /**
     * Vende un producto en la sucursal
     *
     * @param etiqueta
     * @param cantidad
     */
    public void vender(Comparable etiqueta, Integer cantidad);

    /**
     * Método que dice si un producto se puede vender en la sucursal (si tiene
     * el stock suficiente)
     *
     * @param etiqueta
     * @param cantidad
     * @return True o False dependiendo si se puede vender o no
     */
    public boolean sePuedeVender(Comparable etiqueta, Integer cantidad);

    /**
     * Método que busca un producto en el arbol de productos de la sucursal
     *
     * @param etiqueta
     * @return Devuelve el producto si lo encuentra y sino devuelve null
     */
    public Producto buscarPorCodigo(Comparable etiqueta);

    /**
     * Método que elimina un producto de la sucursal
     *
     * @param clave
     * @return True o False dependiendo si se eliminó o no el producto.
     */
    public boolean eliminarProducto(Comparable clave);
}
