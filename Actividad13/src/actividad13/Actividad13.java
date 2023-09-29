/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad13;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        
        String [] alumno = {"alu1","alu2","alu3","alu4"};
        String [] asignaturas = {"servidores","clientes","empresa","entorno"};
        int notas [][] = new int[4][4];
        boolean notasrellenas = false;
        int opc;
        do {            
        System.out.println("-----MENU--------");
        System.out.println("1.-Rellenar notas");
        System.out.println("2.-Media de la nota del alumno");
        System.out.println("3.-Media de la nota de la actividad");
        System.out.println("4.-Media de todas las notas de todas las actividades");
        System.out.println("5.-Salir");
        System.out.println("-----------------");
        
        opc = sc.nextInt();
            switch (opc) {
                case 1:
                    llenarnotas(alumno,asignaturas,notas,sc);
                    notasrellenas = true;                  
                    break;
                case 2:
                    if(!notasrellenas){
                        System.out.println("Debes de rellenar el apartado 1 primero");
                    }else{
                        medianotas(notas,sc,alumno);
                    }
                    break;
                case 3:
                     if(!notasrellenas){
                        System.out.println("Debes de rellenar el apartado 1 primero");
                    }else{
                        medianotasactividad(notas,sc,asignaturas);
                    }
                    break;
                case 4:
                    if(!notasrellenas){
                        System.out.println("Debes de rellenar el apartado 1 primero");
                    }else{
                        mediadetodo(notas);
                    }
                    break;
                
            }
        } while (opc != 5);
        System.out.println("ADIOS");
       
        
        
    }

    private static void llenarnotas(String[] alumno, String[] asignaturas, int[][] notas, Scanner sc) {
        System.out.println("Estas en Rellenar notas");
                     for (int x = 0; x < notas.length; x++) {
                        for (int i = 0; i < notas[x].length; i++) {
                            System.out.print("Nota para el alumno " + alumno[x] + " en la actividad " + asignaturas[i] + ": ");
                            notas[x][i] = sc.nextInt();
                        }
                    }
    }

    private static void medianotas(int[][] notas, Scanner sc, String[] alumno) {
        System.out.println("Introduce el numero del alumno: 1-"+alumno.length);
        int alum = sc.nextInt();
        int suma = 0;
        int[] filanota = notas[alum-1];
        
        for (int nota : filanota) {
            suma += nota;
        }
        
        double media = (double) suma/ filanota.length;
        
        System.out.println("La media del alumno: "+alumno[alum-1]+" es de: "+media);
    }

    private static void medianotasactividad(int[][] notas, Scanner sc, String[] asignaturas) {
        System.out.println("Introduce el numero de la asignatura: 1-"+asignaturas.length);
        int asig = sc.nextInt();
        int suma = 0;
        int columnaasginatura = asig-1;
        
        for (int x = 0; x < notas.length; x++) {
            suma += notas[x][columnaasginatura];
        }
        
        
        double media = (double) suma/ notas.length;
        
        System.out.println("La media de notas de la asignatura: "+asignaturas[columnaasginatura]+" es de: "+media);
        
    }

    private static void mediadetodo(int[][] notas) {
        int suma = 0;
        int cont = 0;
        
        for (int x = 0; x < notas.length; x++) {
            for (int i = 0; i < notas[x].length; i++) {
                suma += notas[x][i];
                cont++;
         }
    }
        double media = (double) suma / cont;
        System.out.println("La media es:"+media);
    
}
}
