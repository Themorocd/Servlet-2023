/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

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
public class alta extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String user = request.getParameter("Nuser");
        String pass = request.getParameter("pasw");
        String dire = request.getParameter("dire");
        String tel = request.getParameter("tele");
        String gmail = request.getParameter("gmail");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        boolean altacorrecta = BBDD.BD.doyalta(user,pass,dire,tel,gmail,nombre,apellido);

        if (altacorrecta) {
            rd = contexto.getRequestDispatcher("/AltaCorrecta.html");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/ErrorAlta.html");
            rd.forward(request, response);
        }
    }

  

}
