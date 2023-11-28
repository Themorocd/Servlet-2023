/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Vista.Libros;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class bbdd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "books";

    public static Connection CrearConexion() {

        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JBDC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otra excepcion" + c.toString());
        }
        return cnn;
    }

    public static ArrayList<Libros> consultarTitulos(String dato) {

        ArrayList<Libros> lista = new ArrayList<Libros>();

        Libros ebook;
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String SQL = "SELECT titulos.titulo,titulos.ISBN,autor.nombre,Editorial.NameEditorial,titulos.descripcion FROM titulos,autor,editorial WHERE (titulos.idautor=autor.idautor) AND (titulos.ideditorial=editorial.ideditorial) AND (titulos.titulo like ?)";
            PreparedStatement smt;
            smt = cnn.prepareStatement(SQL);
            smt.setString(1, "%" + dato + "%");
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                ebook = new Libros(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(ebook);
            }
        } catch (SQLException e) {
            System.out.println("Controlador no encontrado" + e.toString());
        } catch (Exception e) {
            System.out.println("otra excepcion" + e.toString());
        }

        return lista;
    }
}
