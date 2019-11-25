/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelos.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author gusta
 */
public class ControladorUsuario {

    EntityManager em;

    public ControladorUsuario() {
        em = MySQLDB.init();
    }

    public void createUsuario(Persona u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Persona> findAll() {
        Query query = em.createNamedQuery("Persona.findAll");
        return query.getResultList();
    }
    
    public List<Persona> findAdmin() {
        Query query = em.createNamedQuery("Usuario.findAdmin");
        return query.getResultList();
    }
    
    public List<Persona> findSecre() {
        Query query = em.createNamedQuery("Usuario.findSecre");
        return query.getResultList();
    }
    
    public List<Persona> findAproNO() {
        Query query = em.createNamedQuery("Usuario.findAproNO");
        return query.getResultList();
    }
    
     public List<Persona> findAproSI() {
        Query query = em.createNamedQuery("Usuario.findAproSI");
        return query.getResultList();
    }

    public Persona findByID(int id) {
        Persona u = em.find(Persona.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public Persona findByCedula(String ced) {
        TypedQuery<Persona> consultaUsuario = em.createNamedQuery("Usuario.findByCedula", Persona.class);
        consultaUsuario.setParameter("cedula", ced);
        Persona u;
        try{
             u = consultaUsuario.getSingleResult();
        }catch(Exception e){
            u = null;
        }
        return u;
    }
    
    public Persona findByCedula2(String ced) {
        TypedQuery<Persona> consultaUsuario = em.createNamedQuery("Usuario.findByCedula2", Persona.class);
        consultaUsuario.setParameter("cedula", ced);
        Persona u;
        try{
             u = consultaUsuario.getSingleResult();
        }catch(Exception e){
            u = null;
        }
        return u;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Persona u = em.find(Persona.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Persona u) {
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
}
