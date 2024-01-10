/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class BD {
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basededatos = "examen";
    
     public static Connection CrearConexion() {

        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + "/" + basededatos;
            cnn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JBDC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otra excepcion" + c.toString());
        }
        return cnn;
    }

    public static boolean compruebouser(String user, String pass) {
        
        Connection cnn = null;
        
        try{
        cnn = CrearConexion();
        String sql = "SELECT * FROM `usuario` WHERE `usuario`='" + user + "' AND `password`='" + pass + "'";
        
        PreparedStatement smt = cnn.prepareStatement(sql);
        ResultSet rs = smt.executeQuery();
        if(rs.next()){
            return true;
        }
        
        }catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
