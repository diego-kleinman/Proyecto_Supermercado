package Estructuras_Básicas;


public class Producto {

    private String nombre;
    private Comparable etiqueta;
    private Double precio;
    private int[] stock = new int[1];

    /**
     * Constructor de la clase Producto
     *
     * @param etiqueta Etiqueta del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto(Comparable etiqueta, String nombre, Double precio) {
        this.etiqueta = etiqueta;
        this.precio = precio;
        this.nombre = nombre;
        this.stock[0] = 0;
    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Double getPrecio() {
        return this.precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public Integer getStock() {
        return this.stock[0];
    }


    public void setStock(Integer stock) {
        this.stock[0] = stock;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método encargado de clonar un Producto
     *
     * @return Producto clonado
     */
    public Producto clonar() {

        return new Producto(this.getEtiqueta(), this.getNombre(), this.getPrecio());

    }

}
