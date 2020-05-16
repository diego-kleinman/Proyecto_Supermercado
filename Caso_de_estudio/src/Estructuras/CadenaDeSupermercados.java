package Estructuras;

import Exceptions.SucursalNotFound;
import org.apache.commons.lang3.StringUtils;

public class CadenaDeSupermercados {

    private Lista<Sucursal> listaSucursales;
    private Lista<Lista<Producto>> listaCiudades;
    private Lista<Lista<Producto>> listaBarrios;

    public CadenaDeSupermercados() {
        listaSucursales = new Lista<>();
        listaCiudades = new Lista<>();
        listaBarrios = new Lista<>();
    }

    public Lista<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public Lista<Lista<Producto>> getListaCiudades() {
        return listaCiudades;
    }

    public Lista<Lista<Producto>> getListaBarrios() {
        return listaBarrios;
    }

    public void incorporarSucursal(Sucursal suc) {
        Nodo<Sucursal> nodoSuc = new Nodo<>(suc.getNombre(), suc);
        this.listaSucursales.insertar(nodoSuc);

    }

    public void incorporarProductoEnCadena(Producto prod) {
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        // Inserto en todas las sucursales de la listaSucursales
        while (actual != null) {
            Sucursal suc = actual.getDato();
            if(suc.getArbolProductos().buscar(prod.getEtiqueta()) == null){
                suc.insertarProducto(prod);
                actual = actual.getSiguiente();
            }
            else {
                actual = actual.getSiguiente();
            }
            
        }
    }

    public void incorporarProductoEnSucursal(Producto prod, String suc) throws SucursalNotFound {

        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());

        try {
            aux.getDato().insertarProducto(prod);
        } catch (NullPointerException e) {
            throw new SucursalNotFound();

        }

    }

    public void eliminarProductoEnCadena(Comparable Etiqueta) {
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        // Inserto en todas las sucursales de la listaSucursales
        while (actual != null) {
            Sucursal suc = actual.getDato();
            if(suc.getArbolProductos().buscar(Etiqueta) != null){
                suc.eliminarProducto(Etiqueta);
                actual = actual.getSiguiente();
            }
            else {
                actual = actual.getSiguiente();
            }
            
        }
    }

    public void eliminarProductoEnSucursal(Comparable codigo, String suc) throws SucursalNotFound {

        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());

        try {
            aux.getDato().eliminarProducto(codigo);
        } catch (NullPointerException e) {
            throw new SucursalNotFound();

        }

    }

    public Lista<Integer> VenderProductoEnSucursal(Comparable codigo, Integer cantidad, String suc) throws SucursalNotFound {
        Lista output = new Lista();
        //Busco la sucursal para hacer la venta, si no la encuentro devuelvo la excepcion
        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());
        try {
            aux.getDato();
        } catch (NullPointerException e) {
            throw new SucursalNotFound();
        }
        //Si la encuentro me fijo si se puede vender, si se puede, hago la venta
        if (aux.getDato().sePuedeVender(codigo, cantidad)) {
            aux.getDato().vender(codigo, cantidad);
            return null;
        } else {
            //Si no se puede vender recorro la lista de sucursales y genero el output
            Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
            while (actual != null) {
                Sucursal sucActual = actual.getDato();
                if (sucActual.sePuedeVender(codigo, cantidad)) {
                    TElementoAB<Producto> elem = sucActual.getArbolProductos().buscar(codigo);
                    Nodo nuevoNodo = new Nodo(sucActual.getNombre(),elem.getDatos().getStock());
                    output.insertar(nuevoNodo);
                }
            }
            return output;

        }

    }
    
    public void agregarStock(Comparable codigo,Integer cantidad,String suc) throws SucursalNotFound {
        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());

        try {
            aux.getDato().agregarStock(codigo,cantidad);
        } catch (NullPointerException e) {
            throw new SucursalNotFound();
        }
        
    
    
    }

}
