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
public class CertificadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cer_id")
    private int cerId;
    @Basic(optional = false)
    @Column(name = "ConsultaMedica_con_med_id")
    private int consultaMedicaconmedid;

    public CertificadoPK() {
    }

    public CertificadoPK(int cerId, int consultaMedicaconmedid) {
        this.cerId = cerId;
        this.consultaMedicaconmedid = consultaMedicaconmedid;
    }

    public int getCerId() {
        return cerId;
    }

    public void setCerId(int cerId) {
        this.cerId = cerId;
    }

    public int getConsultaMedicaconmedid() {
        return consultaMedicaconmedid;
    }

    public void setConsultaMedicaconmedid(int consultaMedicaconmedid) {
        this.consultaMedicaconmedid = consultaMedicaconmedid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cerId;
        hash += (int) consultaMedicaconmedid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificadoPK)) {
            return false;
        }
        CertificadoPK other = (CertificadoPK) object;
        if (this.cerId != other.cerId) {
            return false;
        }
        if (this.consultaMedicaconmedid != other.consultaMedicaconmedid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.CertificadoPK[ cerId=" + cerId + ", consultaMedicaconmedid=" + consultaMedicaconmedid + " ]";
    }
    
}
