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
    @Override
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta){
        this.etiqueta=etiqueta;
    }

    @Override
    public Double getPrecio(){
    return this.precio;
    }

    @Override
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    @Override
    public Integer getStock(){
        return this.stock[0];
    }

    @Override
    public void setStock(Integer stock){
        this.stock[0]=stock;
    }

    @Override
    public String getNombre(){
        return this.nombre;
    }
  
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Producto clonar(){
    
        return new Producto(this.getEtiqueta(),this.getNombre(),this.getPrecio());
    
    }

    

}