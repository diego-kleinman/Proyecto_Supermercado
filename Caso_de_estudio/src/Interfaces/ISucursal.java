
package Interfaces;

import Estructuras.Producto;
import Estructuras.TArbolBB;


public interface ISucursal {
    
    public String getDireccion(); 

    public String getTelefono();

    public String getNombre();

    public String getBarrio();

    public String getCiudad();

    public TArbolBB<Producto> getArbolProductos();
    
    public int getMontoTotal();

    public void insertarProducto(Producto unProducto);

    public Boolean agregarStock(Comparable etiqueta, Integer cantidad);

    public void vender(Comparable etiqueta, Integer cantidad);

    public boolean sePuedeVender(Comparable etiqueta, Integer cantidad);

    public Producto buscarPorCodigo(Comparable etiqueta);

    public boolean eliminarProducto(Comparable clave);
}
