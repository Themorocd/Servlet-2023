/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Disco;

/**
 *
 * @author moro-
 */
public class actualizar extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        ArrayList<Disco> listacompra = (ArrayList<Disco>) sesion.getAttribute("listacompra");
        
        if(listacompra != null){
            ArrayList<Disco> eliminolista = new ArrayList<>();
            for (Disco disco : listacompra) {
                String cantidadStr = request.getParameter("id_"+disco.getIddisco());
                int cantidad = Integer.parseInt(cantidadStr);
                
                if(cantidad == 0){
                    eliminolista.add(disco);
                }else{
                    disco.setCantdestacados(cantidad);
                }
                
            }
            listacompra.removeAll(eliminolista);
        }
        sesion.setAttribute("listacompra", listacompra);
        getServletContext().getRequestDispatcher("/Cesta.jsp").forward(request, response);
        
    }


}
