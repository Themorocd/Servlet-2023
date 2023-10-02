/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad14;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner (System.in);
        
        int [] jugador1 = new int[4];
        int [] jugador2 = new int[4];
        int [] jugador3 = new int[4];
        int [] juez = new int[2];
        
        for (int x = 0; x < 4; x++) {
            int numeros; 
            do{
                System.out.println("Jugador 1 ingresa el numero "+ (x+1)+ ":");
                numeros = teclado.nextInt();
            }while(numeros <1 || numeros> 10);
            jugador1[x] = numeros;
            
        }
         for (int x = 0; x < 4; x++) {
            int numeros; 
            do{
                System.out.println("Jugador 2 ingresa el numero "+ (x+1)+ ":");
                numeros = teclado.nextInt();
            }while(numeros <1 || numeros> 10);
            jugador2[x] = numeros;
            
        }
          for (int x = 0; x < 4; x++) {
            int numeros; 
            do{
                System.out.println("Jugador 3 ingresa el numero "+ (x+1)+ ":");
                numeros = teclado.nextInt();
            }while(numeros <1 || numeros> 10);
            jugador3[x] = numeros;
            
        }
          
         for (int x = 0; x < 2; x++) {
            int numeros; 
            do{
                System.out.println("Seleccione 2 numeros entre el 1 y el 10");
                numeros = teclado.nextInt();
            }while(numeros <1 || numeros> 10);
            juez[x] = numeros;
            
        }
           
          
          int aciertosjugador1 = calculoaciertos(jugador1,juez);
          int aciertosjugador2 = calculoaciertos(jugador1,juez);
          int aciertosjugador3 = calculoaciertos(jugador1,juez);
          int maxaciertos = Math.max(aciertosjugador1, Math.max(aciertosjugador2, aciertosjugador3));
          int ganador = -1;
          
          System.out.println("Jugador 1 aciertos :"+aciertosjugador1);
          System.out.println("Jugador 2 aciertos :"+aciertosjugador2);
          System.out.println("Jugador 3 aciertos :"+aciertosjugador3);
          
         if(aciertosjugador1 > maxaciertos){
             maxaciertos = aciertosjugador1;
             ganador = 1;
         }
         if(aciertosjugador2 > maxaciertos){
             maxaciertos = aciertosjugador1;
             ganador = 2;
         }
         if(aciertosjugador3 > maxaciertos){
             maxaciertos = aciertosjugador1;
             ganador = 3;
         }
         
        if(ganador!= -1){
            System.out.println("El ganador es el jugador: "+ganador+" con: "+maxaciertos+" aciertos");
        }else{
            System.out.println("No hay ganadores");
        }
       
    }

    private static int calculoaciertos(int[] jugador, int[] juez) {
        int acierto = 0;
        int minRango = Math.min(juez[0], juez[1]);
        int maxRango = Math.max(juez[0], juez[1]);

        for (int numero : jugador) {
            if (numero >= minRango && numero <= maxRango) {
                acierto++;
            }
        }
        return acierto;
    }

   
    
}
