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
import vista.Comerciales;
import vista.Productos;
import vista.Ventas;

/**
 *
 * @author Andres
 */
public class BD {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "ventas_comerciales";

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

    public static boolean compruebouser(String user, String pass) {

        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM `usuario` WHERE `usuario`='" + user + "' AND `password`='" + pass + "'";
            PreparedStatement smt;
            smt = cnn.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static ArrayList<Productos> consultaProductos(String sql1) {

        Connection cnn = null;
        ArrayList<Productos> productos = null;
        try {
            cnn = CrearConexion();

            Productos producto = null;

            productos = new ArrayList<Productos>();

            PreparedStatement pst = cnn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                producto = new Productos(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                productos.add(producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;

    }

    public static ArrayList<Ventas> consultaventas(String producto) {
        Connection cnn = null;
        Ventas ven = null;
        ArrayList<Ventas> venta = null;
        try {
            cnn = CrearConexion();

            venta = new ArrayList<Ventas>();

            String sql = "SELECT ventas.fecha, comerciales.nombre, ventas.cantidad, productos.precio, productos.descuento, (ventas.cantidad*productos.precio) ,((ventas.cantidad*productos.precio)-(ventas.cantidad*(productos.precio*(productos.descuento/100)))) FROM ventas,comerciales,productos WHERE productos.referencia=ventas.refProducto AND ventas.codComercial=comerciales.codigo AND productos.referencia='" + producto + "'";

            PreparedStatement pst = cnn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ven = new Ventas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                venta.add(ven);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return venta;
    }

    public static ArrayList<Comerciales> consultaComerciales(String sql2) {

        Connection cnn = null;
        ArrayList<Comerciales> comercial = null;
        try {
            cnn = CrearConexion();

            Comerciales come = null;

            comercial = new ArrayList<Comerciales>();

            PreparedStatement pst = cnn.prepareStatement(sql2);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                come = new Comerciales(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                comercial.add(come);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comercial;

    }

    public static boolean insertoDatos(String comercial, String producto, String cantidad, String fecha) {

        Connection cnn = null;

        try {
            cnn = CrearConexion();

            String sql = "Insert into ventas(codComercial,refProducto,cantidad,fecha) Values (?,?,?,?)";

            PreparedStatement smt;
            smt = cnn.prepareStatement(sql);
            smt.setString(1, comercial);
            smt.setString(2, producto);
            smt.setString(3, cantidad);
            smt.setString(4, fecha);

            int rs = smt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static boolean insertarProductos(String referencia, String nombre, String descripcion, String precio, String descuento) {

        Connection cnn = null;

        try {
            cnn = CrearConexion();

            String sql = "Insert into productos(referencia,nombre,descripcion,precio,descuento) Values (?,?,?,?,?)";
            
            PreparedStatement smt;
            smt = cnn.prepareStatement(sql);
            smt.setString(1, referencia);
            smt.setString(2, nombre);
            smt.setString(3, descripcion);
            smt.setString(4, precio);
            smt.setString(5, descuento);
            
            int filas = smt.executeUpdate();
            
            if (filas > 0) {
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static boolean modificar(String nombre, String descripcion, String precio, String descuento, String producto) {
        Connection cnn = null;

        try {
            cnn = CrearConexion();

            
            String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, descuento = ? WHERE referencia = ?";
            PreparedStatement smt;
            smt = cnn.prepareStatement(sql);
            
            smt.setString(1, nombre);
            smt.setString(2, descripcion);
            smt.setString(3, precio);
            smt.setString(4, descuento);
            smt.setString(5, producto);
            
            int filas = smt.executeUpdate();
            
            if (filas > 0) {
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static boolean insertarComerciales(String Codigo, String nombre, String sueldo, String fecha, String hijos) {
         Connection cnn = null;

        try {
            cnn = CrearConexion();

            String sql = "Insert into comerciales(codigo,nombre,salario,hijos,fNacimiento) Values (?,?,?,?,?)";
            
            PreparedStatement smt;
            smt = cnn.prepareStatement(sql);
            smt.setString(1, Codigo);
            smt.setString(2, nombre);
            smt.setString(3, sueldo);
            smt.setString(4, hijos);
            smt.setString(5, fecha);
            
            int filas = smt.executeUpdate();
            
            if (filas > 0) {
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
