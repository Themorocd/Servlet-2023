/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad17;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner  sc = new Scanner (System.in);
        Alumno alumno = new Alumno();
        int[][] notas = new int [3][3];
        Random random = new Random();
        double media = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                notas[x][y] = random.nextInt(10);
                
            }
            
        }
       /* for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(notas[x][y]+" ");
                
            }
            System.out.println("");
            
        }
        */
        System.out.println("          Trimestre 1 Trimestre 2 Trimestre 3 Media del Alumno");
        
        for (int x = 0; x < 3; x++) {
            int sumNotas = 0;
            System.out.print("Alumno "+(x+1)+"          ");
            for (int y = 0; y < 3; y++) {
                System.out.print(notas[x][y]+"           ");
                sumNotas +=notas[x][y];
            }
            
            media = (double) sumNotas /3;
            alumno.nota = media;
            System.out.printf("%.2f%n",media);
           
        }
        
        int sumTotal = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                sumTotal += notas[x][y];
            }
        }
        double mediaclase = (double) sumTotal /(3*3);
        double diferencia = mediaclase - media;
        alumno.diffmedia = diferencia;
        System.out.println("\nMedia del curso: "+String.format("%.2f", mediaclase));
        
        for (int x = 1; x <=3; x++) {
            
        
        System.out.println("Introduce el nombre del alumno "+x+":");
         alumno.nombre = sc.nextLine();
        
        do {            
            System.out.println("Comportamiento en la clase(B/b bueno o M/m Malo)?");
            alumno.comportamiento = sc.next().charAt(0);
        } while (alumno.comportamiento != 'B' && alumno.comportamiento != 'b' && alumno.comportamiento != 'M' && alumno.comportamiento != 'm');
            sc.nextLine();
       
        do {
            System.out.print("Porcentaje de deberes entregados (0-100): ");
            alumno.deberes = sc.nextDouble();
        } while (alumno.deberes < 0 || alumno.deberes > 100);
            sc.nextLine();
        
        do {
            System.out.print("Porcentaje de asistencia (0-100): ");
            alumno.asistencia = sc.nextDouble();
        } while (alumno.asistencia < 0 || alumno.asistencia > 100);
        sc.nextLine();

        //System.out.print("Nota media del alumno: ");
         //alumno.nota = sc.nextDouble();

         
        alumno.mostrarinformeDeClase();
        
        }
        
    }
    
}
