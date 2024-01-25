/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlado;

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
public class zona_localizacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String menus = request.getParameter("menus");
        String sandwiches = request.getParameter("sandwiches");
        String complementos = request.getParameter("complementos");
        String ensaladas = request.getParameter("ensaladas");
        String bebidas = request.getParameter("bebidas");
        
        contexto.setAttribute("menus", menus);
        contexto.setAttribute("sandwiches", sandwiches);
        contexto.setAttribute("complementos", complementos);
        contexto.setAttribute("ensaladas", ensaladas);
        contexto.setAttribute("bebidas", bebidas);

        rd = contexto.getRequestDispatcher("/zona_localizacion.jsp");
        rd.forward(request, response);
    }

}
