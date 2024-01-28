/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.pelicula;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moro-
 */
public class Servlemodifinal extends HttpServlet {

 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pelicula peli = (pelicula) getServletContext().getAttribute("peli");
        
        ServletContext contex = getServletContext();
        RequestDispatcher rd;
        
        String pel = request.getParameter("pel");
        String fecha = request.getParameter("fecha");
        
        peli = new pelicula (peli.getId(),peli.getPeli(),peli.getDire(),peli.getFecha());
        int modi = BBDD.BD.modipeli(peli.getId(),pel,peli.getDire(),fecha);
        
        if(modi!=0){
            request.getRequestDispatcher("ModificarCorrecto.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("errormodi.jsp").forward(request, response);
        }
        
    }


}
