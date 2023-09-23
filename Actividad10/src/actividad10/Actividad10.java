/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad10 {

    /**
     * @param args the command line arguments
     * En este ejercicio tendrá que pedir 5 números, mostrarlos, muestra la suma y muestra los muestra en orden inverso
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner( System.in );
		int num[]=new int[5];

		 for (int x=0;x<5;x++)
		 {
		 System.out.print("Introduzca un número: ");
		 num[x]=sc.nextInt();
                 
		 }

		 System.out.println("Los números (en orden inverso):");
		 for (int i=4;i>=0;i--){
		 System.out.println(num[i]);
                 }
                 
    }
    
}
