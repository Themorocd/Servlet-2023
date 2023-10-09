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
    private String nombre;
    private double Lipidos;
    private double Hidratos;
    private double Proteinas;
    private boolean Animal;
    private String MineralesVitaminas;

    public Alimento() {
    }

    public Alimento(String nombre, double Lipidos, double Hidratos, double Proteinas, boolean Animal, String MineralesVitaminas) {
        this.nombre = nombre;
        this.Lipidos = Lipidos;
        this.Hidratos = Hidratos;
        this.Proteinas = Proteinas;
        this.Animal = Animal;
        this.MineralesVitaminas = MineralesVitaminas;
    }
    
}
