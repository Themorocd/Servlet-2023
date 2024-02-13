/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class agregarcesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        int cantdestacados = Integer.parseInt(request.getParameter("cantidad"));

        ArrayList<Libros> listacompra = (ArrayList<Libros>) sesion.getAttribute("listacompra");
        Libros libro;

        String sql = "Select * from libros where Idlibro='" + idlibro + "'";

        if (listacompra == null) {

            listacompra = new ArrayList<Libros>();
            libro = BBDD.BD.buscolibro(sql, cantdestacados);
            listacompra.add(libro);

        } else {
            libro = BBDD.BD.buscolibro(sql, cantdestacados);

            boolean libroExiste = false;

            for (Libros libros : listacompra) {
                if (libros.getIdlibro() == idlibro) {

                    listacompra.remove(libros);

                    int cantilista = libros.getCantdestacados();
                    cantilista += cantdestacados;
                    libros.setCantdestacados(cantilista);

                    libroExiste = true;
                    break;
                }

            }

            if (!libroExiste) {
                listacompra.add(libro);
            }

        }
        sesion.setAttribute("listacompra", listacompra);

        // Redirigimos la solicitud a la página confirmarañadidos.jsp
        getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);

    }

}
