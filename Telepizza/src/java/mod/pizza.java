/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod;

/**
 *
 * @author moro-
 */
public class pizza {
    
    String id,nombre,idpizza;
    double precio;

    public pizza(String id, String nombre, String idpizza, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.idpizza = idpizza;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdpizza() {
        return idpizza;
    }

    public void setIdpizza(String idpizza) {
        this.idpizza = idpizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
}
