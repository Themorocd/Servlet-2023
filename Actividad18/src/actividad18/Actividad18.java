/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad18;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        Libro libro = new Libro();
        
        System.out.println("Ingrese los datos del libro");
        while (libro.nombre == null || libro.nombre.isEmpty()) {
            
            System.out.println("Nombre del libro");
            
            libro.nombre = sc.nextLine();
            
        }
        
        while (true) {            
            try {
                System.out.println("Numero de paginas: ");
                libro.paginas = sc.nextInt();
                
                System.out.println("Numero de subtitulos: ");
                libro.subtitulos = sc.nextInt();
                
                System.out.println("Numero de imagenes: ");
                libro.img = sc.nextInt();
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros enteros");
            }
        }
        
        while (true) {            
             System.out.println("Nacionalidad del autor (N o E)");
             String tiponacionalidad = sc.nextLine().trim().toUpperCase();
             if((tiponacionalidad.equals("N") || (tiponacionalidad.equals("E") ))){
            libro.nacionalidad = tiponacionalidad.charAt(0);
            break;
        }else{
                 System.out.println("Por favor, ingrese un tipo de nacionalidad valido");
             }
        }
        
        
        
        
        while (true) {            
             System.out.println("Tipo de tapa: (D/d o M/m o B/b)");
             String tipotapa = sc.nextLine().trim().toUpperCase();
             if((tipotapa.equals("D") || (tipotapa.equals("M") || tipotapa.equals("B")))){
            libro.tapa = tipotapa.charAt(0);
            break;
        }else{
                 System.out.println("Por favor, ingrese un tipo de tapa valido");
             }
        }
       
        
         while (true) {            
             System.out.println("Tipo de formato: (I/i o Ma/ma o Me/me");
             String tipoformato = sc.nextLine().trim().toUpperCase();
             if((tipoformato.equals("I") || (tipoformato.equals("MA") || tipoformato.equals("ME")))){
             libro.formato = tipoformato;
             break;
        }else{
                 System.out.println("Por favor, ingrese un tipo de formato valido");
             }
        }
        
        
        libro.monstrarLibro();
        
    }
    
}
