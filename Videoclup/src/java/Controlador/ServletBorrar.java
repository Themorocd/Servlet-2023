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

/**
 *
 * @author moro-
 */
public class ServletBorrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        String sql = "DELETE FROM peliculas where id='"+id+"'";
        
        int elimina = BBDD.BD.deletepeli(sql);
        
        if(elimina!=0){
            request.getRequestDispatcher("borradocorrecto.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("errorborrar.jsp").forward(request, response);
        }
        
    }

  

}
