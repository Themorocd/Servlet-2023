/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author moro-
 */
public class envio extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        String opcion = request.getParameter("name");
        
        
        if(opcion != null){
            if(opcion.contains("domi")){
                getServletContext().getRequestDispatcher("/confirmotelefonodomi.jsp").forward(request, response);
            }else if(opcion.contains("tienda")){
                getServletContext().getRequestDispatcher("/confirmotelefonotienda.jsp").forward(request, response);
            }
        }else{
           getServletContext().getRequestDispatcher("/zona_localizacion.jsp").forward(request, response); 
        }
    }

    

}
