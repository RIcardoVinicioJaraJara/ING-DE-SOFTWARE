/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class SecretarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "sec_id")
    private int secId;
    @Basic(optional = false)
    @Column(name = "Persona_per_id")
    private int personaperid;

    public SecretarioPK() {
    }

    public SecretarioPK(int secId, int personaperid) {
        this.secId = secId;
        this.personaperid = personaperid;
    }

    public int getSecId() {
        return secId;
    }

    public void setSecId(int secId) {
        this.secId = secId;
    }

    public int getPersonaperid() {
        return personaperid;
    }

    public void setPersonaperid(int personaperid) {
        this.personaperid = personaperid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) secId;
        hash += (int) personaperid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecretarioPK)) {
            return false;
        }
        SecretarioPK other = (SecretarioPK) object;
        if (this.secId != other.secId) {
            return false;
        }
        if (this.personaperid != other.personaperid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.SecretarioPK[ secId=" + secId + ", personaperid=" + personaperid + " ]";
    }
    
}
