/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import conexion.conectar;
import Modelo.Persona;
import conexion.conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VentanaPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorPersona {

    private Connection connection;
    conectar c = new conectar();
    ControladorCliente cc = new ControladorCliente();
    ControladoPaciente cp = new ControladoPaciente();
    ControladorSecretaria cs = new ControladorSecretaria();
    ControladorDoctor cd = new ControladorDoctor();
    
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

    public void crear(Persona p) {
        conectarBD();
        System.out.println("conectado");
        if (connection != null) {
            try {
                String sql = "INSERT INTO persona(per_id, per_cedula, per_nombre, per_apellido, pre_direccion, per_telefono, per_fec_nacimiento, per_mail, per_contro)\n"
                        + "    VALUES ("
                        + "" + p.getPerId()
                        + ",'" + p.getPerCedula()
                        + "','" + p.getPerNombre()
                        + "','" + p.getPerApellido()
                        + "','" + p.getPreDireccion()
                        + "','" + p.getPerTelefono()
                        + "','" + p.getPerFecNacimiento()
                        + "','" + p.getPerMail()
                        + "','" + p.getPerContro()
                        + "');";

                Statement sentencia = connection.createStatement();
                sentencia.execute(sql);
            } catch (SQLException ex) {
            }

        }
        //desconectarBd();
    }
    
    public Persona buscar(int codigo) {
        conectarBD();
        Persona cli = new Persona();
        String sql = "SELECT * FROM persona WHERE per_id=" + codigo + ";";
        Statement sentencia;
        try {

            sentencia = connection.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                cli.setPerId(rs.getInt("per_id"));
                cli.setPerCedula(rs.getString("per_cedula"));
                cli.setPerNombre(rs.getString("per_nombre"));
                cli.setPerApellido(rs.getString("per_apellido"));
                cli.setPreDireccion(rs.getString("pre_direccion"));
                cli.setPerTelefono(rs.getString("per_telefono"));
                cli.setPerTelefono(rs.getString("per_fec_nacimiento"));
                cli.setPerMail(rs.getString("per_mail"));
                cli.setPerMail(rs.getString("per_contro"));
            }

        } catch (SQLException ex) {
        }
        desconectarBd();

        return cli;

    }
    
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
