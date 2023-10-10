/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad17;

/**
 *
 * @author Andres
 */
class Alumno {
    String nombre;
    char comportamiento;
    double deberes;
    double asistencia;
    double nota;
    double diffmedia;

    public Alumno() {
    }

    public Alumno(String nombre, char comportamiento, double deberes, double asistencia, double nota, double diffmedia) {
        this.nombre = nombre;
        this.comportamiento = comportamiento;
        this.deberes = deberes;
        this.asistencia = asistencia;
        this.nota = nota;
        this.diffmedia = diffmedia;
    }

   
    public String actitud(){
        String actitudcalse = null;
        if(comportamiento =='B' && comportamiento =='b'){
            if(asistencia > 90){
                actitudcalse = "excelente";
            } else if (asistencia >=80 && asistencia <=90){
                actitudcalse = "buena";
                
            } else{
                actitudcalse="mala";
            }
                
        } else if(comportamiento =='M' && comportamiento =='m'){
            actitudcalse = "mala";
        }else{
            actitudcalse="Comportamiento no definido";
        }
        return actitudcalse;
    }
    
    public String deberes(){
        String resultadosdeberes = null;
        
        if(deberes > 90 && nota > 7){
            resultadosdeberes = "Muy bueno";
        } else if ((deberes >= 70 && deberes <= 89) || (nota >= 6 && nota <= 6.99)) {
            resultadosdeberes = "Bueno";
            
        } else{
            resultadosdeberes = "Malo";
        }
        
        return resultadosdeberes;
    }
    
    public String asistencia(){
        String asis = null;
        if(asistencia >= 100){
            asis = "total";
        }else if(asistencia > 95){
            asis = "muy alta";
        }else if(asistencia >= 85 && asistencia <= 94){
            asis = "alta";
        }else{
            asis = "baja";
        }

        return asis;
    }
    
    
    public void mostrarinformeDeClase(){
        System.out.println("Nombre del Alumno: " + nombre);
        System.out.println("Los deberes enviados para casa han tenido un resultado " + deberes());
        System.out.println("Tiene una " + asistencia()+ " asistencia a clase");
        System.out.println("Tiene una nota media de: "+nota);
        System.out.println("Esta a "+diffmedia+ " puntos de diferencia de la media de clase");
    }
}
