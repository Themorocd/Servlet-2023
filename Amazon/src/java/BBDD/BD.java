/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libros;
import modelo.usuarios;

/**
 *
 * @author Andres
 */
public class BD {
    
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "amazon";

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

    public static ArrayList<usuarios> compruebauser(String sql) {
           
        Connection cnn = null;
        usuarios user = null;
        ArrayList<usuarios>List = new ArrayList<usuarios>();
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                user = new usuarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                List.add(user);
            }
            
       
        } catch (Exception e) {
        }    
        return List;
    }

    public static boolean doyalta(String user, String pass, String dire, String tel, String gmail, String nombre, String apellido) {
        

         Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            String sql = "INSERT INTO usuarios(User_name, User_password, User_address, User_email, User_phone,Nombre,Apellidos) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = cnn.prepareStatement(sql);
            
            
            pst.setString(1, nombre);
            pst.setString(2, pass);
            pst.setString(3, dire);
            pst.setString(4, gmail);
            pst.setString(5, tel);
            pst.setString(6, nombre);
            pst.setString(7, apellido);
            
            int rs = pst.executeUpdate();
            if(rs > 0 ){
                 return true;
            }          
            
        } catch (Exception e) {
        }
        
    
        return false;
        
    
    }
    
    
    public static ArrayList<Libros> consultadestacados(String sql){
        
        
        
        Connection cnn = null;
        Libros lib = null;
        ArrayList<Libros>List = new ArrayList<Libros>();
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                lib = new Libros(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6));
                List.add(lib);
            }
            
       
        } catch (Exception e) {
        }    
        return List;
        
        
        
        
        
    }
    
}
