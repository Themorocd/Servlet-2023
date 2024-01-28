/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.pelicula;
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
 * @author moro-
 */
public class ServleModificar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contex = getServletContext();
        RequestDispatcher rd;

        String id = request.getParameter("id");
        String sql = "SELECT peliculas.titulo AS titulo, director.nombre AS director, peliculas.fecha_estreno FROM peliculas JOIN director ON peliculas.director = director.id WHERE peliculas.id='" + id + "'";
        
       

        pelicula peli = BBDD.BD.consultapeli(sql);

        contex.setAttribute("peli", peli);
        rd = request.getRequestDispatcher("modificarpelicula.jsp");
        rd.forward(request, response);

    }

}
