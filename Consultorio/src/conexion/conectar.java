/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import Controlador.ControladorCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conectar {

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "");
            return con;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a matriz");
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
            System.out.println("Error al cerrar");
        }
    }
}
