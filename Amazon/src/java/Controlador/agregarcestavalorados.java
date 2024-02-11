/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Libros;

/**
 *
 * @author Andres
 */
public class agregarcestavalorados extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        int valorados =Integer.parseInt(request.getParameter("valorados"));
        //String cantdestacados = request.getParameter("cantvalorados");
        int cantdestacados =Integer.parseInt(request.getParameter("cantvalorados"));
        
        ArrayList<Libros> listacompra = (ArrayList<Libros>) sesion.getAttribute("listacompra");
        Libros libro;
        String sql = "Select * from libros where Idlibro='"+valorados+"'";
              
         if (listacompra == null) {
            listacompra = new ArrayList<Libros>();
            libro = BBDD.BD.buscolibro(sql, cantdestacados);
            listacompra.add(libro);
        } else {
            libro = BBDD.BD.buscolibro(sql, cantdestacados);

            boolean libroExistente = false;

            for (Libros libros : listacompra) {
                if (libros.getIdlibro() == valorados) {
                    int cantilista = libros.getCantdestacados();
                    cantilista += cantdestacados;
                    libros.setCantdestacados(cantilista);
                    libroExistente = true;
                    break;
                }
            }

            if (!libroExistente) {
                listacompra.add(libro);
            }
        }
         sesion.setAttribute("listacompra", listacompra);
         //sesion.setAttribute("cantdestacados", cantdestacados);
         getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);
       
    }

}
