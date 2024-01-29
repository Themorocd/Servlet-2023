/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo;

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
 * @author moro-
 */
public class Servletinicio extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        String sql = "Select * from usuarios where User_name ='"+user+"' and User_password='"+pass+"'";
        
        boolean compruebousuario = BBDD.BD.compruebauser(sql);
        
        
        if(compruebousuario){
            
            HttpSession sesion = request.getSession();
            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            
            Date dateobj = calendar.getTime();
            String formateoDate = dtf.format(dateobj);
            
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            
            String hora = dateFormat.format(date);
            
            sesion.setAttribute("fecha",formateoDate);
            sesion.setAttribute("hora", hora);
            
            sesion.setAttribute("user", user);
            
            
            rd = contexto.getRequestDispatcher("/pedido.jsp");
            rd.forward(request, response);
            
            
        } else{
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }
        
        
    }

   

}
