package plantilla;

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
        Nodo<Sucursal> nodoSuc = new Nodo<>(suc.getNombre(),suc);
        this.listaSucursales.insertar(nodoSuc);

    }

    public void incorporarProductoEnCadena(Producto prod) throws Exception {
        Nodo<Sucursal> actual = this.listaSucursales.getPrimero();
        // Inserto en todas las sucursales de la listaSucursales
        while (actual != null) {
            Sucursal suc = actual.getDato();
            try {
                suc.insertarProducto(prod);
            } catch (Exception e) {
                throw new Exception("El producto no pudo ingresarse en el arbol de la sucursal: " + suc.getNombre());
            }
            actual = actual.getSiguiente();


        }
    }


}
