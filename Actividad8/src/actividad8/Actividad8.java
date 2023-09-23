/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad8;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad8 {

    /**
     * @param args the command line arguments
     * Calcula el factorial de un número pedido por teclado.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        int num;
        double facto = 1;
        do {            
            System.out.print("Introduce un numero para calcular el factorial: ");
            num = sc.nextInt();
        } while (num<0);
            
        for (int x = 1; x <= num; x++) {
            facto = facto*x;
        }
        System.out.printf("%d! = %.0f %n",num, facto);
    }
    
}
