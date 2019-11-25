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
public class CuentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cue_id")
    private int cueId;
    @Basic(optional = false)
    @Column(name = "Medico_med_id")
    private int medicomedid;

    public CuentaPK() {
    }

    public CuentaPK(int cueId, int medicomedid) {
        this.cueId = cueId;
        this.medicomedid = medicomedid;
    }

    public int getCueId() {
        return cueId;
    }

    public void setCueId(int cueId) {
        this.cueId = cueId;
    }

    public int getMedicomedid() {
        return medicomedid;
    }

    public void setMedicomedid(int medicomedid) {
        this.medicomedid = medicomedid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cueId;
        hash += (int) medicomedid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaPK)) {
            return false;
        }
        CuentaPK other = (CuentaPK) object;
        if (this.cueId != other.cueId) {
            return false;
        }
        if (this.medicomedid != other.medicomedid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.CuentaPK[ cueId=" + cueId + ", medicomedid=" + medicomedid + " ]";
    }
    
}
