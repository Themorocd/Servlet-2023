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
        
      int[] jugador1 = new int[4];
        int[] jugador2 = new int[4];
        int[] jugador3 = new int[4];

        ingresarNumeros(teclado, jugador1, "Jugador 1");
        ingresarNumeros(teclado, jugador2, "Jugador 2");
        ingresarNumeros(teclado, jugador3, "Jugador 3");

        // Juez
        int[] juez = new int[2];
        ingresarNumeros(teclado, juez, "Juez");

        // Calcular aciertos y verificar números en el rango del juez
        int aciertosJugador1 = calcularAciertos(jugador1, juez);
        int aciertosJugador2 = calcularAciertos(jugador2, juez);
        int aciertosJugador3 = calcularAciertos(jugador3, juez);

        System.out.println("Jugador 1 aciertos: " + aciertosJugador1);
        System.out.println("Jugador 2 aciertos: " + aciertosJugador2);
        System.out.println("Jugador 3 aciertos: " + aciertosJugador3);

        int maxAciertos = Math.max(aciertosJugador1, Math.max(aciertosJugador2, aciertosJugador3));
        int ganador = -1;

        if (aciertosJugador1 == maxAciertos) {
            ganador = 1;
        }

        if (aciertosJugador2 == maxAciertos) {
            ganador = 2;
        }

        if (aciertosJugador3 == maxAciertos) {
            ganador = 3;
        }

        if (ganador != -1) {
            System.out.println("El ganador es el Jugador " + ganador + " con " + maxAciertos + " aciertos.");
        } else {
            System.out.println("Empate. No hay ganador.");
        }

        
    }

    // Método para ingresar los números para un jugador o el juez
    static void ingresarNumeros(Scanner scanner, int[] jugador, String nombreJugador) {
        System.out.println(nombreJugador + ", ingrese " + jugador.length + " números del 1 al 10 separados por espacios:");
        String input = scanner.nextLine();
        String[] partes = input.split(" ");

        for (int i = 0; i < jugador.length; i++) {
            int numero = Integer.parseInt(partes[i]);
            if (numero >= 1 && numero <= 10) {
                jugador[i] = numero;
            }
        }
    }

    // Método para calcular la cantidad de aciertos entre un jugador y el juez
    static int calcularAciertos(int[] jugador, int[] juez) {
        int aciertos = 0;

        for (int numeroJugador : jugador) {
            for (int numeroJuez : juez) {
                if (numeroJugador == numeroJuez) {
                    aciertos++;
                    break;
                }
            }
        }

        return aciertos;
    }

   
    
}
