package DAO;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {

    static String db = "tienda";
    static String user = "root";
    static String pass = "usbw";
    static String ruta = "jdbc:mysql://localhost/" + db;
    Connection cnx;

    public Conexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(ruta, user, pass);
            if (cnx != null) {
                System.out.println("Correcto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection Conectar(){
        try {
            return this.cnx;
        } catch (Exception e) {
        return null;
        }
    }
    public void Cerrar() throws SQLException{
    this.cnx.close();
    }
}
