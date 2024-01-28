/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import BBDD.BD;
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
public class ServletInicio extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        boolean compruebouser = BBDD.BD.compruebousario(user,pass);
        
        if(!user.isEmpty() && !pass.isEmpty()){
            if(compruebouser){
                request.getRequestDispatcher("Gestion.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("Errorusuario.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Errorvacio.jsp").forward(request, response);
        }
        
    }

    

}
