/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class ServletEncuesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String[] Variable1 = new String[7];
        String[] Variable2 = new String[7];
        
        Variable1 [0] = (String) getServletContext().getAttribute("nombre");
        Variable2 [0] = "nombre";
        Variable1 [1] = (String) getServletContext().getAttribute("apellido");
        Variable2 [1] = "apellido";
        Variable1 [2] = (String) getServletContext().getAttribute("telefono");
        Variable2 [2] = "telefono";
        Variable1 [3] = (String) getServletContext().getAttribute("nacimiento");
        Variable2 [3] = "nacimiento";
        Variable1 [4] = (String) getServletContext().getAttribute("genero");
        Variable2 [4] = "genero";
        Variable1 [5] = (String) getServletContext().getAttribute("origen");
        Variable2 [5] = "origen";
        String[] actividad = (String[]) getServletContext().getAttribute("ocio");
        Variable1 [6] = (String) getServletContext().getAttribute("comentario");
        Variable2 [6] = "comentario";
        
        if(Variable1[4].equals("masculino")){
            out.println("<html>");
            out.println("<head><title>DATOS</title></head>");
            out.println("<body style=\"background-color: cyan\">");
            out.println("<h1>DATOS DE LA ENCUESTA</h1>");
            out.println("<h1 style=\"color:red\">Hola " + Variable1[0] + "</h1>");
            out.println("<table border=\"5\">");
            for (int i = 0; i < Variable1.length; i++) {

                out.println("<tr>");
                out.println("<td>" + Variable2[i] + "</td>");
                out.println("<td>" + Variable1[i] + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            
            
                
            
            out.println("<p style=\"margin-top:20px\">"+Variable1[0].toUpperCase() + ",tus actividades de ocio preferidas son:</p>");

            out.println("<table border=\"5\">");
            if (actividad!=null) {
            for (int i = 0; i < actividad.length; i++) {

                out.println("<tr>");
                out.println("<td>" + actividad[i] + "</td>");
                out.println("</tr>");
            }
            }
            out.println("</table>");
            
            
            
            out.println("<a href=\"masculino.html\">Sorpresa</a>");

            out.println("</body>");
            out.println("</html>");

        }else{
            out.println("<html>");
            out.println("<head><title>DATOS</title></head>");
            out.println("<body style=\"background-color: pink\">");
            out.println("<h1>DATOS DE LA ENCUESTA</h1>");
            out.println("<h1 style=\"color:red\">Hola " + Variable1[0] + "</h1>");
            out.println("<table border=\"5\">");
            for (int x = 0; x < Variable1.length; x++) {

                out.println("<tr>");
                out.println("<td>" + Variable2[x] + "</td>");
                out.println("<td>" + Variable1[x] + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<p style=\"margin-top:20px\">"+Variable1[0].toUpperCase() + ",tus actividades de ocio preferidas son:</p>");

            out.println("<table border=\"5\">");
            if (actividad!=null) {
            for (int x = 0; x < actividad.length; x++) {

                out.println("<tr>");
                out.println("<td>" + actividad[x] + "</td>");
                out.println("</tr>");
            }
            }

            out.println("</table>");
            
            
            
            out.println("<a href=\"femenino.html\">Sorpresa</a>");

            out.println("</body>");
            out.println("</html>");
        }
            
            
        

    }

}
