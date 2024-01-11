/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author moro-
 */
public class alumnos {
    private String nombre,apellidos;
   private String daw,dawec,dawes,diw;
   private String fct,proyecto;
   private String alumno;

    public alumnos(String nombre, String apellidos, String daw, String dawec, String dawes, String diw, String fct, String proyecto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.daw = daw;
        this.dawec = dawec;
        this.dawes = dawes;
        this.diw = diw;
        this.fct = fct;
        this.proyecto = proyecto;
    }

    public alumnos(String nombre, String apellidos, String dawes, String dawec, String diw, String daw, String fct, String proyecto, String alumno) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.daw = daw;
        this.dawec = dawec;
        this.dawes = dawes;
        this.diw = diw;
        this.fct = fct;
        this.proyecto = proyecto;
        this.alumno=alumno;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDaw() {
        return daw;
    }

    public void setDaw(String daw) {
        this.daw = daw;
    }

    public String getDawec() {
        return dawec;
    }

    public void setDawec(String dawec) {
        this.dawec = dawec;
    }

    public String getDawes() {
        return dawes;
    }

    public void setDawes(String dawes) {
        this.dawes = dawes;
    }

    public String getDiw() {
        return diw;
    }

    public void setDiw(String diw) {
        this.diw = diw;
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
