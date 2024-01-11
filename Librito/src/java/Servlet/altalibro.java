/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.libro;

/**
 *
 * @author Andres
 */
public class altalibro extends HttpServlet {

    
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ISBN = request.getParameter("ISBN");
        String Titulo = request.getParameter("Titulo");
        String Autor = request.getParameter("sel");
        String Editorial = request.getParameter("sel1");
        String fecha = request.getParameter("fecha");
        String Descripcion = request.getParameter("Descripcion");
        
        
        
        libro lib = new libro(ISBN,Titulo,Autor,Editorial,fecha,Descripcion);
        boolean conecta = BBDD.BD.insertarlibro(lib);
        
        if(conecta){
            request.getRequestDispatcher("confiralta.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("altalibro.jsp").forward(request, response);
        }
        //String sql = "SELECT * FROM usuario WHERE usuario='"+Usuario+"' AND password='"+clave+"'";
        //String sql ="Update libros SET Titulo='"+Titulo+"',IDautor='"+Autor+"',AnioEdition='"+fecha+"',Descripcion='"+Descripcion+"',IDeditorial='"+Editorial+"' WHERE ISBN='"+ISBN+"'";
        
        
    }
    
    

}
