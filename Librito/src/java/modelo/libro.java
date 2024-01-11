/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Andres
 */
public class libro {
     String ISBN;
    String Titulo;
    String Autor;
    String  Editorial;
    String fecha;
    String Descripcion;

    public libro(String ISBN, String Titulo, String Autor, String Editorial, String fecha, String Descripcion) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.fecha = fecha;
        this.Descripcion = Descripcion;
    }

    public libro(String Titulo, String Autor, String Editorial, String fecha, String Descripcion) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.fecha = fecha;
        this.Descripcion = Descripcion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
