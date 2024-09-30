package proyectotienda;

public class Articulo {
    private String nombre;
    private int cantidad;
    private double precioUnidad;

    // Constructor
    public Articulo(String nombre, int cantidad, double precioUnidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    // Método para reducir la cantidad de artículos vendidos
    public boolean vendido(int cantidadVendida) {
        if (cantidad >= cantidadVendida) {
            cantidad -= cantidadVendida;
            return true;
        }
        return false;
    }

    // Método toString para imprimir información del artículo
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio por unidad: " + precioUnidad + " Soles";
    }
}
