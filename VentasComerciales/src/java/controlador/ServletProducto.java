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
public class ServletProducto extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String referencia = request.getParameter("referencia");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("texto");
        String precio = request.getParameter("precio");
        String descuento = request.getParameter("descuento");
        
        
        boolean insertarProducto = BBDD.BD.insertarProductos(referencia,nombre,descripcion,precio,descuento);
        
        if(insertarProducto){
            request.getRequestDispatcher("NuevoProdcuto.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
    }

  

}
