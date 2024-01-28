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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class zona_localizacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        HttpSession sesion = request.getSession();
        String menus = request.getParameter("menus");
        String sandwiches = request.getParameter("sandwiches");
        String complementos = request.getParameter("complementos");
        String ensaladas = request.getParameter("ensaladas");
        String bebidas = request.getParameter("bebidas");
        
        sesion.setAttribute("menus", menus);
        sesion.setAttribute("sandwiches", sandwiches);
        sesion.setAttribute("complementos", complementos);
        sesion.setAttribute("ensaladas", ensaladas);
        sesion.setAttribute("bebidas", bebidas);

        getServletContext().getRequestDispatcher("/zona_localizacion.jsp").forward(request, response);
        
    }

}
