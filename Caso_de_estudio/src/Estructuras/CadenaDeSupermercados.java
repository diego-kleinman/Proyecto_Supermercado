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
            if (suc.getArbolProductos().buscar(prod.getEtiqueta()) == null) {
                //Producto insert = new Producto(prod.getEtiqueta(),prod.getNombre(),prod.getPrecio());
                suc.insertarProducto(prod.clonar());
                actual = actual.getSiguiente();
            } else {
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
            if (suc.getArbolProductos().buscar(Etiqueta) != null) {
                suc.eliminarProducto(Etiqueta);
                actual = actual.getSiguiente();
            } else {
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

    public void VenderProductoEnSucursal(Comparable codigo, Integer cantidad, String suc) throws SucursalNotFound {

        TArbolBB<String> output = new TArbolBB();
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
        } else {
            //Si no se puede vender recorro la lista de sucursales y genero el output
            System.out.println("La venta del producto con codigo: " + codigo + " no pudo realizarse en la sucursal " + suc);
            System.out.println("Aqui tiene una lista de las sucursales con stock disponible: ");
            Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
            while (actual != null) {
                Sucursal sucActual = actual.getDato();
                //Si en la sucursal actual se puede vender, la función "sePuedeVender" incluye el chequeo de que el producto exista en
                //el arbol de productos de la sucursal
                if (sucActual.sePuedeVender(codigo, cantidad)) {
                    TElementoAB<Producto> elem = sucActual.getArbolProductos().buscar(codigo);

                    //Quiero buscar un elemento que tenga como etiqueta el stock de la sucursal en la cual estoy parado
                    TElementoAB<String> elem2 = output.buscar(elem.getDatos().getStock());

                    //Si en el arbol de salida ya hay algun TElementoAB que tenga el mismo stock del producto que tiene la sucursal que estoy parado
                    //agrego el nombre de la sucursal que estoy parado al TElementoAB del arbol que tiene el stock previamente mencionado
                    if (elem2 != null) {
                        Comparable etiqueta = elem2.getEtiqueta();
                        String datos = elem2.getDatos() + ";" + sucActual.getNombre();
                        output.eliminar(elem.getDatos().getStock());
                        TElementoAB temp = new TElementoAB(etiqueta,datos);
                        output.insertar(temp);

                    } else {
                        TElementoAB nuevoElem = new TElementoAB(elem.getDatos().getStock(), sucActual.getNombre());
                        output.insertar(nuevoElem);
                    }
                }
                actual = actual.getSiguiente();
            }
            Printer.imprimirListaSucursalesConStock(output);

        }

    }

    public void agregarStock(Comparable codigo, Integer cantidad, String suc) throws SucursalNotFound {
        if (cantidad > 0) {
            Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());
            try {
                aux.getDato().agregarStock(codigo, cantidad);
            } catch (NullPointerException e) {
                throw new SucursalNotFound();
            }
        }
    }
}
