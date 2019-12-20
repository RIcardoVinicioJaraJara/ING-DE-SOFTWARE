/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Fichamedica;
import Modelo.Paciente;
import Modelo.Persona;
import Modelo.Turno;
import conexion.conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorA {

    public List<Persona> buscarPaciente(String cedula) {
        List<Persona> Person = new ArrayList<>();
        String sql = "SELECT pe.per_cedula, pe.per_nombre, pe.per_apellido, pe.per_telefono, pe.pre_direccion, pe.per_fec_nacimiento, pe.per_mail "
                + "FROM Persona pe, Paciente pa where pe.per_cedula=? && pe.per_id=pa.Persona_per_id1";
        Connection con = null;
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setPerCedula(rs.getString("per_cedula").trim());
                p.setPerNombre(rs.getString("per_nombre").trim());
                p.setPerApellido(rs.getString("per_apellido"));
                p.setPerTelefono(rs.getString("per_telefono"));
                p.setPreDireccion(rs.getString("pre_direccion"));
                p.setPerMail(rs.getString("per_mail"));
                Person.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar persona");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
        return Person;
    }
    public List<Turno> listarTurno(String cedula) {
        List<Turno> turno = new ArrayList<>();
        String sql = "SELECT t.tur_hora, t.tur_fecha  "
                + "FROM Persona pe, Paciente pa, Turno t, Medico m where pe.per_cedula=? && pe.per_id=pa.Persona_per_id1 && pa.Persona_per_id1=t.Paciente_pac_id";
        Connection con = null;
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Turno t = new Turno();
                t.setTurHora(rs.getTime("tur_hora"));
                t.setTurFecha(rs.getDate("tur_fecha"));
                turno.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar turno");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
        return turno;
    }
    
    public void crearTurno(Turno modelo, int Paciente, int Medico) {
        Connection con = null;
        String sql = "INSERT INTO truno (tur_hora, tur_fecha, Paciente_pac_id, Medico_med_id1) "
                   + " VALUES (?,?,?,?);";
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) modelo.getTurHora());
            ps.setDate(2, (Date) modelo.getTurFecha());
            ps.setInt(3, Paciente);
            ps.setInt(4, Medico);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar truno");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
    }
}
