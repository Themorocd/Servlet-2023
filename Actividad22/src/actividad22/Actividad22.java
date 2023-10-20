/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad22;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double PESO_BAJA_CALIDAD = 1.2;
        final double PESO_MEDIA_CALIDAD = 1.5;
        final double PESO_ALTA_CALIDAD = 1.7;

        final double PRECIO_BAJA_CALIDAD = 1;
        final double PRECIO_MEDIA_CALIDAD = 2;
        final double PRECIO_ALTA_CALIDAD = 3;
        final double GASTO_POR_BOTELLA = 0.2;
         double totalIngresos = 0;
        double totalGastos = 0;
        double totalPesoUva = 0;
        double pesofinal = 0;
        Scanner sc = new Scanner(System.in);
       double[][] uva = new double[6][6];
       int[] botellasCompradas = new int[6];
        String[] calidadVino = new String[6];
        Random random = new Random();
        
        for (int x = 0; x < 6; x++) {
            for (int i = 0; i < 6; i++) {
                double aleatorio = 1.8 + random.nextDouble()*(3.2 - 1.8);
                uva[x][i] = aleatorio;
            }
        }
        System.out.println("Uvas generadas");
         for (int x = 0; x < 6; x++) {
            for (int i = 0; i < 6; i++) {
                System.out.printf("Uvas: %.2f ",uva[x][i]);
            }
             System.out.println("");
        }
        //Total matrix
        double total = 0;
        for (int x = 0; x < 6; x++) {
            for (int i = 0; i < 6; i++) {
                total +=uva[x][i];
            }
        }
        System.out.printf("El total de kilos de uva es: %.2f",total," Kg");
        
        
          for (int i = 0; i < 6; i++) {
            int botellas = random.nextInt(11) + 10; // Generar un número aleatorio entre 10 y 20
            botellasCompradas[i] = botellas;

            System.out.print("Cliente " + (i + 1) + " ¿Qué calidad de vino quieres? (b, m, a): ");
            calidadVino[i] = sc.next().toLowerCase();
        }
          
          for (int i = 0; i < 6; i++) {
               double pesoUva = 0;
               double ingresosCliente = 0;
                if (calidadVino[i].equals("b")) {
                pesoUva = botellasCompradas[i] * PESO_BAJA_CALIDAD;
                ingresosCliente = botellasCompradas[i] * PRECIO_BAJA_CALIDAD;
                
            } else if (calidadVino[i].equals("m")) {
                pesoUva = botellasCompradas[i] * PESO_MEDIA_CALIDAD;
                ingresosCliente = botellasCompradas[i] * PRECIO_MEDIA_CALIDAD;
            } else if (calidadVino[i].equals("a")) {
                pesoUva = botellasCompradas[i] * PESO_ALTA_CALIDAD;
                ingresosCliente = botellasCompradas[i] * PRECIO_ALTA_CALIDAD;
            }
              totalPesoUva = total;
              totalPesoUva -=pesoUva;
              pesofinal = total - totalPesoUva;
              totalIngresos += ingresosCliente;
              totalGastos += botellasCompradas[i] * GASTO_POR_BOTELLA;
              System.out.println("\nEl cliente " + (i + 1) + " compra " + botellasCompradas[i] + " botellas de " + calidadVino[i] + " calidad, por lo tanto ha comprado " + pesoUva + " kg de uva. Hemos ingresado " + ingresosCliente + " euros.");

          }
            // Mostrar resultados
        System.out.println("\nEste año se han producido " + total + " kg de UVA");
        System.out.println("Me queda "+pesofinal+" kg de uva");
        System.out.println("En total hemos facturado (Total de ingresos - gastos): " + (totalIngresos - totalGastos) + " euros.");
    

       
    }
       
    
}
