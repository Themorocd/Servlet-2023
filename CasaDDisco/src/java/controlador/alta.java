/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

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
public class alta extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("Apellidos");
        String tel = request.getParameter("telefono");
        String email = request.getParameter("email");
        String user = request.getParameter("nombreUsuario");
        String pass = request.getParameter("pass");
        
        String sql ="INSERT INTO usuarios (User_name,User_password,User_email,User_phone,Nombre,Apellidos) values ('"+user+"','"+pass+"','"+email+"','"+tel+"','"+nombre+"','"+apellido+"')";
        
        BBDD.BD.altauser(sql);
        
        rd = contexto.getRequestDispatcher("/index.html");
        rd.forward(request, response);
        
        
    }


}
