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
public class PacientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pac_id")
    private int pacId;
    @Basic(optional = false)
    @Column(name = "Persona_per_id")
    private int personaperid;

    public PacientePK() {
    }

    public PacientePK(int pacId, int personaperid) {
        this.pacId = pacId;
        this.personaperid = personaperid;
    }

    public int getPacId() {
        return pacId;
    }

    public void setPacId(int pacId) {
        this.pacId = pacId;
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
        hash += (int) pacId;
        hash += (int) personaperid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacientePK)) {
            return false;
        }
        PacientePK other = (PacientePK) object;
        if (this.pacId != other.pacId) {
            return false;
        }
        if (this.personaperid != other.personaperid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.PacientePK[ pacId=" + pacId + ", personaperid=" + personaperid + " ]";
    }
    
}
