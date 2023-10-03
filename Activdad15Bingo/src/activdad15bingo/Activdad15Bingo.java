/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package activdad15bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andres
 */
public class Activdad15Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] ticket = generateBingoTicket();
        printBingoTicket(ticket);
    }

    public static int[][] generateBingoTicket() {
        int[][] ticket = new int[3][9];
        Random random = new Random();

        // Llena las columnas con números en orden
        for (int col = 0; col < 9; col++) {
            int start = col * 10 + 1;
            for (int row = 0; row < 3; row++) {
                ticket[row][col] = start + row;
            }
        }

        // Elimina 4 números aleatorios en cada fila
        for (int row = 0; row < 3; row++) {
            List<Integer> availableColumns = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                availableColumns.add(col);
            }
            Collections.shuffle(availableColumns);
            for (int i = 0; i < 3; i++) {
                int colToRemove = availableColumns.get(i);
                ticket[row][colToRemove] = 0; // Marca el número como hueco vacío
            }
        }

        return ticket;
    }

    public static void printBingoTicket(int[][] ticket) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (ticket[row][col] == 0) {
                    System.out.print("   "); // Espacio para el hueco vacío
                } else {
                    System.out.printf("%2d ", ticket[row][col]);
                }
            }
            System.out.println();
        }
    }
    
}
