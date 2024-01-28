/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andres
 */
public class BD {
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "telepizza";

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
   
    public static boolean doyalta(String nombre,String pass,String dire,String tel,String gmail) {
        
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            String sql = "INSERT INTO usuarios(User_name, User_password, User_address, `User_email`, `User_phone`) VALUES (?,?,?,?,?)";

            PreparedStatement pst = cnn.prepareStatement(sql);
            
            
            pst.setString(1, nombre);
            pst.setString(2, pass);
            pst.setString(3, dire);
            pst.setString(4, tel);
            pst.setString(5, gmail);
            
            int rs = pst.executeUpdate();
            if(rs > 0 ){
                 return true;
            }
           
            
        } catch (Exception e) {
        }
        
        
        
        
        return false;
        
        
        
    }
    
}
