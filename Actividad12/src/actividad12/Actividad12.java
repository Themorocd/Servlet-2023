/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad12;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad12 {

    /**
     * @param args the command line arguments
     */
    private static String[] productos = {"POPGALLETA", "POPLIMON", "POPTARTAQUESO", "POPUVA"};
    private static double[] precios = {7, 5, 8, 10};
    private static int[] stock = {10, 10, 10, 10}; // Cantidad inicial de cada producto en stock
    private static final String pass = "admin123"; // Clave para reponer el stock
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a la Máquina de POPS!");
        while (true) {
            System.out.println("\nMenú de productos:");
            for (int i = 0; i < productos.length; i++) {
                System.out.println((i + 1) + ". " + productos[i] + " - " + precios[i]+"€" + " (" + stock[i] + " en stock)");
            }

            System.out.print("\nPor favor, seleccione un producto (1-" + productos.length + ") o ingrese 0 para salir: ");
            int seleccion = scanner.nextInt();

            if (seleccion == 0) {
                System.out.println("Gracias por utilizar la Máquina de POPS. ¡Hasta luego!");
                break;
            } else if (seleccion == 99) {
                System.out.print("Por favor, ingrese la clave para reponer el stock: ");
                String clave = scanner.next();
                if (clave.equals(pass)) {
                    reponerStock();
                } else {
                    System.out.println("Clave incorrecta. No tiene permiso para reponer el stock.");
                }
            } else if (seleccion < 1 || seleccion > productos.length) {
                System.out.println("Selección no válida. Por favor, elija un número válido.");
            } else {
                int indiceProducto = seleccion - 1;
                String productoElegido = productos[indiceProducto];
                double precioProducto = precios[indiceProducto];

                if (stock[indiceProducto] == 0) {
                    System.out.println("Lo sentimos, " + productoElegido + " está agotado.");
                } else {
                    System.out.println("Ha seleccionado " + productoElegido + " por " + precioProducto+"€");
                    System.out.print("Por favor, ingrese el monto a pagar: €");
                    double montoIngresado = scanner.nextDouble();

                    if (montoIngresado < precioProducto) {
                        System.out.println("El monto ingresado es insuficiente. Por favor, ingrese más dinero.");
                    } else {
                        stock[indiceProducto]--; // Reducir el stock
                        double cambio = montoIngresado - precioProducto;
                        System.out.println("¡Disfrute su " + productoElegido + "! Su cambio es de: " + cambio+"€");
                    }
                }
            }
        }

        // Cerrar el escáner
        scanner.close();
    }

    // Método para reponer el stock
    private static void reponerStock() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMenú de reposición de stock:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i] + " - Stock actual: " + stock[i]);
        }

        System.out.print("Por favor, seleccione el producto para reponer (1-" + productos.length + "): ");
        int seleccion = scanner.nextInt();

        if (seleccion >= 1 && seleccion <= productos.length) {
            int indiceProducto = seleccion - 1;
            System.out.print("Por favor, ingrese la cantidad para reponer: ");
            int cantidad = scanner.nextInt();
            stock[indiceProducto] += cantidad;
            System.out.println(productos[indiceProducto] + " ha sido reabastecido con " + cantidad + " unidades.");
        } else {
            System.out.println("Selección no válida. Por favor, elija un número válido.");
        }
        
    }
    
}
