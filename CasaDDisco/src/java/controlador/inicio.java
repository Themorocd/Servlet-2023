/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * @author moro-
 */
public class inicio extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        String sql ="Select * from usuarios where User_name='"+user+"' OR User_phone='"+user+"' AND User_password='"+pass+"'";
        
        ArrayList<usuarios> List = BBDD.BD.compruebauser(sql);
     
        if(!List.isEmpty()){
            
            HttpSession sesion = request.getSession();
            
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            sesion.setAttribute("fecha", formatofecha.format(new Date()));
            
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            sesion.setAttribute("hora", formatohora.format(new Date()));
            
            
            for (usuarios elem : List) {
                sesion.setAttribute("nombre", elem.getNombre());
                sesion.setAttribute("apellido", elem.getApellidos());
            }
            
            rd = contexto.getRequestDispatcher("/pedido.jsp");
            rd.forward(request, response);
            
            
        }else{
              rd = contexto.getRequestDispatcher("/error.html");
              rd.forward(request, response);
        }
        
    }


}
