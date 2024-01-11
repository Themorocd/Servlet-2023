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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.alumnos;

/**
 *
 * @author moro-
 */
public class BD {
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basededatos = "ciclodaw";
    
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
        String sql = "SELECT * FROM `usuarios` WHERE `user`='" + user + "' AND `pass`='" + pass + "'";
        
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
    
     public static ArrayList<alumnos> consultalistaalumnos(String sql){
        
        Connection cnn=null;
        ArrayList<alumnos> lista = new ArrayList<alumnos>();
        
        alumnos alu = null;
        
       
        
        try {
             cnn = CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            while (rs.next()){
                alu = new alumnos (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                
                lista.add(alu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return lista;
    
}

    public static boolean insertaralu(alumnos alu) {
        boolean conecta = false;
        String sql = "INSERT INTO alumnos VALUES (?,?,?,?,?,?,?,?)";
        Connection cnn = null;
            
            
        try {
            cnn = CrearConexion();
            
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, alu.getNombre());
            pst.setString(2, alu.getApellidos());
            pst.setString(3, alu.getDaw());
            pst.setString(4, alu.getDawec());
            pst.setString(5, alu.getDawes());
            pst.setString(6, alu.getDiw());
            pst.setString(7, alu.getFct());
            pst.setString(8, alu.getProyecto());
            
            int rs = pst.executeUpdate();
            
           if(rs>0){
                System.out.println("Ha sido agregado con exito");
                conecta = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conecta;
    }

    public static void delete(String[] SEL) {
        Connection cnn=null;
        
       
        
        
        for (int x = 0; x < SEL.length;x++) {
            
            String sql="DELETE FROM alumnos where NOMBRE='"+SEL[x]+"'";
            
            
            try {
                 cnn=CrearConexion();
                PreparedStatement pst =  cnn.prepareStatement(sql);
                pst.executeUpdate();
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            
    }
    
        }  
    }

    public static alumnos consultalistalumnos(String nombre, String apellidos) {
        alumnos alu = null;
        
        Connection cnn=null;
        
        cnn=CrearConexion();
        
        String sql="SELECT * FROM alumnos WHERE APELLIDOS = '"+apellidos+"' AND NOMBRE='"+nombre+"'";
        
        try {
            PreparedStatement pst=  cnn.prepareStatement(sql);
                    
            ResultSet rs= (ResultSet) pst.executeQuery();
            
            rs.next();
            
            alu = new alumnos (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));            
            return alu;
         
        } catch (SQLException ex) {
            
            return alu;
         
        }
    }

    public static int modificarUsuario(alumnos alu) {
    Connection cnn=null;
        
        cnn=CrearConexion();
        
        String sql = "UPDATE alumnos SET NOMBRE='" + alu.getNombre() + "',APELLIDOS='" + alu.getApellidos() + "', "
                + "DAWES='" + alu.getDawes() + "', DAWEC='" + alu.getDawec()+ "', DIW='"+alu.getDiw()+"', DIW='"+alu.getDiw()+"',DAW='"+alu.getDaw()+"', FCT='"+alu.getFct()+"', PROYECTO='"+alu.getProyecto()+"'"
                + "WHERE NOMBRE='" + alu.getNombre()+ "'";

        try {

            PreparedStatement pst= cnn.prepareStatement(sql);
           return pst.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            return 0;
        }
    }
    
}
