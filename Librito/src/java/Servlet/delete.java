/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.titulos;

/**
 *
 * @author Andres
 */
public class delete extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contex = getServletContext();
       RequestDispatcher rd;
       
       String id = request.getParameter("sel");
        String sql="SELECT * FROM titulos WHERE Titulo='"+id+"'";
        
        titulos titu = BBDD.BD.consultatitul(sql);
        
        sql="DELETE FROM titulos where Titulo='"+id+"'";
        
        int elimina = BBDD.BD.deletelibro(sql);
        
        if(elimina!=0){
           request.getRequestDispatcher("deletetrue.jsp").forward(request, response);
       }else{
           request.getRequestDispatcher("borrolibro.jsp").forward(request, response);
       }
    }

    

}
