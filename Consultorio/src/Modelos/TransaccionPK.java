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
public class TransaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tra_id")
    private int traId;
    @Basic(optional = false)
    @Column(name = "Cuenta_cue_id")
    private int cuentacueid;

    public TransaccionPK() {
    }

    public TransaccionPK(int traId, int cuentacueid) {
        this.traId = traId;
        this.cuentacueid = cuentacueid;
    }

    public int getTraId() {
        return traId;
    }

    public void setTraId(int traId) {
        this.traId = traId;
    }

    public int getCuentacueid() {
        return cuentacueid;
    }

    public void setCuentacueid(int cuentacueid) {
        this.cuentacueid = cuentacueid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) traId;
        hash += (int) cuentacueid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.traId != other.traId) {
            return false;
        }
        if (this.cuentacueid != other.cuentacueid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.TransaccionPK[ traId=" + traId + ", cuentacueid=" + cuentacueid + " ]";
    }
    
}
