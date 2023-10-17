/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad19;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        Informe[] informe = new Informe[3];
        
         for (int x = 0; x < 3; x++) {
            informe[x] = new Informe();
            System.out.println("Número de persona: Persona " + (x + 1));
            System.out.println("¿Es deportista?");
            informe[x].esdeportista = sc.nextLine().toUpperCase();
            System.out.println("Que tipo de metabolismo tiene: Alto (A), Medio (M) o Bajo (B)?");
            informe[x].metabolismo = sc.nextLine().toUpperCase();
            System.out.println("Qué hábitos de vida lleva: Sedentaria (S), Activa (A) o Muy activa (MA)?");
            informe[x].vida = sc.nextLine().toUpperCase();

            // Generar calorías aleatorias para desayuno, almuerzo y cena
            informe[x].caldesayuno = informe[x].generarCaloriasAleatorias();
            informe[x].calalmuerzo = informe[x].generarCaloriasAleatorias();
            informe[x].calcena = informe[x].generarCaloriasAleatorias();

            int totalCalorias = informe[x].caldesayuno + informe[x].calalmuerzo + informe[x].calcena;
            informe[x].mostrarInforme(totalCalorias);
            
        }
        
        
    }
    
}
