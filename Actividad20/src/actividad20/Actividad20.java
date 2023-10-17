/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad20;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        Informe informe = new Informe();
        
        System.out.println("Ingrese los datos del comprador");
        while (informe.nombre == null || informe.nombre.isEmpty()){
            System.out.println("Nombre:");
            informe.nombre = sc.nextLine();
        } 
        
        
        
            System.out.println("Cuanto esta dispuesto a pagar?");
            informe.dinero = sc.nextDouble();
            System.out.println("Efectivo?(Si/No");
            informe.metalico = sc.next().trim().toUpperCase();
            System.out.println("En cuantos dias?");
            informe.dias = sc.nextInt();
        
        informe.mostrarInforme();
        
    }
    
}
