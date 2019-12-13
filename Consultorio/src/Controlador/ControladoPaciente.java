/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import Modelo.Paciente;

/**
 *
 * @author gusta
 */
public class ControladoPaciente {

    EntityManager em;

    public ControladoPaciente() {
        em = MySQLDB.init();
    }

    public void createUsuario(Paciente u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Paciente> Listar() {
        Query query = em.createNamedQuery("Paciente.findAll");
        return query.getResultList();
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Paciente u = em.find(Paciente.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean actualizar(Paciente u) {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public Paciente buscarPorId(int id) {
        Paciente u = em.find(Paciente.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public Paciente findByCedula(String ced) {
        TypedQuery<Paciente> consultaUsuario = em.createNamedQuery("Paciente.findByCedula", Paciente.class);
        consultaUsuario.setParameter("cedula", ced);
        Paciente u;
        try {
            u = consultaUsuario.getSingleResult();
        } catch (Exception e) {
            u = null;
        }
        return u;
    }

}
