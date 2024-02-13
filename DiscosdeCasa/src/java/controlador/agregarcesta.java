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
public class agregarcesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        int iddisco = Integer.parseInt(request.getParameter("idddisco"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        ArrayList<Disco> listacompra = (ArrayList<Disco>) sesion.getAttribute("listacompra");
        
        Disco dis;
        
        String sql = "Select * from disco where iddisco ='"+iddisco+"'";
        
        if(listacompra == null){            
            listacompra = new ArrayList<Disco>();
            dis = BBDD.BD.buscodisco(sql,cantidad);
            listacompra.add(dis);            
        }else{
            dis = BBDD.BD.buscodisco(sql, cantidad);
            boolean discoexiste = false;
            for (Disco disco : listacompra) {
                if(disco.getIddisco() == iddisco){
                    int cantilista = disco.getCantdestacados();
                    cantilista += cantidad;
                    disco.setCantdestacados(cantilista);
                    discoexiste = true;
                    break;
                }
            }
            if(!discoexiste){
                listacompra.add(dis);
            }
        }
        sesion.setAttribute("listacompra", listacompra);
        getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);
    }



}
