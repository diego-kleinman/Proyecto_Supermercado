package Estructuras;

import Interfaces.IProducto;

public class Producto implements IProducto {
    
    private String nombre;
    private Comparable etiqueta;
    private Double precio;

    private int[] stock = new int[1];
    
    public Producto(Comparable etiqueta, String nombre, Double precio){
        this.etiqueta=etiqueta;
        this.precio=precio;
        this.nombre=nombre;
        this.stock[0] = 0;
    }

    //Getters y Setters
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta){
        this.etiqueta=etiqueta;
    }

    public Double getPrecio(){
    return this.precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public Integer getStock(){
        return this.stock[0];
    }

    public void setStock(Integer stock){
        this.stock[0]=stock;
    }

    public String getNombre(){
        return this.nombre;
    }
  
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /*Método que se ejecuta sobre un producto y compara con otro producto que le entra por parámetro
    Hicimos éste método para evitar crear nodos especiales en los cuales su etiqueta fuera los productos asociados
    ya que la etiqueta de un nodo es de tipo Comparable y se puede comparar.
    Este método nos desliga de crear nodos especiales, podemos utilizar los nodos que ingresamos al principio al programa
    en el archivo de altas y simplemente casteando sus productos asociados ejecutar éste método.
    Creemos que es una implementación mejor a crear nodos especiales ya que nos libera de tener que ingresar nodos particulares
    para comparar*/
    
    public int compareToByName(Producto producto) {
        String aux = this.nombre.replace(" ", "");
        String aux2 = producto.getNombre().replace(" ","");
        return aux.compareTo(aux2);
    }

    

}