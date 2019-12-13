/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

    public boolean existe(String cedula, String clave) {
        return false;
    }

    public String validar(String usuario, String clave, String opc) {
        String ocupacion=null;
        if (existe(usuario, clave) == false) {
            switch (opc) {
                case "PACIENTE":
                    if (cc.esCliente(usuario, clave) == "PACIENTE") {
                        VentanaPrincipal.main(null);
                        return ocupacion="PACIENTE";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de Paciente");
                        return ocupacion="Usuario no tiene permisos de Paciente";
                    }
                    //break;
                case "SECRETARIA":
                    if (cs.esSecretaria(usuario, clave) == "SECRETARIA") {
                        VentanaPrincipal.main(null);
                        return ocupacion="SECRETARIA";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de SECRETARIA");
                        return ocupacion="Usuario no tiene permisos de SECRETARIA";
                    }
                    //break;
                case "DOCTOR":
                    if (cd.esDoctor(usuario, clave) == "DOCTOR") {
                        VentanaPrincipal.main(null);
                        return ocupacion="DOCTOR";
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no tiene permisos de DOCTOR");
                        return ocupacion="Usuario no tiene permisos de DOCTOR";
                    }
                    //break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return ocupacion="Usuario no encontrado";
        }
        return ocupacion;
    }
}