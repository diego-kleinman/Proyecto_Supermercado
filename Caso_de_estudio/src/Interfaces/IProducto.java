package Interfaces;

public interface IProducto {

    /**
     * Retorna la etiqueta del Producto.
     *
     * @return codigo del Producto.
     */
    public Comparable getEtiqueta();

    /**
     * Retorna el precio unitario del Producto.
     *
     * @return precio del Producto.
     */
    public Double getPrecio();

    /**
     * Asigna el precio del producto
     *
     * @param precio
     */
    public void setPrecio(Double precio);

    /**
     * Retorna el stock del Producto.
     *
     * @return stock del Producto.
     */
    public Integer getStock();

    /**
     * Asigna el stock del producto
     *
     * @param stock
     */
    public void setStock(Integer stock);

    /**
     * Retorna el nombre del Producto.
     *
     * @return descripci�n del Producto.
     */
    public String getNombre();

    /**
     * Asigna el nombre del producto
     *
     * @param nombre
     */
    public void setNombre(String nombre);

}
