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

}
