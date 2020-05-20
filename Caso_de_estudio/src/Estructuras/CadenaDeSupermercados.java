package Estructuras;

import Exceptions.SucursalNotFound;

public class CadenaDeSupermercados {

    private final Lista<Sucursal> listaSucursales;

    public CadenaDeSupermercados() {
        listaSucursales = new Lista<>();
    }

    public Lista<Sucursal> getListaSucursales() {
        return listaSucursales;
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

    public void incorporarProductoEnSucursal(Producto prod, String suc) {

        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());

        try {
            aux.getDato().insertarProducto(prod);
        } catch (NullPointerException e) {
            System.out.println("La sucursal no fue encontrada, el producto no fue agregado");

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
            System.out.println("Producto vendido con éxito");
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
                          elem2.setDatos(elem2.getDatos()+ ";" + sucActual.getNombre());

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

    public void indicarExistenciasTotales(Comparable Etiqueta) {
        int result = 0;
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        // Inserto en todas las sucursales de la listaSucursales
        while (actual != null) {
            Sucursal suc = actual.getDato();
            TElementoAB<Producto> aux = suc.getArbolProductos().buscar(Etiqueta);
            if (aux != null) {
                result = result + aux.getDatos().getStock();
                actual = actual.getSiguiente();
            } else {
                actual = actual.getSiguiente();
            }
        }
        Printer.imprimirExistenciasTotales(Etiqueta, result);

    }

    public void indicarExistenciasPorSucursal(Comparable Etiqueta) {
        Lista<Integer> result = new Lista();

        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        // Inserto en todas las sucursales de la listaSucursales
        while (actual != null) {
            Sucursal suc = actual.getDato();
            TElementoAB<Producto> aux = suc.getArbolProductos().buscar(Etiqueta);
            if (aux != null) {
                Nodo<Integer> nodo = new Nodo(suc.getNombre(), aux.getDatos().getStock());
                result.insertar(nodo);
                actual = actual.getSiguiente();
            } else {
                actual = actual.getSiguiente();
            }
        }

        Printer.imprimirExistenciasPorSucursal(Etiqueta, result);
    }

    public void productosSucursalOrdenadosPorNombre(String suc,String ruta) throws SucursalNotFound {
        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase()); //O(N)

        try {
            aux.getDato();
        } catch (NullPointerException e) {
            throw new SucursalNotFound();
        }
        try {
            TArbolBB<Integer> salida = aux.getDato().getArbolProductos().inordenQueDevuelveArbolPorNombre();
            salida.inordenQueImprime(suc, "src/ArchivosDePrueba/" + ruta + ".txt");
            System.out.println("\n");
        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }
     public void productosTotalesOrdenadosPorNombre(String nombre) {
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();
        //Instancio un arbol de salida
        TArbolBB<Integer> salida = new TArbolBB<>();
        //Recorro toda la lista de sucursales
        while (aux != null) {
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inorden();
            Nodo<Producto> actual = listaAux.getPrimero();
            //Recorro todos los productos de la sucursal en la que estoy parado
            while (actual != null) {
                Producto prod = actual.getDato();
                //Si el arbol de salida ya tiene el producto que quiero meterle, le quiero agregar
                TElementoAB<Integer> elem2 = salida.buscar(prod.getNombre());
                if (elem2 != null) {
                    elem2.setDatos(elem2.getDatos() + prod.getStock());
                } else {
                    TElementoAB<Integer> elem3 = new TElementoAB(prod.getNombre(), prod.getStock());
                    salida.insertar(elem3);
                }
                actual = actual.getSiguiente();
            }

            aux = aux.getSiguiente();
        }
        
        salida.inordenQueImprime("Stock total de la cadena de supermercados ordenado por nombre de producto:", "src/ArchivosDePrueba/" + nombre + ".txt");

    }

}
