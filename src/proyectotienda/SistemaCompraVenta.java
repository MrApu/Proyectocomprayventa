package proyectotienda;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase implementa el sistema de compra y venta de una tienda.
 *
 * @autor MrAPu
 */
public class SistemaCompraVenta {

    String nombreTienda;
    static HashMap<String, Articulo> listaArticulos = new HashMap<>(); // Lista de artículos

    // Constructor
    public SistemaCompraVenta(String nombre) {
        this.nombreTienda = nombre;
    }

    // Método para insertar artículos
    public void agregarArticulo(Articulo articulo) {
        String clave = articulo.getNombre();
        if (!listaArticulos.containsKey(clave)) {
            listaArticulos.put(clave, articulo);
            System.out.println("\nSE HA AÑADIDO CORRECTAMENTE EL ARTÍCULO A LA LISTA.");
        } else {
            System.out.println("\nERROR, ARTÍCULO REPETIDO, NO SE HA DADO DE ALTA.");
        }
    }

    // Método para buscar un artículo
    public Articulo buscarArticulo(String nombre) {
        return listaArticulos.get(nombre);
    }

    // Método para vender un artículo
    public double venderArticulo(String nombre, int cantidad) {
        Articulo articulo = buscarArticulo(nombre);
        if (articulo != null && articulo.vendido(cantidad)) {
            return cantidad * articulo.getPrecioUnidad();
        }
        System.out.println("VENTA NO EXITOSA.");
        return 0;
    }

    public static void mostrarMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. AÑADIR UN ARTiCULO.");
        System.out.println("2. MOSTRAR TODOS LOS ARTICULOS.");
        System.out.println("3. BUSCAR UN ARTICULO.");
        System.out.println("4. REALIZAR UNA VENTA.");
        System.out.println("5. SALIR.");
        System.out.print("SELECCIONE UNA OPCION: ");
    }

    public static void main(String[] args) {
        System.out.println("-------SISTEMA DE GESTION DE TIENDA-------");
        Scanner entrada = new Scanner(System.in);
        SistemaCompraVenta miTienda = new SistemaCompraVenta("SUPERMERCADO CENTRAL JOSEBL");
        int opcion = 0;

        do {
            try {
                mostrarMenu();
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1 -> {
                        entrada.nextLine(); // Consumir salto de línea
                        System.out.print("NOMBRE DEL ARTICULO: ");
                        String nombre = entrada.nextLine();

                        System.out.print("CANTIDAD: ");
                        int cantidad = entrada.nextInt();

                        System.out.print("PRECIO POR UNIDAD: ");
                        double precio = entrada.nextDouble();

                        Articulo nuevoArticulo = new Articulo(nombre, cantidad, precio);
                        miTienda.agregarArticulo(nuevoArticulo);
                    }

                    case 2 -> {
                        System.out.println("\nARTICULOS:");
                        for (Articulo articulo : listaArticulos.values()) {
                            System.out.println(articulo);
                        }
                    }

                    case 3 -> {
                        entrada.nextLine(); // Consumir salto de línea
                        System.out.print("NOMBRE DEL ARTICULO A BUSCAR: ");
                        String nombreBusqueda = entrada.nextLine();
                        Articulo articuloBuscado = miTienda.buscarArticulo(nombreBusqueda);
                        if (articuloBuscado != null) {
                            System.out.println(articuloBuscado);
                        } else {
                            System.out.println("ARTICULO NO ENCONTRADO.");
                        }
                    }

                    case 4 -> {
                        entrada.nextLine(); // Consumir salto de línea
                        System.out.print("NOMBRE DEL ARTICULO: ");
                        String nombreVenta = entrada.nextLine();

                        System.out.print("CANTIDAD A VENDER: ");
                        int cantidadVenta = entrada.nextInt();

                        double totalVenta = miTienda.venderArticulo(nombreVenta, cantidadVenta);
                        if (totalVenta > 0) {
                            System.out.println("TOTAL DE LA VENTA: " + totalVenta + " Soles");
                        }
                    }

                    case 5 -> System.out.println("SALIENDO DEL PROGRAMA...");
                            
                             

                    default -> System.out.println("OPCIÓN NO VÁLIDA.");
                }
            } catch (InputMismatchException e) {
                entrada.nextLine(); // Limpiar entrada
                System.err.println("ERROR DE ENTRADA, SELECCIONE UNA OPCIÓN CORRECTA.");
            }
        } while (opcion != 5);
        
        entrada.close(); // Cerrar el escáner
    }
}
