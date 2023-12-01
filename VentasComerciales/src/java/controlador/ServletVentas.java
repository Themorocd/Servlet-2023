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
public class ServletVentas extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String comercial = request.getParameter("comercial");
        String producto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");
        
        
        boolean insertoDatos = BBDD.BD.insertoDatos(comercial,producto,cantidad,fecha);
        
        if(insertoDatos){
            
            request.getRequestDispatcher("Nuevaventa.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        
    }

    

}
