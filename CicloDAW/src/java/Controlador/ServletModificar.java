/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.alumnos;

/**
 *
 * @author moro-
 */
public class ServletModificar extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String nombre= request.getParameter("name");
        String apellidos= request.getParameter("apellido");
        String dawes= request.getParameter("dawes");
        String dawec= request.getParameter("dawec");
        String diw= request.getParameter("diw");
        String daw=request.getParameter("daw");
        String fct=request.getParameter("fct");
        String proyecto=request.getParameter("proyecto");
        
        alumnos alu = new alumnos(nombre, apellidos, dawes, dawec, diw, daw, fct, proyecto, "ALUMNO");
        
        int valor=BBDD.BD.modificarUsuario(alu);
        
        if (valor==1) {
            
           rd=request.getRequestDispatcher("Gestion.jsp");
           rd.forward(request, response);
            
        } else {
            rd=request.getRequestDispatcher("modificar.jsp");
           rd.forward(request, response);
        }
        
    }

   

}
