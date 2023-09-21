/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Andres
 * Juego de piedra papel o tijera, 2 jugadores se enfrentan, ambos tienen la posibilidad de elegir una de las 3 opciones, si sacan la misma figura se repite el juego, si uno de los dos
 * gana debe de mostrar el mensaje de "Juegador x ha ganado con X"
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
         int jugador1,jugador2;//inicializo las variables
        do {            
           //Creo un bucle do white para decir que mientras jugador1 y jugador2 sean iguales se siga repitiendo
       System.out.println("Jugador uno, elija de una de las siguiente opciones: 1.-Piedra  2.-Papel   3.-Tijera");
       jugador1 = sc.nextInt();
       System.out.println("Jugador dos, elija de una de las siguiente opciones: 1.-Piedra  2.-Papel   3.-Tijera");
       jugador2 = sc.nextInt();
       switch (jugador1) {
            case 1:
                switch (jugador2) {
                    case 1:System.out.println("Empate");break;//Importante los break; en casa case porque sino se bugea
                    case 2:System.out.println("Gana jugador 2 con papel");break;
                    case 3:System.out.println("Gana jugador 1 con piedra");break;
  
                }
                break;
            case 2: 
                switch (jugador2) {
                    case 1:System.out.println("Jugador 1 gana con papel");break;
                    case 2:System.out.println("Empate");break;
                    case 3:System.out.println("Gana jugador 2 con tijera");break;
 
                }
                break;
            case 3:
                switch (jugador2) {
                    case 1:System.out.println("Jugador 2 gana con piedra");break;
                    case 2:System.out.println("Jugador 1 gana con tijera");break;
                    case 3:System.out.println("Empate");break;
                        
                }
                break;
           
        }
        } while (jugador1 == jugador2);
       
       
        
    }
    
}
