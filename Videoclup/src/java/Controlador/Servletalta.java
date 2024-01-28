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
public class Servletalta extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String peli = request.getParameter("peli");
        String dire = request.getParameter("id");
        String fecha = request.getParameter("fecha");
        
        pelicula pel = new pelicula(peli,dire,fecha);
        
        boolean correcto = BBDD.BD.alta(pel);
        
        if(correcto){
            request.getRequestDispatcher("altacorrecta.jsp").forward(request, response);
            contexto.setAttribute("peli", peli);
            
        }else{
            request.getRequestDispatcher("altaerronea.jsp").forward(request, response);
        }
        
    }

    

}
