package Estructuras;

import Interfaces.ISucursal;
import Interfaces.IProducto;

public class Sucursal implements ISucursal {

    private final String nombre;
    private final String telefono;
    private final String direccion;
    private final String barrio;
    private final String ciudad;
    private final TArbolBB<Producto> arbolProductos;

    public Sucursal(String direccion, String telefono, String nombre, String barrio, String ciudad) {
        this.arbolProductos = new TArbolBB<>();
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public TArbolBB<Producto> getArbolProductos() {
        return this.arbolProductos;
    }

    public int getMontoTotal() {
        Nodo<Producto> aux = getArbolProductos().inorden().getPrimero();
        int contadorMonto = 0;
        while (aux != null) {
            Producto prod = aux.getDato();
            contadorMonto += prod.getPrecio() * prod.getStock();
            aux = aux.getSiguiente();
        }
        return contadorMonto;
    }

    public void insertarProducto(Producto unProducto) {

        // Instanciamos un producto auxiliar a partir de la etiqueta (código) del
        // producto recibido como parámetro
        // En caso de no existir quedará null.
        IProducto prodAux = buscarPorCodigo(unProducto.getEtiqueta());

        // Si no encontramos el producto en la lista, lo incorporamos a la sucursal
        if (prodAux == null) {
            TElementoAB<Producto> aux = new TElementoAB<>(unProducto.getEtiqueta(), unProducto);
            this.arbolProductos.insertar(aux);
        }

    }

    // Agrega stock a un producto ya existente en el almacen
    public Boolean agregarStock(Comparable etiqueta, Integer cantidad) {
        TElementoAB<Producto> elem = getArbolProductos().buscar(etiqueta);

        if (cantidad < 0 || elem == null) {
            return false;
        } else {
            Producto aux = elem.getDatos();
            aux.setStock(aux.getStock() + cantidad);
            return true;

        }

    }
    // Resta stock a un producto del almacen

    public void vender(Comparable etiqueta, Integer cantidad) {

        TElementoAB<Producto> aux = getArbolProductos().buscar(etiqueta);
        Producto prod = aux.getDatos();
        prod.setStock(prod.getStock() - cantidad);

    }

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

    public Producto buscarPorCodigo(Comparable etiqueta) {
        TElementoAB<Producto> nodo = getArbolProductos().buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDatos();
            return aux;
        } else {
            return null;
        }
    }

    public boolean eliminarProducto(Comparable clave) {
        this.getArbolProductos().eliminar(clave);
        return true;
    }

}
