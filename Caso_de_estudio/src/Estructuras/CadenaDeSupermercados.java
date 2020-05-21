package Estructuras;

import Exceptions.SucursalNotFound;

/**
 * Clase experta, se encarga de todas las operaciones necesarias del sistema
 * software, algunas las hace ella misma y otras las delega
 *
 * @author Diego
 */
public class CadenaDeSupermercados {

    private final Lista<Sucursal> listaSucursales;

    /**
     * Constructor de la clase CadenaDeSupermercados
     */
    public CadenaDeSupermercados() {
        listaSucursales = new Lista<>();
    }

    public Lista<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    /**
     * Método encargado de incorporar una sucursal a la cadena de supermercados,
     * llama al método insertar de la lista de sucursales
     *
     * @param suc Sucursal a incorporar
     */
    public void incorporarSucursal(Sucursal suc) {
        Nodo<Sucursal> nodoSuc = new Nodo<>(suc.getNombre(), suc);
        this.listaSucursales.insertar(nodoSuc);

    }

    /**
     * Método encargado de incorporar un producto a la cadena de supermercados
     * (a todas las sucursales), llama al método insertarProducto de todas las
     * sucursales
     *
     * @param prod Producto a incorporar
     */
    public void incorporarProductoEnCadena(Producto prod) {
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();

        //Recorro todas las sucursales insertando el producto si no está ya insertado
        while (actual != null) {

            Sucursal suc = actual.getDato();
            if (suc.getArbolProductos().buscar(prod.getEtiqueta()) == null) {
                suc.insertarProducto(prod.clonar());
                actual = actual.getSiguiente();
            } else {
                actual = actual.getSiguiente();
            }

        }
    }

    /**
     * Método encargado de incorporar un producto a una cierta sucursal, llama
     * al método insertar producto de una sucursal
     *
     * @param prod Producto a incorporar
     * @param suc Sucursal en la cual incorporarlo
     */
    public void incorporarProductoEnSucursal(Producto prod, String suc) {

        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase());

        try {
            aux.getDato().insertarProducto(prod);
        } catch (NullPointerException e) {
            System.out.println("La sucursal no fue encontrada, el producto no fue agregado");

        }

    }

    /**
     * Método encargado de eliminar un producto de la cadena de supermercados
     * (de todas las sucursales), llama al método eliminarProductos de cada
     * sucursal
     *
     * @param Etiqueta Codigo de producto a eliminar
     */
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

    /**
     * Método que llama al método eliminarProductos de una cierta sucursal
     *
     * @param codigo Codigo de producto a eliminar
     * @param suc Sucursal en la cual eliminarlo
     * @throws SucursalNotFound
     */
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
                        elem2.setDatos(elem2.getDatos() + ";" + sucActual.getNombre());

                    } else {
                        TElementoAB nuevoElem = new TElementoAB(elem.getDatos().getStock(), sucActual.getNombre());
                        output.insertar(nuevoElem);
                    }
                }
                actual = actual.getSiguiente();
            }
            Printer.imprimirListaSucursales(output);

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
        if (result.esVacia()) {
            System.out.println("El producto no se encuentra en ninguna sucursal de la cadena");
        } else {
            Printer.imprimirExistenciasPorSucursal(Etiqueta, result);
        }

    }

    public void productosSucursalOrdenadosPorNombre(String suc, String ruta) throws SucursalNotFound {
        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase()); //O(N)

        try {
            aux.getDato();
        } catch (NullPointerException e) {
            throw new SucursalNotFound();
        }
        try {
            TArbolBB<Integer> salida = aux.getDato().getArbolProductos().inordenQueDevuelveArbolPorNombre();
            String[] array = salida.inordenQueDevuelveArray();
            array[0] = suc.toUpperCase();
            ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + ruta + ".txt", array);
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
        String[] array = salida.inordenQueDevuelveArray();
        array[0] = "Stock total de la cadena de supermercados ordenado por nombre de producto:";
        ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", array);
    }

    public void productosTotalesOrdenadosPorCiudad(String nombre) {
        int contadorLineas = 0;
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();
        //Instancio un arbol de salida, va a tener códigos de producto como etiqueta y stock como dato
        Lista<TArbolBB<Integer>> lista = new Lista<>();
        //Recorro toda la lista de sucursales
        while (aux != null) {
            Nodo<TArbolBB<Integer>> ciudadActual = lista.buscar(aux.getDato().getCiudad().toLowerCase());
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inorden();
            //Busco la ciudad en la lista de salida, si la encuentro modifico los productos del arbol de esa ciudad
            if (ciudadActual != null) {
                // Recorro todos los productos de la sucursal en la que estoy parado
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem = ciudadActual.getDato().buscar(prod.getNombre());
                    // Si el producto ya esta en el arbol de la ciudad en la lista de salida aumento
                    // su stock
                    if (elem != null) {
                        elem.setDatos(elem.getDatos() + prod.getStock());
                    } // Si no está aún en el arbol lo agrego
                    else {
                        contadorLineas++; // un producto más
                        TElementoAB<Integer> elem2 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                        ciudadActual.getDato().insertar(elem2);
                    }
                    nodoActual = nodoActual.getSiguiente();
                }

            } //Si la ciudad no está aún en la salida
            else {
                contadorLineas++; // Cuento nombre de ciudad

                TArbolBB<Integer> arbol = new TArbolBB<>();
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem3 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                    if (arbol.buscar(prod.getNombre()) == null) {
                        arbol.insertar(elem3);
                        contadorLineas++; // Cuento cantidad de productos
                    }

                    nodoActual = nodoActual.getSiguiente();
                }
                Nodo<TArbolBB<Integer>> ciudadNueva = new Nodo<>(aux.getDato().getCiudad(), arbol);
                lista.insertar(ciudadNueva);

            }
            aux = aux.getSiguiente();
        }

        String[] output = GeneradorArray.generarArray(lista, contadorLineas);
        ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", output);

    }

    public void productosTotalesOrdenadosPorBarrio(String nombre) {
        int contadorLineas = 0;
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();
        //Instancio un arbol de salida, va a tener códigos de producto como etiqueta y stock como dato
        Lista<TArbolBB<Integer>> lista = new Lista<>();
        //Recorro toda la lista de sucursales
        while (aux != null) {
            Nodo<TArbolBB<Integer>> barrioActual = lista.buscar(aux.getDato().getBarrio().toLowerCase());
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inorden();
            //Busco la ciudad en la lista de salida, si la encuentro modifico los productos del arbol de esa ciudad
            if (barrioActual != null) {
                // Recorro todos los productos de la sucursal en la que estoy parado
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem = barrioActual.getDato().buscar(prod.getNombre());
                    // Si el producto ya esta en el arbol de la ciudad en la lista de salida aumento
                    // su stock
                    if (elem != null) {
                        elem.setDatos(elem.getDatos() + prod.getStock());
                    } // Si no está aún en el arbol lo agrego
                    else {
                        contadorLineas++; // un producto más
                        TElementoAB<Integer> elem2 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                        barrioActual.getDato().insertar(elem2);
                    }
                    nodoActual = nodoActual.getSiguiente();
                }

            } //Si la ciudad no está aún en la salida
            else {
                contadorLineas++; // Cuento nombre de ciudad

                TArbolBB<Integer> arbol = new TArbolBB<>();
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem3 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                    if (arbol.buscar(prod.getNombre()) == null) {
                        arbol.insertar(elem3);
                        contadorLineas++; // Cuento cantidad de productos
                    }

                    nodoActual = nodoActual.getSiguiente();
                }
                Nodo<TArbolBB<Integer>> barrioNuevo = new Nodo<>(aux.getDato().getBarrio(), arbol);
                lista.insertar(barrioNuevo);

            }
            aux = aux.getSiguiente();
        }

        String[] output = GeneradorArray.generarArray(lista, contadorLineas);
        ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", output);

    }
}
