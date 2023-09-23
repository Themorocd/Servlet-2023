/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad9 {

    /**
     * @param args the command line arguments
     * Tendrás que realizar un programa donde se pregunte por un número cualquiera , y se den todos los números de la serie de FIBONACCI hasta ese número.
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        int num,fibo1,fibo2,x;
  
        do{
            System.out.print("Introduce numero mayor que 1: ");
            num = sc.nextInt();
        }while(num<=1);
  
        System.out.println("Los " + num + " primeros términos de la serie de Fibonacci son:");                 

        fibo1=1;
        fibo2=1;

        System.out.print(fibo1 + " ");
        for(x=2;x<=num;x++){
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        System.out.println();
    }
    
}
