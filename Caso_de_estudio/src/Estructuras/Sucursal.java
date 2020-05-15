package Estructuras;

import Interfaces.ISucursal;
import Interfaces.IProducto;

public class Sucursal implements ISucursal {

    private String nombre;
    private String telefono;
    private String direccion;
    private String barrio;
    private String ciudad;
    private TArbolBB<Producto> arbolProductos;

    // En el constructor del almacen instanciamos 3 listas vacías para luego poner
    // los productos correspondientes
    public Sucursal(String direccion, String telefono, String nombre, String barrio, String ciudad) {
        this.arbolProductos = new TArbolBB<>();
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public TArbolBB<Producto> getArbolProductos() {
        return this.arbolProductos;
    }

    // Método que obtiene el mónto total de productos del almacen, actúa sobre el
    // arbol de productos
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

    /////////////////// LISTO INSERTAR////////////////////////
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
        Lista<Producto> listaAux = getArbolProductos().inorden();
        Nodo<Producto> nodo = listaAux.buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDato();
            aux.setStock(aux.getStock() + cantidad);
            return true;
        } else {
            return false;
        }
    }

    // Resta stock a un producto del almacen
    public Integer restarStock(Comparable etiqueta, Integer cantidad) {
        Lista<Producto> listaAux = getArbolProductos().inorden();
        Nodo<Producto> nodo = listaAux.buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDato();
            if (aux.getStock() >= cantidad) {
                aux.setStock(aux.getStock() - cantidad);
                return aux.getStock();
            } // Si se pretende vender más unidades de un cierto producto de las que hay en el
            // almacen se venden todas las que
            // hay y se setea el stock de ese producto en 0
            else {
                aux.setStock(0);
                return aux.getStock();
            }
        } else {
            return -1;
        }
    }

    // Método que busca un producto por su código
    ///////////////////////// Buscar listo///////////////////////7
    public Producto buscarPorCodigo(Comparable etiqueta) {
        TElementoAB<Producto> nodo = getArbolProductos().buscar(etiqueta);
        if (nodo != null) {
            Producto aux = nodo.getDatos();
            return aux;
        } else {
            return null;
        }
    }

    public int cantidadProductos() {
        return this.getArbolProductos().obtenerTamanio();
    }

    public boolean eliminarProducto(Comparable clave) {
        this.getArbolProductos().eliminar(clave); // El metodo eliminar es de tipo Void
        return true;
    }

    public Producto buscarPorDescripcionDeProducto(String nombre) {
        Lista<Producto> listaAux = getArbolProductos().inorden();
        if (listaAux.esVacia()) {
            return null;
        } else {
            Nodo<Producto> aux = listaAux.getPrimero();
            while (aux != null) {
                Producto prod = aux.getDato();
                String prod1 = prod.getNombre().replace(" ", "");
                String prod2 = nombre.replace(" ", "").toLowerCase();
                if (prod1.replace(" ", "").equals(prod2)) {
                    return prod;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;

    }

    public String imprimir(Nodo<Producto> nodoPrimerNodo) {
        String aux = "";
        Lista<Producto> listaAux = getArbolProductos().inorden();
        if (!listaAux.esVacia()) {
            Nodo<Producto> temp = nodoPrimerNodo;
            while (temp != null) {
                System.out.println(temp.getDato().getNombre());
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

}