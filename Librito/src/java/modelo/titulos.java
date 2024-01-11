/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Andres
 */
public class titulos {
    String isbn;
    String titulo;
    String idautor;
    String año;
    String descripcion;
    String ideditorial;

    public titulos(String isbn, String titulo, String idautor, String año, String descripcion, String ideditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.idautor = idautor;
        this.año = año;
        this.descripcion = descripcion;
        this.ideditorial = ideditorial;
    }

    public titulos(String isbn, String titulo, String idautor,String descripcion, String ideditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.idautor = idautor;
        this.descripcion = descripcion;
        this.ideditorial = ideditorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdautor() {
        return idautor;
    }

    public void setIdautor(String idautor) {
        this.idautor = idautor;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(String ideditorial) {
        this.ideditorial = ideditorial;
    }
    
}
