/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Libros;
import modelo.usuarios;

/**
 *
 * @author moro-
 */
public class Enviodatos extends HttpServlet {

    @Override
    // Método que maneja las peticiones POST en un servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos la sesión actual
        HttpSession sesion = request.getSession();

        // Obtenemos información relevante de la sesión
        String nombreUsuario = (String) sesion.getAttribute("nombre");
        String fecha = (String) sesion.getAttribute("fecha");
        double total = (double) sesion.getAttribute("total");

        // Obtenemos la lista de libros de la sesión
        ArrayList<Libros> listacompra;
        listacompra = (ArrayList<Libros>) sesion.getAttribute("listacompra");

        // Construimos una consulta SQL para buscar al usuario por su nombre
        String sql = "SELECT * FROM usuarios where Nombre='" + nombreUsuario + "'";

        // Obtenemos la lista de usuarios que coinciden con la consulta
        ArrayList<usuarios> List = BBDD.BD.compruebauser(sql);

        // Inicializamos el id del usuario
        int id = 0;

        // Iteramos sobre la lista de usuarios (debería contener solo un usuario)
        for (usuarios object : List) {
            // Convertimos el id de usuario a entero y lo almacenamos
            id = Integer.parseInt(object.getId());
            System.out.println(id);
        }

        // Construimos una consulta SQL para insertar un nuevo pedido en la base de datos
        String sql1 = "INSERT INTO pedidos (IdCliente, FechaPedido) VALUES ('" + id + "', '" + fecha + "')";

        // Realizamos la inserción del pedido en la base de datos
        BBDD.BD.altapedido(sql1);

        // Construimos una consulta SQL para obtener el id del pedido recién insertado
        String sql2 = "SELECT MAX(IdPedido) FROM pedidos";

        // Obtenemos el id del pedido utilizando el método de la base de datos
        int idpedido = BBDD.BD.consultaidpedido(sql2);

        // Variables para almacenar información del libro en el carrito
        int idlibro = 0;
        int cantidad = 0;
        double preciounidad = 0;

        // Iteramos sobre la lista de libros en el carrito y realizamos la inserción en la tabla de detalles de pedidos
        for (Libros elem : listacompra) {
            idlibro = elem.getIdlibro();
            cantidad = elem.getCantdestacados();
            preciounidad = elem.getPrecio();
            BBDD.BD.altadetallepedidos(idpedido, idlibro, cantidad, preciounidad);
        }

        // Limpiamos la lista de libros en el carrito
        listacompra.clear();

        // Redirigimos la solicitud a la página Confirmocompra.jsp
        getServletContext().getRequestDispatcher("/Confirmocompra.jsp").forward(request, response);
    }

}
