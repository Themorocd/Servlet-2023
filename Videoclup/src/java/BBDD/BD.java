/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Modelo.director;
import Modelo.pelicula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moro-
 */
public class BD {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "vidioteca";

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

    public static boolean compruebousario(String user, String pass) {

        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM `usuario` WHERE `usuario`='" + user + "' AND `password`='" + pass + "'";
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static ArrayList<director> consultodirector(String sql) {

        Connection cnn = null;
        ArrayList<director> Lista = new ArrayList<director>();

        director dire = null;
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                dire = new director(rs.getString(1), rs.getString(2));
                Lista.add(dire);
            }
        } catch (Exception e) {
        }

        return Lista;

    }

    public static ArrayList<pelicula> consultapelicula(String sql) {

        Connection cnn = null;
        ArrayList<pelicula> Lista = new ArrayList<pelicula>();

        pelicula peli = null;
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                peli = new pelicula(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                Lista.add(peli);
            }
        } catch (Exception e) {
        }

        return Lista;

    }

    public static boolean alta(pelicula pel) {
        Connection cnn = null;

        boolean conecta = false;

        try {
            cnn = CrearConexion();
            String sql = "INSERT INTO `peliculas` VALUES(?,?,?,?)";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, pel.getId());
            pst.setString(2, pel.getPeli());
            pst.setString(3, pel.getDire());
            pst.setString(4, pel.getFecha());

            int rs = pst.executeUpdate();

            if (rs > 0) {
                System.out.println("Ha sido agregado con exito");
                conecta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conecta;

    }

    public static pelicula consultapeli(String sql) {
        Connection cnn = null;

        pelicula peli = null;

        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                peli = new pelicula(rs.getString(1), rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return peli;

    }

    public static int modipeli(String id, String pel, String dire, String fecha) {

        int correcto = 0;

        String sql = "UPDATE peliculas set titulo='" + pel + "',fecha_estreno='" + fecha + "'" + "WHERE id='" + id + "'";

        Connection cnn = null;
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            correcto = pst.executeUpdate();
            pst = null;

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;

    }

    public static int deletepeli(String sql) {

        Connection cnn = null;

        try {
            cnn = CrearConexion();
            PreparedStatement pst = (PreparedStatement) cnn.prepareStatement(sql);
            return pst.executeUpdate();
        } catch (Exception e) {
        }

        return 0;

    }

    public static ArrayList<pelicula> consultotodo(String sql) {

        Connection cnn = null;
        ArrayList<pelicula> Lista = new ArrayList<pelicula>();

        pelicula peli = null;
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                peli = new pelicula(rs.getString(1), rs.getString(2), rs.getString(3));
                Lista.add(peli);
            }
        } catch (Exception e) {
        }

        return Lista;

    }

    public static ArrayList<pelicula> consupelicula(String sql) {

        Connection cnn = null;

        ArrayList<pelicula> Lista = new ArrayList<pelicula>();

        pelicula peli = null;
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                peli = new pelicula(rs.getString(1), rs.getString(2), rs.getString(3));
                Lista.add(peli);
            }
        } catch (Exception e) {
        }

        return Lista;

        

    }

}
