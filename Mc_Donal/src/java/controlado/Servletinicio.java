/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlado;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Andres
 */
public class Servletinicio extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        
        String nombre = request.getParameter("name");
        String pass = request.getParameter("pass");
        
        if(nombre.equals("andres")&& pass.equals("1234")){
            
            HttpSession sesion = request.getSession();
            
            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            
            Date dateobj = calendar.getTime();
            String formattedDate = dtf.format(dateobj);
            
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            
            String hora = dateFormat.format(date);
            
            sesion.setAttribute("fecha", formattedDate);
            sesion.setAttribute("hora", hora);
            
            sesion.setAttribute("nombre", nombre);
            
            rd = contexto.getRequestDispatcher("/zona_pedido.jsp");
            rd.forward(request, response);
            
            
        }else{
            contexto.setAttribute("error", "Usuario o contraseña incorrecto");
            rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            
        }
        
    }

   

}
