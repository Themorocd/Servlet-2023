/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andres
 */
public class Actividades implements Comparable<Actividades>{
    
    String name,lugar,fecha,hora,destino,curso,profe,texto,usuario;
    String[] actividad;

    public Actividades() {
    }

    public Actividades(String name, String lugar, String fecha, String hora, String destino, String curso, String[] actividad, String profe, String texto, String usuario) {
        this.name = name;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.destino = destino;
        this.curso = curso;
        this.profe = profe;
        this.texto = texto;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfe() {
        return profe;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String[] getActividad() {
        return actividad;
    }

    public void setActividad(String[] actividad) {
        this.actividad = actividad;
    }

    @Override
    public int compareTo(Actividades otrafec) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date estafecha = formato.parse(this.getFecha());
            Date otrafecha = formato.parse(otrafec.getFecha());
            return estafecha.compareTo(otrafecha);
        }catch (ParseException e) {
             e.printStackTrace();
        }
        return 0;
        
    }

   
    
}
