/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class agregarcesta extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String destacados = request.getParameter("destacados");
        String cantdestacados = request.getParameter("cantdestacados");
        //String vendidos = request.getParameter("vendidos");
        //String cantvendidos = request.getParameter("cantvendidos");
        
        if(destacados!=null && cantdestacados!=null){
            
            sesion.setAttribute("destacados", destacados);
            sesion.setAttribute("cantdestacados", cantdestacados);
            getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/Destacados.jsp").forward(request, response);
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

    

}
