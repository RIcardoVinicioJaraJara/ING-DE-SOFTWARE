/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "secretario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretario.findAll", query = "SELECT s FROM Secretario s")
    , @NamedQuery(name = "Secretario.findBySecId", query = "SELECT s FROM Secretario s WHERE s.secId = :secId")
    , @NamedQuery(name = "Secretario.findBySecRol", query = "SELECT s FROM Secretario s WHERE s.secRol = :secRol")})
public class Secretario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sec_id")
    private Integer secId;
    @Column(name = "sec_rol")
    private String secRol;
    @JoinColumn(name = "Persona_per_id", referencedColumnName = "per_id")
    @ManyToOne(optional = false)
    private Persona personaperid;

    public Secretario() {
    }

    public Secretario(Integer secId) {
        this.secId = secId;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecRol() {
        return secRol;
    }

    public void setSecRol(String secRol) {
        this.secRol = secRol;
    }

    public Persona getPersonaperid() {
        return personaperid;
    }

    public void setPersonaperid(Persona personaperid) {
        this.personaperid = personaperid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secId != null ? secId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretario)) {
            return false;
        }
        Secretario other = (Secretario) object;
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Secretario[ secId=" + secId + " ]";
    }
    
}
