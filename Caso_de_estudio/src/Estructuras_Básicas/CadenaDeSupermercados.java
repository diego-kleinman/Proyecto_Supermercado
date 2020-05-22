package Estructuras_Básicas;

import Estructuras_Auxiliares.GeneradorArray;
import Estructuras_Auxiliares.ManejadorArchivosGenerico;
import Estructuras_Auxiliares.SucursalNotFound;

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
     * Método que delega a una cierta sucursal a incorporar un producto
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
     * Método que delega a una cierta sucursal a eliminar productos
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

    /**
     * Método que delega a una cierta sucursal a hacer ventas
     *
     * @param codigo Codigo de producto a vender
     * @param cantidad Cantidad a vender
     * @param suc Nombre de sucursal en la cual realizar la venta
     * @throws SucursalNotFound
     */
    public void VenderProductoEnSucursal(Comparable codigo, Integer cantidad, String suc) throws SucursalNotFound {
        /*Instancio un arbol de salida, este arbol tendrá como etiqueta a los stocks de producto en cada sucursal
        y como dato al nombre de la sucursal/es en la cual hay ese stock*/
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

            //Tomo la primera sucursal de la lista de sucursales
            Nodo<Sucursal> actual = this.listaSucursales.getPrimero();

            //Recorro la lista de sucursales
            while (actual != null) {
                Sucursal sucActual = actual.getDato();

                //Si en la sucursal actual se puede vender
                if (sucActual.sePuedeVender(codigo, cantidad)) {
                    TElementoAB<Producto> elem = sucActual.getArbolProductos().buscar(codigo);

                    //Quiero buscar un elemento que tenga como etiqueta el stock existente de producto de la sucursal en la cual estoy parado actualmente
                    TElementoAB<String> elem2 = output.buscar(elem.getDatos().getStock());

                    /*Si en el arbol salida ya hay algun TElementoAB que tenga el mismo stock del producto que tiene la sucursal en la que estoy parado
                    agrego el nombre de la sucursal en la que estoy parado al dato del TElementoAB del arbol
                    Ejemplo, en el arbol hay un TElementoAB con etiqueta 60 y dato "sucursal 1" (esto quiere decir que en la sucursal 1 tengo 60
                    productos de stock), ahora recorro la "sucursal 2" y también tengo 60 de stock de ese producto en esa sucursal, en ese caso
                    al TElementoAB del arbol con etiqueta=60 le agrego en su dato "; sucursal 2", aludiendo a que tanto en la "sucursal 1"
                    como en la "sucursal 2" hay 60 de stock de ese producto*/
                    if (elem2 != null) {
                        elem2.setDatos(elem2.getDatos() + ";" + sucActual.getNombre());
                    } //En caso contrario creo el TElementoAB y lo inserto en el arbol salida
                    else {
                        TElementoAB nuevoElem = new TElementoAB(elem.getDatos().getStock(), sucActual.getNombre());
                        output.insertar(nuevoElem);
                    }
                }
                actual = actual.getSiguiente();
            }
            //Llamo al printer para que despliegue la información en pantalla
            Printer.imprimirListaSucursales(output);

        }

    }

    /**
     * Método que delega a una cierta sucursal a agregar stock de un producto
     *
     * @param codigo Codigo de producto al cual agregar stock
     * @param cantidad Cantidad de stock a agregar
     * @param suc Nombre de sucursal en la cual agregar el stock
     * @throws SucursalNotFound
     */
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

    /**
     * Método encargado de indicar las existencias totales de un producto en la
     * cadena de supermercados
     *
     * @param Etiqueta Codigo de producto sobre el cual indicar existencias
     */
    public void indicarExistenciasTotales(Comparable Etiqueta) {
        //Inicializo la variable resultado
        int result = 0;
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        //Recorro todas las sucursales buscando el producto, si lo encuentro agrego su stock al resultado
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
        //Llamo al printer para que despliegue la información en pantalla
        Printer.imprimirExistenciasTotales(Etiqueta, result);

    }

    /**
     * Método encargado de indicar las existencias de un producto por sucursal
     *
     * @param Etiqueta Codigo del producto sobre el cual indicar existencias
     */
    public void indicarExistenciasPorSucursal(Comparable Etiqueta) {
        //Inicializo una lista resultado que va a tener como etiqueta nombres de sucursal y como dato stocks de producto
        Lista<Integer> result = new Lista();

        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        //Recorro todas las sucursales de la listaSucursales y genero la lista de salida
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
        } //Llamo al printer para que despliegue la información en pantalla
        else {
            Printer.imprimirExistenciasPorSucursal(Etiqueta, result);
        }

    }

    /**
     * Método encargado de emitir un archivo txt con los productos de una
     * sucursal ordenados por nombre y con su stock en esa sucursal
     *
     * @param suc Nombre de sucursal sobre la cual trabajar
     * @param nombre Nombre del archivo salida
     * @throws SucursalNotFound
     */
    public void productosSucursalOrdenadosPorNombre(String suc, String nombre) throws SucursalNotFound {
        Nodo<Sucursal> aux = this.listaSucursales.buscar(suc.toUpperCase()); //O(N)

        try {
            aux.getDato();
        } catch (NullPointerException e) {
            throw new SucursalNotFound();
        }
        try {
            //Utilizo el método de TArbolBB que me devuelve un arbol con productos ordenados por nombre
            TArbolBB<Integer> salida = aux.getDato().getArbolProductos().inordenQueDevuelveArbolPorNombre();
            //Uso el método que me pasa el arbol a array
            String[] array = salida.inordenQueDevuelveArray();
            //En el elemento de indice 0 del array pongo el nombre de la sucursal en cuestion
            array[0] = suc.toUpperCase();
            //Delego al manejador de archivos la escritura del archivo salida dado el array creado y el nombre introducido por parámetro
            ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", array);
            System.out.println("\n");
        } catch (NullPointerException ex) {
            System.out.println("La sucursal no tiene productos");
        }

    }

    /**
     * Método encargado de emitir un archivo txt con los productos totales de la
     * cadena y su stock en la misma
     *
     * @param nombre Nombre del archivo salida
     */
    public void productosTotalesOrdenadosPorNombre(String nombre) {
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();
        //Instancio un arbol salida
        TArbolBB<Integer> salida = new TArbolBB<>();
        //Recorro toda la lista de sucursales
        while (aux != null) {
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inOrden();
            Nodo<Producto> actual = listaAux.getPrimero();
            //Recorro todos los productos de la sucursal en la que estoy parado
            while (actual != null) {
                Producto prod = actual.getDato();
                TElementoAB<Integer> elem2 = salida.buscar(prod.getNombre());

                //Si el arbol salida ya tiene el producto que estoy recorriendo, le agrego stock
                if (elem2 != null) {
                    elem2.setDatos(elem2.getDatos() + prod.getStock());
                } //Si no lo tiene creo un nuevo TElementoAB y lo inserto en el arbol salida
                else {
                    TElementoAB<Integer> elem3 = new TElementoAB(prod.getNombre(), prod.getStock());
                    salida.insertar(elem3);
                }
                actual = actual.getSiguiente();
            }

            aux = aux.getSiguiente();
        }
        //Uso el método que me pasa el arbol a array
        String[] array = salida.inordenQueDevuelveArray();
        //En el elemento de indice 0 del array pongo el string que está en la siguiente linea
        array[0] = "Productos totales de la cadena de supermercados:";
        //Delego al manejador de archivos la escritura del archivo salida dado el array creado y el nombre introducido por parámetro
        ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", array);
    }

    /**
     * Método encargado de emitir un archivo txt con los productos de cada
     * ciudad y su stock en la misma
     *
     * @param nombre Nombre del archivo salida
     */
    public void productosTotalesOrdenadosPorCiudad(String nombre) {
        //Inicializo un contador de lineas que voy a necesitar para posteriormente generar el array para mandar al manejador de archivos
        int contadorLineas = 0;
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();

        /*Instancio una lista salida,que va a tener nodos con etiqueta = nombres 
        de ciudades y dato= arbol de productos ordenado por nombre de esa ciudad 
        y con su stock en la misma*/
        Lista<TArbolBB<Integer>> lista = new Lista<>();
        //Recorro toda la lista de sucursales
        while (aux != null) {
            Nodo<TArbolBB<Integer>> ciudadActual = lista.buscar(aux.getDato().getCiudad().toLowerCase());
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inOrden();
            /*Busco la ciudad en la que estoy parado en la lista de salida, 
            si la encuentro modifico los productos del arbol de esa ciudad*/
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

            } //Si la ciudad no está aún en la salida la genero y la inserto
            else {
                contadorLineas++; // Cuento nombre de ciudad

                TArbolBB<Integer> arbol = new TArbolBB<>();
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                //Recorro todos los productos de la sucursal actual
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

        //Delego al generador de arrays a generar el array para mandarlo al manejador de archivos
        String[] output = GeneradorArray.generarArray(lista, contadorLineas);
        //Delego al manejador de archivos la escritura del archivo salida dado el array creado y el nombre introducido por parámetro
        ManejadorArchivosGenerico.escribirArchivo("src/Archivos/" + nombre + ".txt", output);

    }

    /**
     * Método encargado de emitir un archivo txt con los productos de cada
     * barrio y su stock en el mismo
     *
     *
     * @param nombre Nombre del archivo salida
     */
    //Es un método análogo al de ciudad pero para barrios
    public void productosTotalesOrdenadosPorBarrio(String nombre) {
        int contadorLineas = 0;
        Nodo<Sucursal> aux = this.listaSucursales.getPrimero();
        Lista<TArbolBB<Integer>> lista = new Lista<>();
        while (aux != null) {
            Nodo<TArbolBB<Integer>> barrioActual = lista.buscar(aux.getDato().getBarrio().toLowerCase());
            Lista<Producto> listaAux = aux.getDato().getArbolProductos().inOrden();
            if (barrioActual != null) {
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem = barrioActual.getDato().buscar(prod.getNombre());
                    if (elem != null) {
                        elem.setDatos(elem.getDatos() + prod.getStock());
                    } else {
                        contadorLineas++;
                        TElementoAB<Integer> elem2 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                        barrioActual.getDato().insertar(elem2);
                    }
                    nodoActual = nodoActual.getSiguiente();
                }

            } else {
                contadorLineas++;

                TArbolBB<Integer> arbol = new TArbolBB<>();
                Nodo<Producto> nodoActual = listaAux.getPrimero();
                while (nodoActual != null) {
                    Producto prod = nodoActual.getDato();
                    TElementoAB<Integer> elem3 = new TElementoAB<>(prod.getNombre(), prod.getStock());
                    if (arbol.buscar(prod.getNombre()) == null) {
                        arbol.insertar(elem3);
                        contadorLineas++;
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
