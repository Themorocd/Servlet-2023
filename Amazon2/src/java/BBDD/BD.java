/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Modelo.Libros;
import Modelo.usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author moro-
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
        ArrayList<usuarios> List = new ArrayList<usuarios>();
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                
                user = new usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                List.add(user);
            }
            
        } catch (Exception e) {
        }
        
        
        
        return List;
        
    }
    
    
    public static ArrayList<Libros> consultadestacados(String sql){
        
        Connection cnn = null;
        
        Libros lib = null;
        
        ArrayList<Libros> List = new ArrayList<Libros>();
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                lib = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
                List.add(lib);
            }
            
        } catch (Exception e) {
        }
        return List;
        
        
    }

    public static Libros buscolibro(String sql, int cantdestacados) {
          
        Connection cnn = null;
        
        Libros lib = null;
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                lib = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), cantdestacados);
         }
        } catch (Exception e) {
        }
        
        
        
        
        return lib;
    }

    public static void altapedido(String sql1) {
        
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql1);
            pst.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static int consultaidpedido(String sql2) {
       
        int IdPedido = 0;
        
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql2);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                IdPedido = rs.getInt(1);
            }
        } catch (Exception e) {
        }
    

        return IdPedido;
          
    }

    public static void altadetallepedidos(int idpedido, int idlibro, int cantidad, double preciounidad) {
       
    
        Connection cnn = null;
        
        String sql3 = "INSERT INTO detalles_pedido (IdPedido, IdProducto, PrecioUnidad, Cantidad) VALUES ('" + idpedido + "','" + idlibro + "','" + preciounidad + "','" + cantidad + "')";
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql3);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    
    
    
    }
    
    
    
    
}
