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
import mod.pizza;

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
            String sql = "INSERT INTO usuarios(User_name, User_password, User_address, User_email, User_phone) VALUES (?,?,?,?,?)";

            PreparedStatement pst = cnn.prepareStatement(sql);
            
            
            pst.setString(1, nombre);
            pst.setString(2, pass);
            pst.setString(3, dire);
            pst.setString(4, gmail);
            pst.setString(5, tel);
            
            int rs = pst.executeUpdate();
            if(rs > 0 ){
                 return true;
            }
           
            
        } catch (Exception e) {
        }
        
        
        
        
        return false;
        
        
        
    }

    public static boolean compruebauser(String sql) {
       
        
        
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
            
        } catch (Exception e) {
        }
        
        
        return false;
        }
 
    
    public static ArrayList<pizza> consultacarne(String sql){
        
        
        Connection cnn = null;
        
        ArrayList<pizza> List =null;
        
        pizza piz = null;
        
        try {
            List = new ArrayList<pizza>();
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                piz = new pizza(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                List.add(piz);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return List;
            
        
    }
      public static ArrayList<pizza> consultaqueso(String sql1){
        
        
        Connection cnn = null;
        
        ArrayList<pizza> List =null;
        
        pizza piz = null;
        
        try {
            List = new ArrayList<pizza>();
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                piz = new pizza(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                List.add(piz);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return List;
            
        
    }
       public static ArrayList<pizza> consultaclasi(String sql2){
        
        
        Connection cnn = null;
        
        ArrayList<pizza> List =null;
        
        pizza piz = null;
        
        try {
            List = new ArrayList<pizza>();
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql2);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                piz = new pizza(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                List.add(piz);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return List;
            
        
    }
       public static ArrayList<pizza> consultainfantil(String sql3){
        
        
        Connection cnn = null;
        
        ArrayList<pizza> List =null;
        
        pizza piz = null;
        
        try {
            List = new ArrayList<pizza>();
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql3);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                piz = new pizza(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                List.add(piz);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return List;
            
        
    }
     public static ArrayList<pizza> consultagluten(String sql4){
        
        
        Connection cnn = null;
        
        ArrayList<pizza> List =null;
        
        pizza piz = null;
        
        try {
            List = new ArrayList<pizza>();
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql4);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                piz = new pizza(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                List.add(piz);
            }
            
            
            
        } catch (Exception e) {
        }
        
        return List;
            
        
    }

    public static boolean compruebatel(String sql) {
         Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
            
        } catch (Exception e) {
        }
        
        
        return false;
        }
}
