/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad19;

import java.util.Random;

/**
 *
 * @author Andres
 */
class Informe {
    
    String nombre, metabolismo, vida;
    boolean esdeportista;
    int caldesayuno,calalmuerzo,calcena;

    public Informe() {
    }

    public Informe(String nombre, String metabolismo, String vida, boolean esdeportista, int caldesayuno, int calalmuerzo, int calcena) {
        this.nombre = nombre;
        this.metabolismo = metabolismo;
        this.vida = vida;
        this.esdeportista = esdeportista;
        this.caldesayuno = caldesayuno;
        this.calalmuerzo = calalmuerzo;
        this.calcena = calcena;
    }
     public int generarCaloriasAleatorias() {
        Random random = new Random();
        return random.nextInt(1001) + 500; // Genera un número aleatorio entre 500 y 1500
    }
    
    public boolean desayunosalud(){
        return (caldesayuno < 800 || (caldesayuno >= 801 && caldesayuno <= 1200 && !vida.equalsIgnoreCase("S")));
    }
     public boolean dietaSana(int totalCalorias) {
        if (totalCalorias < 2000) {
            return true;
        } else if ((totalCalorias > 2000 && totalCalorias < 3000) && !vida.equalsIgnoreCase("S")) {
            return true;
        } else {
            return (vida.equalsIgnoreCase("MA") && metabolismo.equalsIgnoreCase("A"));
        }
    }
     
       public double gastoAlimento(int totalCalorias) {
        return totalCalorias / 500; // Considerando que 1 cal equivale a 500 centimos de euro
    }
        public void mostrarInforme(int totalCalorias) {
        System.out.println("Es deportista y lleva una vida " + vida.toLowerCase() + ", además tiene un metabolismo " + metabolismo.toLowerCase() + ".");
        if (desayunosalud()) {
            System.out.println("Ha comido un saludable desayuno.");
        } else {
            System.out.println("No ha comido un saludable desayuno.");
        }

        if (dietaSana(totalCalorias)) {
            System.out.println("Lleva una dieta sana.");
        } else {
            System.out.println("No lleva una dieta sana.");
        }

        double gastoDiario = gastoAlimento(totalCalorias);
        System.out.println("Tiene un gasto de dieta diario de " + gastoDiario + " euros.");
    }
        
}
