package plantilla;

public class Main {

    public static void main(String[] args) {
        CadenaDeSupermercados geant = new CadenaDeSupermercados();

        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/plantilla/pruebaSucursales.txt");
        for (int i = 0; i < lineas2.length; i++) {
            String[] aux = lineas2[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                String nombre = aux[0];
                String telefono = aux[1];
                String direccion = aux[2];
                String barrio = aux[3];
                String ciudad = aux[4];

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Sucursal sucursal = new Sucursal(direccion,telefono,nombre,barrio,ciudad);
                geant.incorporarSucursal(sucursal);
            } catch (Exception e) {

                System.out.println("Error de lectura de sucursal: \n" + "linea: " + lineas2[i]);

            }

        }

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/plantilla/altasPrueba.txt");
        for (int i = 0; i < lineas.length; i++) {
            String[] prod = lineas[i].split(",");
            try {
                // Creamos todas las variables para poder instanciar un objeto de la clase
                // Producto
                Comparable codigo = prod[0];
                String descripcion = prod[1];
                int precio = Integer.valueOf(prod[2]);
                int cantidad = Integer.valueOf(prod[3]);

                // Instanciamos el objeto producto con las variables creadas anteriormente.
                Producto producto = new Producto(codigo, descripcion, precio, cantidad);
                geant.incorporarProductoEnCadena(producto);

            } catch (Exception e) {

                System.out.println("Error de lectura: " + "linea: " + lineas[i]);

            }

        }
    }

}
