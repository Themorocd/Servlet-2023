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
import modelo.Disco;
import modelo.usuarios;

/**
 *
 * @author moro-
 */
public class BD {
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "casa-disco";

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
        public static ArrayList<Disco> consultacategoria(String sql) {
       
        Connection cnn = null;
        
        Disco dis = null;
        
        ArrayList<Disco> List = new ArrayList<Disco>();
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                dis = new Disco(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
                List.add(dis);
            }
        } catch (Exception e) {
        }
    
    
        return List;
 
    
    }

    public static Disco buscodisco(String sql, int cantidad) {
     
        Connection cnn = null;
        
        Disco disco = null;
        
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn. prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                 disco = new Disco(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), cantidad);
                  }
            
        } catch (Exception e) {
        }
        
    
        return disco;
     
    
    
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
      
        int idpedido = 0;
        
        Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql2);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                idpedido = rs.getInt(1);
            }
            
            
        } catch (Exception e) {
        }
        return idpedido;
    
    
    
    }

    public static void altadetallespedido(int idPedido, int iddisco, int cantidad, double preciounidad) {
        
        Connection cnn = null;
        
        String sql ="INSERT INTO infopedidos (idPedido,iddisco,cantidad,precio) values ('"+idPedido+"','"+iddisco+"','"+cantidad+"','"+preciounidad+"')";
        
        try {
            cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    
    }

    public static void altauser(String sql) {
        
         Connection cnn = null;
        
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    
    }
    
}
