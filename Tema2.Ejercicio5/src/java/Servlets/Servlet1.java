/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

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
 * @author Andres
 */
public class Servlet1 extends HttpServlet {

    
    

 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("pass");
        
        compruebadni(usuario);
        
        
        if(contraseña.equals("trebujena") && compruebadni(usuario) == true){
            
            rd = request.getRequestDispatcher("Formulario.jsp");
            rd.forward(request, response);
            
        }else{
            rd = request.getRequestDispatcher("ErrorDni.html");
            rd.forward(request, response);
        }
        
    }

    private boolean compruebadni(String usuario) {
        boolean correcto = false;
        if(usuario !=null){
            char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
            
            usuario = usuario.toUpperCase();
            
            int num = Integer.parseInt(usuario.substring(0,8));
            
            char letradni = usuario.charAt(8);
            
            if(letradni == letras[num%23]){
                return true;
            }else{
                return false;
            }
            
        }else{
            return false;
        }
        
        
    }

    
 

}
