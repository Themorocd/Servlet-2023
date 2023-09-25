/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad11 {

    /**
     * @param args the command line arguments
     * Una vez visto en clase un ejemplo del ejercicio, tendrás que realizar ese mítico juego del 3 en raya. 

En ella, habrá dos jugadores que tengan que hacer el 3 en raya, los signos serán el X y el O, cuando haya una posición vacía habrá un –

El tablero de juego, será una matriz de 3x3 de char.

El juego termina cuando uno de los jugadores hace 3 en raya o si no hay más posiciones que poner.

El juego debe pedir las posiciones donde el jugador actual quiera poner su marca, esta debe ser validada y por supuesto que no haya una marca ya puesta.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] tablero = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char jugadorActual = 'X';
        int jugadasRealizadas = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al 3 en raya");

        while (true) {
            mostrarTablero(tablero);

            // Pido la fila y la columna al jugador actual
            int fila, columna;
            do {
                System.out.print("Jugador " + jugadorActual + ", introduce la fila (0, 1, 2): ");
                fila = scanner.nextInt();
                System.out.print("Jugador " + jugadorActual + ", introduce la columna (0, 1, 2): ");
                columna = scanner.nextInt();
            } while (!esMovimientoValido(tablero, fila, columna));//si el movimiento es valido hago lo siguiente

            // Realizar el movimiento
            tablero[fila][columna] = jugadorActual;//pinto la X o O dependiendo del jugador
            jugadasRealizadas++;

            // Verificar si alguien ha ganado
            if (hayGanador(tablero, jugadorActual)) {
                mostrarTablero(tablero);
                System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                break;
            }

            // Verificar si no hay más movimientos posibles (empate)
            if (jugadasRealizadas == 9) {
                mostrarTablero(tablero);
                System.out.println("¡Es un empate!");
                break;
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';//con esto cambio de un jugador a otro 
        }

        scanner.close();//cierre del escaner
    }

    public static void mostrarTablero(char[][] tablero) {//aqui pinto el tablelo
        System.out.println("Tablero actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {//genero el tablero de 3x3
                char marca = tablero[i][j];
                if(marca == ' '){
                    marca = '-';//cambio los espacios vacios por -
                }
                System.out.print(marca);
                if (j < 2) {
                    System.out.print(" | ");//separador de columnas
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");//separador de filas
            }
        }
    }

    public static boolean esMovimientoValido(char[][] tablero, int fila, int columna) {
        // Compruebo que la posición esté dentro del tablero y que esté vacía
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ';
    }

    public static boolean hayGanador(char[][] tablero, char jugador) {
        // Compruebo filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; // Ganador en una fila
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true; // Ganador en una columna
            }
        }
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true; // Ganador en la diagonal principal
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true; // Ganador en la diagonal secundaria
        }
        return false;
    
        
    }
    
}
