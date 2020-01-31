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
    /*
    ControladorPersona conPer = new ControladorPersona();
        Persona persona = conPer.buscar(1);
        
        System.out.println("crear medico");
        Medico m = new Medico(0, "General", persona);
        ControladorDoctor instance = new ControladorDoctor();
        instance.crear(m);
    */
    private Connection connection;

    public void crear(Medico m, int persona) {
        Connection con = null;
        String sql = "INSERT INTO medico(med_id, med_especialidad, per_id)"
                        + "    VALUES (?,?,?);";
        
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m. getMedId());
            ps.setString(2, m.getMedEspecialidad());
            ps.setInt(3, persona);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar medico");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
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
