/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad16;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Scanner sc = new Scanner (System.in);
       Alimento alimento = new Alimento();
       
      
        System.out.println("Ingrese los datos del alimento:");
        while (alimento.nombre == null || alimento.nombre.isEmpty()) {
            System.out.print("Nombre del alimento: ");
            alimento.nombre = sc.nextLine();
        }

        while (true) {
            try {
                System.out.print("Contenido en lípidos (%): ");
                alimento.Lipidos = Double.parseDouble(sc.nextLine());

                System.out.print("Contenido en hidratos de carbono (%): ");
                alimento.Hidratos = Double.parseDouble(sc.nextLine());

                System.out.print("Contenido en proteínas (%): ");
                alimento.Proteinas = Double.parseDouble(sc.nextLine());

                break; // Salir del bucle si se ingresan valores correctos
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese valores numéricos válidos para lípidos, hidratos y proteínas.");
            }
        }

        System.out.print("¿Es de origen animal? (Sí/No): ");
        String origenAnimalInput = sc.nextLine().trim().toLowerCase();
        alimento.Animal = origenAnimalInput.equals("sí") || origenAnimalInput.equals("si");

        while (true) {
            System.out.print("Contenido de minerales y vitaminas (A/M/B): ");
            String contenidoMineralesVitaminasInput = sc.nextLine().trim().toUpperCase();
            if (contenidoMineralesVitaminasInput.equals("A") || contenidoMineralesVitaminasInput.equals("M") || contenidoMineralesVitaminasInput.equals("B")) {
                alimento.MineralesVitaminas = contenidoMineralesVitaminasInput.charAt(0);
                break; // Salir del bucle si se ingresa un valor correcto
            } else {
                System.out.println("Por favor, ingrese un valor válido para minerales y vitaminas (A/M/B).");
            }
        }

        // Mostrar información del alimento
        alimento.mostrarAlimento();
        
    }
    
}
