/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Secretario.findBySecId", query = "SELECT s FROM Secretario s WHERE s.secretarioPK.secId = :secId")
    , @NamedQuery(name = "Secretario.findByPersonaperid", query = "SELECT s FROM Secretario s WHERE s.secretarioPK.personaperid = :personaperid")})
public class Secretario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecretarioPK secretarioPK;
    @JoinColumn(name = "Persona_per_id", referencedColumnName = "per_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Secretario() {
    }

    public Secretario(SecretarioPK secretarioPK) {
        this.secretarioPK = secretarioPK;
    }

    public Secretario(int secId, int personaperid) {
        this.secretarioPK = new SecretarioPK(secId, personaperid);
    }

    public SecretarioPK getSecretarioPK() {
        return secretarioPK;
    }

    public void setSecretarioPK(SecretarioPK secretarioPK) {
        this.secretarioPK = secretarioPK;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secretarioPK != null ? secretarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretario)) {
            return false;
        }
        Secretario other = (Secretario) object;
        if ((this.secretarioPK == null && other.secretarioPK != null) || (this.secretarioPK != null && !this.secretarioPK.equals(other.secretarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Secretario[ secretarioPK=" + secretarioPK + " ]";
    }
    
}
