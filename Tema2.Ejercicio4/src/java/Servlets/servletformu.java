/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class servletformu extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String name = request.getParameter("name");
        String lugar = request.getParameter("lugar");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String destino = request.getParameter("destino");
        String usuario = (String) getServletContext().getAttribute("user");
        String[] actividad = request.getParameterValues("actividad");
        String curso = request.getParameter("curso");
        String profe = request.getParameter("profe");
        String texto = request.getParameter("texto");
        
        if(actividad == null){
            rd = request.getRequestDispatcher("/Formulario.jsp");
            rd.forward(request, response);
        }else{
        Actividades actividades = new Actividades(name,lugar,fecha,hora,destino,curso,actividad,profe,texto,usuario);
         
        ArrayList<Actividades> act = (ArrayList<Actividades>) contexto.getAttribute("act");
        
        if(act == null){
            act = new ArrayList<>();
        }
        
        act.add(actividades);
        
        contexto.setAttribute("act", act);
        
        contexto.setAttribute("name", name);
        contexto.setAttribute("lugar", lugar);
        contexto.setAttribute("fecha", fecha);
        contexto.setAttribute("hora", hora);
        contexto.setAttribute("destino", destino);
        contexto.setAttribute("actividad", actividad);
        contexto.setAttribute("curso", curso);
        contexto.setAttribute("profe", profe);
        contexto.setAttribute("texto", texto);
        contexto.setAttribute("tipolista", "todo");
        
        rd = request.getRequestDispatcher("/Formulario.jsp");
        rd.forward(request, response);
        }
    }

   
    

}
