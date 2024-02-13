/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Libros;
import Modelo.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class Enviodatos extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sesion = request.getSession();
        
        String nombreUsuario = (String) sesion.getAttribute("nombre");
        String fecha = (String) sesion.getAttribute("fecha");
        double total = (double) sesion.getAttribute("total");
        
        ArrayList<Libros> listacompra;
        
        listacompra = (ArrayList<Libros>) sesion.getAttribute("listacompra");
        
        String sql = "Select * from usuarios where Nombre='"+nombreUsuario+"'";
        
        ArrayList<usuarios> List = BBDD.BD.compruebauser(sql);
        
        int id = 0;
        
        for (usuarios elem : List) {
            id = Integer.parseInt(elem.getId());
            
        }
        
        String sql1 = "INSERT INTO pedidos (idCliente, fecha) VALUES ('" + id + "', '" + fecha + "')";
        
        BBDD.BD.altapedido(sql1);
        
        String sql2 = "Select Max(IdPedido) from pedidos";
        
        int idpedido = BBDD.BD.consultaidpedido(sql2);
        
        int idlibro = 0;
        int cantidad = 0;
        double preciounidad = 0;
        
        for(Libros elem : listacompra){
            idlibro = elem.getIdlibro();
            cantidad = elem.getCantdestacados();
            preciounidad = elem.getPrecio();
            BBDD.BD.altadetallepedidos(idpedido,idlibro,cantidad,preciounidad);
        }
        
        listacompra.clear();
        sesion.invalidate();
        getServletContext().getRequestDispatcher("/Confirmocompra.jsp").forward(request, response);
        
        
    }

  

}
