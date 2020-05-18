package Estructuras;

import org.apache.commons.lang3.StringUtils;
import Builders.*;

import Exceptions.SucursalNotFound;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        CadenaDeSupermercados geant = new CadenaDeSupermercados();
        Lista<Sucursal> listaSucs = geant.getListaSucursales();

        BuilderSucursales.build("src/ArchivosDePrueba/5Sucursales.txt", geant);

        //BuilderProductos.buildSucursal("src/ArchivosDePrueba/20Productos.txt", geant,"local 122");
        try {
            BuilderProductos.buildCadena("src/ArchivosDePrueba/20Productoss.txt", geant);
        } catch (Exception ex) {
        }

        //BuilderStock.build("src/ArchivosDePrueba/stockPrueba.txt", geant);
        //BuilderVentas.build("src/ArchivosDePrueba/ventasPrueba.txt", geant);
        //BuilderEliminar.eliminar("src/ArchivosDePrueba/elimPrueba.txt", geant);
        //BuilderEliminar.eliminarEnSucursal("src/ArchivosDePrueba/elimPrueba.txt", geant, "local 122");

        //Lista<Sucursal> aux3 = geant.getListaSucursales();
        //Printer.imprimirPorCodigo(aux3);
//        Nodo<Sucursal> nodoSuc = listaSucs.getPrimero();
//        while(nodoSuc != null){
//            try{
//                geant.productosSucursalOrdenadosPorNombre(nodoSuc.getDato().getNombre());
//            }
//            catch(Exception e){
//            }    
//        }

        //Venta manual
//        try {
//            geant.VenderProductoEnSucursal("1403796890", 80, "local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//       ----------------------------------------------------------------------------------------------------
        //Productos de una sucursal ordenados por nombre y con su stock
//        try {
//            geant.productosSucursalOrdenadosPorNombre("local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
        //Productos totales de la cadena de supermercados, ordenados por nombre y con su stock total
        //geant.productosTotalesOrdenadosPorNombre();
        //geant.indicarExistenciasPorSucursal("1403796890");
        //Test de tamaño del arbol
        //System.out.println(listaSucs.getPrimero().getSiguiente().getDato().getArbolProductos().obtenerTamanio());
        //System.out.println(listaSucs.getPrimero().getDato().getArbolProductos().inOrden());
        //Printer.imprimirArbol(listaSucs.getPrimero().getDato().getArbolProductos());
        //Printer.imprimirPorCodigo(listaSucs);
        //Printer.imprimirNombres(listaSucs);
        //Printer.imprimirArbol(listaSucs.getPrimero().getSiguiente().getDato().getArbolProductos());
        //geant.indicarExistenciasTotales("1403796890");
        //geant.indicarExistenciasPorSucursal("1403796890");
        //Test de incorporar producto en una sucursal
//        Producto test = new Producto("123", "Galletas", 103.0);
//
//        try {
//            geant.incorporarProductoEnSucursal(test, "local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//
//        Producto test2 = new Producto("123", "Galletas", 103.0);
//
//        try {
//            geant.incorporarProductoEnSucursal(test2, "local 122");
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//        Lista<Sucursal> aux2 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux2);
        //-------------------------------------------------------------------------------------------------------------
//
//        Lista<Sucursal> aux3 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux3);
//        -------------------------------------------------------------------------------------------------------------
//        Nodo<Sucursal> aux = geant.getListaSucursales().getPrimero();
//        while (aux != null) {
//            System.out.print(aux.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(aux.getDato().getArbolProductos(), ";");
//            aux = aux.getSiguiente();
//        }
//        System.out.println("****************************************");
//        System.out.println("Elimino un producto el 123 y el 1000073");
//        geant.eliminarProductoEnCadena("123");
//        geant.eliminarProductoEnCadena("1000073");
//        Nodo<Sucursal> b = geant.getListaSucursales().getPrimero();
//        while (b != null) {
//            System.out.print(b.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(b.getDato().getArbolProductos(), ";");
//            b = b.getSiguiente();
//        }
//        Comparable test3 = "8971892994";
//        System.out.println("****************************************");
//        System.out.println("Elimino producto 1000073 de la sucursal 1");
//        try {
//            geant.eliminarProductoEnSucursal(test3, "local 104");
//            
//        } catch (SucursalNotFound ex) {
//            System.out.println("La sucursal no fue encontrada");
//        }
//        Lista<Sucursal> aux4 = geant.getListaSucursales();
//        Printer.imprimirPorCodigo(aux4);
//
//        Nodo<Sucursal> aux2 = geant.getListaSucursales().getPrimero();
//        while (aux2 != null) {
//            System.out.print(aux2.getDato().getNombre() + ": ");
//            Printer.imprimirPorCodigo(aux2.getDato().getArbolProductos(), ";");
//            aux2 = aux2.getSiguiente();
//        }
        //TArbolBB<Producto> aux = a.getArbolProductos();
        //Printer.imprimirPorCodigo(aux, ";");
        //Printer.ImprimirPorCodigo(aux);
//        Printer.imprimirPorCodigo(aux, ";");
//        Printer.ImprimirNombres(aux);
//        Printer.imprimirNombres(aux, "--");
    }

}
