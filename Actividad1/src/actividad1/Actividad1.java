/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad1;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
    int num1,num2,total;
    
    System.out.println("Introduce 2 numeros para sumar");//Aqui le pido que introduzca los 2 numeros que quiero sumar
    System.out.println("Introduce el numero 1");
    num1 = sc.nextInt();//introduzco el primer numero
    System.out.println("Introduce el numero 2");
    num2 = sc.nextInt();//ahora el segundo 
    total= num1+num2;//sumo ambos numeros
        System.out.println("La suma de los numeros: "+num1+" y "+num2+" es: "+total);//los muestro por consola
    
    }
    
}
