/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import vista.VentanaPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorPersona {

    ControladorCliente cc = new ControladorCliente();
    ControladoPaciente cp = new ControladoPaciente();
    ControladorSecretaria cs = new ControladorSecretaria();
    ControladorDoctor cd = new ControladorDoctor();

    public String idPersona(String cedula, String clave) {
        String id = null;
        String sql = "SELECT per_id "
                + "FROM persona where per_cedula=? && per_contro=?";
        Connection con = null;
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("per_id");
                return id;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar persona");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
        return id;
    }

    public String validar(String usuario, String clave, String opc) {
        String ocupacion = null;
        if (idPersona(usuario, clave) != null) {
            switch (opc) {
                case "PACIENTE":
                    if (cc.esCliente(usuario, clave) == "PACIENTE") {
                        VentanaPrincipal.main(null);
                        return ocupacion = "PACIENTE";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de Paciente");
                        return ocupacion = "Usuario no tiene permisos de Paciente";
                    }
                case "SECRETARIA":
                    if (cs.esSecretaria(usuario, clave) == "SECRETARIA") {
                        VentanaPrincipal.main(null);
                        return ocupacion = "SECRETARIA";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de SECRETARIA");
                        return ocupacion = "Usuario no tiene permisos de SECRETARIA";
                    }
                case "DOCTOR":
                    if (cd.esDoctor(usuario, clave) == "DOCTOR") {
                        VentanaPrincipal.main(null);
                        return ocupacion = "DOCTOR";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de DOCTOR");
                        return ocupacion = "Usuario no tiene permisos de DOCTOR";
                    }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return ocupacion = "Usuario no encontrado";
        }
        return ocupacion;
    }
}
