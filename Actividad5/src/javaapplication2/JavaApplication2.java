/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author Andres
 * En este programa, tendrás que preguntar por un número. 
En primer lugar tendrás que responder si es un número primo o no, y después, tendrás que preguntar si se quiere introducir otro número. 
En el caso de que se introduzca otro número se tendrá que repetir la respuesta de si es primo o no etc....
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner sc = new Scanner (System.in);  
         while (true) {            //Usamos un bucle while para poder pedir si quiere o no comprobar otro numero
             System.out.println("Introduce un numero");
             int num = sc.nextInt();
             
             if(esprimo(num)){//creamos el metodo esprimo, para hacer las comprobaciones en el 
                 System.out.println("El "+num+" es primo");
             }
             else{
                 System.out.println("El "+num+" no es primo");
             }
             
             System.out.println("Quieres comprobar otro numero??S/N");
             
             String comprobar = sc.next().trim().toLowerCase();//con esto pasamos la letra a minuscula
             if(!comprobar.equals("s")){//si es distinto a "s" se para el programa
                 break;
             }
             
             
        }
        
        
    }

    private static boolean esprimo(int num) {//aqui hacemos las comprobaciones para saber si un numero es primo o no
        if(num<=1){
            return false;
            
        }if (num <=3){
            return true;
        } if(num % 2 == 0 || num % 3 == 0){
            return false;
        }
        int x = 5;
        
        while (x * x <=num) {
        
            if(num % x == 0  || num % (x+2)==0){
                return false;
            }
            x +=6;
            
        }
        
        return true;
        
    }
    
}
