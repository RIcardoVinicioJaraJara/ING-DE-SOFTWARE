/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    , @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.perNombre = :perNombre")
    , @NamedQuery(name = "Persona.findByPerApellido", query = "SELECT p FROM Persona p WHERE p.perApellido = :perApellido")
    , @NamedQuery(name = "Persona.findByPreDireccion", query = "SELECT p FROM Persona p WHERE p.preDireccion = :preDireccion")
    , @NamedQuery(name = "Persona.findByPerTelefono", query = "SELECT p FROM Persona p WHERE p.perTelefono = :perTelefono")
    , @NamedQuery(name = "Persona.findByPerFecNacimiento", query = "SELECT p FROM Persona p WHERE p.perFecNacimiento = :perFecNacimiento")
    , @NamedQuery(name = "Persona.findByPerMail", query = "SELECT p FROM Persona p WHERE p.perMail = :perMail")
    , @NamedQuery(name = "Persona.findByPerContro", query = "SELECT p FROM Persona p WHERE p.perContro = :perContro")})
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
    @Column(name = "per_apellido")
    private String perApellido;
    @Column(name = "pre_direccion")
    private String preDireccion;
    @Column(name = "per_telefono")
    private String perTelefono;
    @Column(name = "per_fec_nacimiento")
    private String perFecNacimiento;
    @Column(name = "per_mail")
    private String perMail;
    @Column(name = "per_contro")
    private String perContro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaperid")
    private Collection<Secretario> secretarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaperid1")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaperid")
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

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPreDireccion() {
        return preDireccion;
    }

    public void setPreDireccion(String preDireccion) {
        this.preDireccion = preDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerFecNacimiento() {
        return perFecNacimiento;
    }

    public void setPerFecNacimiento(String perFecNacimiento) {
        this.perFecNacimiento = perFecNacimiento;
    }

    public String getPerMail() {
        return perMail;
    }

    public void setPerMail(String perMail) {
        this.perMail = perMail;
    }

    public String getPerContro() {
        return perContro;
    }

    public void setPerContro(String perContro) {
        this.perContro = perContro;
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
        return "Modelo.Persona[ perId=" + perId + " ]";
    }
    
}
