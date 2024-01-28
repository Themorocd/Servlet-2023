/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author moro-
 */
public class pedidos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesion = request.getSession();
       String carne = request.getParameter("carne");
       String cantcarne = request.getParameter("cantcarne");
       String queso = request.getParameter("queso");
       String cantqueso = request.getParameter("cantqueso");
       String clasi = request.getParameter("clasi");
       String cantclasi = request.getParameter("cantclasi");
       String infantil = request.getParameter("infantil");
       String cantinfantil = request.getParameter("cantinfantil");
       String gluten = request.getParameter("gluten");
       String cantgluten = request.getParameter("cantgluten");
       
       
       
       sesion.setAttribute("carne", carne);
       sesion.setAttribute("cantcarne", cantcarne);
       sesion.setAttribute("queso", queso);
       sesion.setAttribute("cantqueso", cantqueso);
       sesion.setAttribute("clasi", clasi);
       sesion.setAttribute("cantclasi", cantclasi);
       sesion.setAttribute("infantil", infantil);
       sesion.setAttribute("cantinfantil", cantinfantil);
       sesion.setAttribute("gluten", gluten);
       sesion.setAttribute("cantgluten", cantgluten);
       
       getServletContext().getRequestDispatcher("/zona_localizacion.jsp").forward(request, response);
       
       
    }

   

}
