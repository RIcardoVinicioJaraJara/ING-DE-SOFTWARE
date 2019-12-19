/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Medico;
import conexion.conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorDoctor {
    
    private Connection connection;
    
    public void conectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/consultorio", "root", "");
            //connection = DriverManager.getConnection("jdbc:mysql://192.168.2.10:3306/facturacion", "root", "root");
            if (connection != null) {
                System.out.println(" CONEXION EXITOSA !!! ");
            }
        } catch (SQLException ex) {
            System.out.println(" erro de SQL" + ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectarBd() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println(" DESCONEXION EXITOSA ");
            } catch (Exception ex) {
                System.out.println(" error al cerrar conexion");
            }
        }

    }

    public void crear(Medico m) {
        conectarBD();
        System.out.println("conectado");
        if (connection != null) {
            try {
                String sql = "INSERT INTO medico(med_id, med_especialidad, per_id)\n"
                        + "    VALUES ("
                        + "" + m.getMedId()
                        + ",'" + m.getMedEspecialidad()
                        + "," + m.getPersonaperid().getPerId()
                        + ");";

                Statement sentencia = connection.createStatement();
                sentencia.execute(sql);
            } catch (SQLException ex) {
            }

        }
        //desconectarBd();
    }

    public String esDoctor(String cedula, String clave) {
        ControladorPersona cp = new ControladorPersona();
        String existe = null;
        int tamano = 0;
        String id = cp.idPersona(cedula, clave);
        String sql = "select COUNT(*) from medico where Persona_per_id=?";
        Connection con = null;
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tamano = rs.getInt(1);
                if (tamano > 0) {
                    return existe = "DOCTOR";
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar medico");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
        return existe;
    }
}
