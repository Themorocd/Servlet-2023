/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad16;

/**
 *
 * @author Andres
 */
class Alimento {
    String nombre;
    double Lipidos;
    double Hidratos;
    double Proteinas;
    boolean Animal;
    char MineralesVitaminas;

    public Alimento() {
    }

    public Alimento(String nombre, double Lipidos, double Hidratos, double Proteinas, boolean Animal, char MineralesVitaminas) {
        this.nombre = nombre;
        this.Lipidos = Lipidos;
        this.Hidratos = Hidratos;
        this.Proteinas = Proteinas;
        this.Animal = Animal;
        this.MineralesVitaminas = MineralesVitaminas;                                                                                                                                                                                                                                                                                                   
    }
     public boolean esDietetico() {
        return (Lipidos < 20) && (MineralesVitaminas != 'B' && MineralesVitaminas != 'b');
    }

    public boolean recomendableParaDeportistas() {
        return (Proteinas >= 10 && Proteinas <= 15)
                && (Lipidos >= 30 && Lipidos <= 35)
                && (Hidratos >= 55 && Hidratos <= 65);
    }

    public double contenidoEnergetico() {
        double caloriasLipidos = Lipidos * 9.4;
        double caloriasProteinas = Proteinas * 5.3;
        double caloriasHidratos = Hidratos * 4.1;
        return caloriasLipidos + caloriasProteinas + caloriasHidratos;
    }

    public void mostrarAlimento() {
        System.out.println("Nombre del alimento: " + nombre);
        System.out.println("Contenido en lípidos (%): " + Lipidos);
        System.out.println("Contenido en hidratos de carbono (%): " + Hidratos);
        System.out.println("Contenido en proteínas (%): " + Proteinas);
        System.out.println("Es de origen animal: " + (Animal ? "Sí" : "No"));
        System.out.println("Contenido de minerales y vitaminas: " + MineralesVitaminas);
        System.out.println("Es dietético: " + (esDietetico() ? "Sí" : "No"));
        System.out.println("Recomendable para deportistas: " + (recomendableParaDeportistas() ? "Sí" : "No"));
        System.out.println("Contenido energético (kcal/g): " + contenidoEnergetico());
    }
}
