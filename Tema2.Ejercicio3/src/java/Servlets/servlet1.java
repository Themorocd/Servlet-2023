/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

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
public class servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String Fnacimiento = request.getParameter("nacimiento");
        String genero = request.getParameter("genero");
        String origen = request.getParameter("origen");
        String[] ocio = request.getParameterValues("ocio");
        String comentario = request.getParameter("texto");

        contexto.setAttribute("nombre", nombre);
        contexto.setAttribute("apellido", apellido);
        contexto.setAttribute("telefono", telefono);
        contexto.setAttribute("nacimiento", Fnacimiento);
        contexto.setAttribute("genero", genero);
        contexto.setAttribute("origen", origen);
        contexto.setAttribute("ocio", ocio);
        contexto.setAttribute("comentario", comentario);
        rd = contexto.getRequestDispatcher("/ServletEncuesta");
        rd.forward(request, response);

    }

}


