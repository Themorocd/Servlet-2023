/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author moro-
 */
public class pelicula {
    
    String id,peli,dire,fecha;

    
    public pelicula(String id, String peli, String dire, String fecha) {
        this.id = id;
        this.peli = peli;
        this.dire = dire;
        this.fecha = fecha;
    }
    
    public pelicula(String peli, String dire, String fecha) {
    
        this.peli=peli;
        this.dire=dire;
        this.fecha=fecha;
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPeli() {
        return peli;
    }

    public void setPeli(String peli) {
        this.peli = peli;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
