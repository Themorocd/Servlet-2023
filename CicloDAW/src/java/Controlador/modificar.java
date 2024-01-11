package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.alumnos;

/**
 *
 * @author moro-
 */
public class modificar extends HttpServlet {

   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context= getServletContext();
       RequestDispatcher rd;
       
       
       String nombre= request.getParameter("nombre");
       String apellidos= request.getParameter("apellidos");
       
       alumnos alu = BBDD.BD.consultalistalumnos(nombre,apellidos);
       
       if (alu!=null) {
            
            context.setAttribute("alu", alu);
            rd=request.getRequestDispatcher("modificar.jsp");
            rd.forward(request, response);
            
        } else {
            rd=request.getRequestDispatcher("Gestion.jsp");
            rd.forward(request, response);
        }
    }

    
}
