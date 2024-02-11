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
public class agregarcesta extends HttpServlet {

    @Override
    // Método que maneja las peticiones POST en un servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos la sesión actual o creamos una nueva si no existe
        HttpSession sesion = request.getSession();

        // Obtenemos los parámetros 'destacados' y 'cantdestacados' de la solicitud HTTP y convertimos a entero
        int destacados = Integer.parseInt(request.getParameter("destacados"));
        int cantdestacados = Integer.parseInt(request.getParameter("cantdestacados"));

        // Obtenemos la lista de libros de la sesión
        ArrayList<Libros> listacompra = (ArrayList<Libros>) sesion.getAttribute("listacompra");
        Libros libro;

        // Construimos una consulta SQL para buscar un libro en la base de datos por su ID
        String sql = "Select * from libros where Idlibro='" + destacados + "'";

        // Verificamos si la lista de libros de compra es nula (no existe)
        if (listacompra == null) {
            // Creamos una nueva lista de libros
            listacompra = new ArrayList<Libros>();

            // Buscamos el libro en la base de datos y lo añadimos a la lista
            libro = BBDD.BD.buscolibro(sql, cantdestacados);
            listacompra.add(libro);
        } else {
            // Si la lista ya existe, buscamos el libro en la base de datos
            libro = BBDD.BD.buscolibro(sql, cantdestacados);

            // Verificamos si el libro ya está en la lista
            boolean libroExistente = false;

            for (Libros libros : listacompra) {
                if (libros.getIdlibro() == destacados) {
                    // Si el libro ya está en la lista, actualizamos la cantidad
                    int cantilista = libros.getCantdestacados();
                    cantilista += cantdestacados;
                    libros.setCantdestacados(cantilista);
                    libroExistente = true;
                    break;
                }
            }

            // Si el libro no está en la lista, lo añadimos
            if (!libroExistente) {
                listacompra.add(libro);
            }
        }

        // Guardamos la lista de libros en la sesión
        sesion.setAttribute("listacompra", listacompra);

        // Redirigimos la solicitud a la página confirmarañadidos.jsp
        getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);
    }

}
