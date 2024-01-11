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
import modelo.autor;
import modelo.editorial;
import modelo.libro;
import modelo.titulos;

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
    
    public static  ArrayList<autor> consultaautor (String sqlll){
        
        autor au = null;
        
        Connection cnn = null;
        
        ArrayList<autor> listaautor = new ArrayList<autor>();

        try {
            cnn = CrearConexion();
             PreparedStatement pst = cnn.prepareStatement(sqlll);
             ResultSet rs=pst.executeQuery();
            while(rs.next()){
                au=new autor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                listaautor.add(au);

    }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaautor;

}
    public static ArrayList<editorial> consultaedi(String sql1){
        
        editorial edi = null;
        
        Connection cnn = null;
        
        ArrayList<editorial> listaedi = new ArrayList<editorial>();

        try {
            cnn = CrearConexion();
             PreparedStatement pst = cnn.prepareStatement(sql1);
             ResultSet rs=pst.executeQuery();
            while(rs.next()){
                edi=new editorial(rs.getString(1),rs.getString(2));
                listaedi.add(edi);

    }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaedi;
        
    }
    
    public static ArrayList<titulos> consultatitulo (String titulo){
        
        titulos titu;
        
        Connection cnn = null;
        
        ArrayList<titulos> listatitu = new ArrayList<titulos>();

        try {
            cnn = CrearConexion();
            String sql = "Select titulos.Titulo, titulos.ISBN,  CONCAT(autor.Nombre, ' ', autor.Apellido) AS NombreAutor, editorial.NameEditorial, titulos.Descripcion, editorial.NameEditorial from titulos,autor,editorial where (titulos.IDautor=autor.IDAutor) AND (titulos.IDeditorial=editorial.IDEditorial) AND (titulos.Titulo like ?)";
             PreparedStatement pst = cnn.prepareStatement(sql);
             pst.setString(1, "%"+titulo+"%");
             ResultSet rs=pst.executeQuery();
            while(rs.next()){
                titu=new titulos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                listatitu.add(titu);

    }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listatitu;
        
    }

    public static boolean insertarlibro(libro lib) {
         boolean conecta = false;
            Connection cnn=null;
        try {
           
            
            cnn=CrearConexion();
            String sql = "INSERT INTO `titulos` VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, lib.getISBN());
            pst.setString(2, lib.getTitulo());
            pst.setString(3, lib.getAutor());
            pst.setString(4, lib.getFecha());
            pst.setString(5, lib.getDescripcion());
            pst.setString(6, lib.getEditorial());
            
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

    public static titulos consultatitul(String sql) {
         titulos titu = null;
        
        Connection cnn = null;
        
       
        try {
            cnn = CrearConexion();
             PreparedStatement pst = cnn.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
            while(rs.next()){
                titu=new titulos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                

    }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return titu;
    }

    

    public static int modilib(String titulo, String Titulo, String Autor, String Editorial, String fecha, String Descripcion) {
        int correcto = 0;
            String sql = "UPDATE titulos SET Titulo ='"+Titulo+"',IDautor='"+Autor+"',AnioEdicion='"+fecha+"',Descripcion='"+Descripcion+"',IDeditorial='"+Editorial+"'"+"WHERE Titulo='"+titulo+"'";
            
            Connection cnn=null;
            try {
            cnn=CrearConexion();
            PreparedStatement pst = cnn.prepareStatement(sql);
            correcto = pst.executeUpdate();
            pst=null;
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return correcto;
    }

    public static int deletelibro(String sql) {
        Connection cnn=null;
   
        try {
            cnn = CrearConexion();
            PreparedStatement pst= (PreparedStatement) cnn.prepareStatement(sql);
            
            return pst.executeUpdate();
            
        } catch (SQLException ex) {
            return 0;
        }
    }

    
    
}
