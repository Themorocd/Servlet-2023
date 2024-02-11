/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuarios;

/**
 *
 * @author Andres
 */
public class inicio extends HttpServlet {

    @Override
// Método que maneja las peticiones POST en un servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos el contexto del servlet
        ServletContext contexto = getServletContext();

        // Objeto para despachar la solicitud a otras partes del servidor
        RequestDispatcher rd;

        // Obtenemos los parámetros 'user' y 'pass' de la solicitud HTTP
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        // Construimos una consulta SQL para buscar un usuario en la base de datos
        String sql = "SELECT * FROM usuarios WHERE User_email ='" + user + "' OR User_phone ='" + user + "' AND User_password ='" + pass + "'";

        // Llamamos a un método de la clase BD (Base de Datos) que verifica la existencia del usuario
        ArrayList<usuarios> List = BBDD.BD.compruebauser(sql);

        // Verificamos si la lista de usuarios no está vacía
        if (!List.isEmpty()) {

            // Creamos una sesión para el usuario
            HttpSession sesion = request.getSession();

            // Obtenemos la fecha actual y la formateamos
            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            Date dateobj = calendar.getTime();
            String formateodate = dtf.format(dateobj);

            // Obtenemos la hora actual
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            String hora = dateFormat.format(date);

            // Guardamos la fecha y hora en la sesión
            sesion.setAttribute("fecha", formateodate);
            sesion.setAttribute("hora", hora);

            // Iteramos sobre la lista de usuarios y guardamos el nombre y apellido en la sesión
            for (usuarios object : List) {
                sesion.setAttribute("nombre", object.getNombre());
                sesion.setAttribute("apellido", object.getApellidos());
            }

            // Redirigimos la solicitud a la página de pedido.jsp
            rd = contexto.getRequestDispatcher("/pedido.jsp");
            rd.forward(request, response);

        } else {
            // Si la lista de usuarios está vacía, redirigimos la solicitud a la página de error.html
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }
    }

}
