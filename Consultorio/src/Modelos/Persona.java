/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPerId", query = "SELECT p FROM Persona p WHERE p.perId = :perId")
    , @NamedQuery(name = "Persona.findByPerCedula", query = "SELECT p FROM Persona p WHERE p.perCedula = :perCedula")
    , @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.perNombre = :perNombre")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Column(name = "per_cedula")
    private String perCedula;
    @Column(name = "per_nombre")
    private String perNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Secretario> secretarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Medico> medicoCollection;

    public Persona() {
    }

    public Persona(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    @XmlTransient
    public Collection<Secretario> getSecretarioCollection() {
        return secretarioCollection;
    }

    public void setSecretarioCollection(Collection<Secretario> secretarioCollection) {
        this.secretarioCollection = secretarioCollection;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Persona[ perId=" + perId + " ]";
    }
    
}
