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
import modelo.libro;
import modelo.titulos;

/**
 *
 * @author Andres
 */
public class modlibro extends HttpServlet {

    
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       titulos titus= (titulos) getServletContext().getAttribute("titu");//es como la sessiones
       ServletContext contex = getServletContext();
       RequestDispatcher rd;
       String Titulo = request.getParameter("Titulo");
       String Autor = request.getParameter("sel");
       String Editorial = request.getParameter("sel1");
       String fecha = request.getParameter("fecha");
       String Descripcion = request.getParameter("Descripcion");
       
       libro lib = new libro(titus.getIsbn(),titus.getTitulo(),titus.getIdautor(),titus.getIdeditorial(),titus.getAño(),titus.getDescripcion());
       int modi = BBDD.BD.modilib(lib.getTitulo(),Titulo,Autor,Editorial,fecha,Descripcion);
       
       if(modi!=0){
           request.getRequestDispatcher("Modiftrue.jsp").forward(request, response);
       }else{
           request.getRequestDispatcher("modilibro.jsp").forward(request, response);
       }
    }

    
}
