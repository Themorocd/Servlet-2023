package lbalbion;

import java.sql.*;
import java.util.Scanner;

public class LBAlbion {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lb";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database opened successfully");

            Scanner scanner = new Scanner(System.in);

                        System.out.println(" 1 para insertar datos, 2 para borrar usuario,3 para actualizar usuario: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Introduce Nombre: ");
                    String nombre = scanner.next();
                    System.out.println("Asistencias semana 1: ");
                    int semana1 = scanner.nextInt();
                    System.out.println("Asistencias semana 2: ");
                    int semana2 = scanner.nextInt();
                    System.out.println("Asistencias semana 3: ");
                    int semana3 = scanner.nextInt();
                    System.out.println("Asistencias semana 4:");
                    int semana4 = scanner.nextInt();
                    insertData(conn, nombre, semana1, semana2, semana3, semana4);
                    break;
                case 2:
                    System.out.println("Introduce el nombre: ");
                    String user = scanner.next();
                    deleteData(conn, user);
                    break;
                
                case 3:
                    System.out.println("Introduce nombre para actualizar: ");
                    String userName = scanner.next();
                    System.out.println("Introduce la semana (1-4): ");
                    int week = scanner.nextInt();
                    System.out.println("Introduce el numero de asistencias: ");
                    int newValue = scanner.nextInt();
                    updateSpecificWeek(conn, userName, week, newValue);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            conn.close();
            scanner.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    private static void insertData(Connection conn, String nombre, int semana1, int semana2, int semana3, int semana4) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Datos (Nombre, Semana1, Semana2, Semana3, Semana4, Total) VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, nombre);
        pstmt.setInt(2, semana1);
        pstmt.setInt(3, semana2);
        pstmt.setInt(4, semana3);
        pstmt.setInt(5, semana4);
        pstmt.setInt(6, semana1 + semana2 + semana3 + semana4);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void deleteData(Connection conn, String user) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM Datos WHERE Nombre=" + user;
        stmt.executeUpdate(sql);
        stmt.close();
    }
    
    private static void updateSpecificWeek(Connection conn, String userName, int week, int newValue) throws SQLException {
        String columnName = "Semana" + week;
        PreparedStatement pstmt = conn.prepareStatement("UPDATE Datos SET " + columnName + " = ?, Total = (Semana1 + Semana2 + Semana3 + Semana4) WHERE Nombre = ?");
        pstmt.setInt(1, newValue);
        pstmt.setString(2, userName);
        pstmt.executeUpdate();
        pstmt.close();
    }
}

