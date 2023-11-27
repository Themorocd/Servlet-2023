/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
        
        
        String venta = request.getParameter("venta");
        String cantidad = request.getParameter("cantidad");
        
        
        double precio = Double.parseDouble(venta);
        double entregado = Double.parseDouble(cantidad);
        
        if(cantidad != null && venta != null){           
                if(entregado >  precio){
                    double cambio = entregado - precio;
                    
                    contexto.setAttribute("precio", precio);
                    contexto.setAttribute("entregado", entregado);
                    contexto.setAttribute("cambio", cambio);
                    rd = request.getRequestDispatcher("Resultado.jsp");
                    rd.forward(request, response);
                }else{
                    rd = request.getRequestDispatcher("Error.jsp");
                    rd.forward(request, response);
                }
            
        }else{
            rd = request.getRequestDispatcher("Error.jsp");
                    rd.forward(request, response);
        }
        
    }

   

}
