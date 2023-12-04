/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

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
 * @author Andres
 */
public class ServletComerciales extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String Codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String sueldo = request.getParameter("sueldo");
        String fecha = request.getParameter("fecha");
        String hijos = request.getParameter("hijos");
        
        
        boolean insertarComerciales = BBDD.BD.insertarComerciales(Codigo,nombre,sueldo,fecha,hijos);
        
        if(insertarComerciales){
            request.getRequestDispatcher("NuevoComercial.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
    }

}
