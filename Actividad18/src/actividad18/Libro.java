/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad18;

/**
 *
 * @author Andres
 */
class Libro {
    
    String nombre;
    int paginas,subtitulos,img;
    char nacionalidad,tapa;
    String formato;
    double tinta;
    public Libro() {
    }

    public Libro(String nombre, int paginas, int subtitulos, int img, char nacionalidad, char tapa, String formato, double tinta) {
        this.nombre = nombre;
        this.paginas = paginas;
        this.subtitulos = subtitulos;
        this.img = img;
        this.nacionalidad = nacionalidad;
        this.tapa = tapa;
        this.formato = formato;
        this.tinta = tinta;
    }

  
    
    
    public void monstrarLibro(){
        System.out.println("Nombre del libro: "+nombre);
        System.out.println("Analisis del libro");
        System.out.println("-Paginas: "+paginas);
        System.out.println("-Subtitulos: "+subtitulos);
        System.out.println("-Imagenes: "+img);
        System.out.println("Tipo de tapa: "+tapa);
        System.out.println("Tipo de formato: "+formato);
        System.out.println(librorecomendable());
        System.out.println(librovistoso());
        System.out.println("Nacionalidad del autor: "+nacionalidad);
        System.out.println("Precio en tinta es de "+preciotinta());
    }

    public String librovistoso() {
         if ((paginas > 120) && (formato == "me" && formato == "ME")){
             return "No es un libro vistoso";
         }else{
             return "Es un libro vistoso";
         }
        
    }

    public String librorecomendable() {
        
        if((paginas >=160 && paginas <=430) && (subtitulos >=6 && subtitulos <= 15) && (img >= 15 && img <=24)){
            
            return "El libro es recomendable";
            
        } else{
            return "El libro no es recomendable";
        }
        
        
    }

    public double preciotinta() {
        
       double preciototal = (paginas*0.05) + (subtitulos*0.01) + (img*0.07);
        
        return preciototal;
    }
    
}
