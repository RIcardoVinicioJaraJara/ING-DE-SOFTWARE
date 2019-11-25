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
public class ConsultafichaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "con_fic_id")
    private int conFicId;
    @Basic(optional = false)
    @Column(name = "ConsultaMedica_con_med_id")
    private int consultaMedicaconmedid;
    @Basic(optional = false)
    @Column(name = "FichaMedica_fic_med_id")
    private int fichaMedicaficmedid;

    public ConsultafichaPK() {
    }

    public ConsultafichaPK(int conFicId, int consultaMedicaconmedid, int fichaMedicaficmedid) {
        this.conFicId = conFicId;
        this.consultaMedicaconmedid = consultaMedicaconmedid;
        this.fichaMedicaficmedid = fichaMedicaficmedid;
    }

    public int getConFicId() {
        return conFicId;
    }

    public void setConFicId(int conFicId) {
        this.conFicId = conFicId;
    }

    public int getConsultaMedicaconmedid() {
        return consultaMedicaconmedid;
    }

    public void setConsultaMedicaconmedid(int consultaMedicaconmedid) {
        this.consultaMedicaconmedid = consultaMedicaconmedid;
    }

    public int getFichaMedicaficmedid() {
        return fichaMedicaficmedid;
    }

    public void setFichaMedicaficmedid(int fichaMedicaficmedid) {
        this.fichaMedicaficmedid = fichaMedicaficmedid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) conFicId;
        hash += (int) consultaMedicaconmedid;
        hash += (int) fichaMedicaficmedid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultafichaPK)) {
            return false;
        }
        ConsultafichaPK other = (ConsultafichaPK) object;
        if (this.conFicId != other.conFicId) {
            return false;
        }
        if (this.consultaMedicaconmedid != other.consultaMedicaconmedid) {
            return false;
        }
        if (this.fichaMedicaficmedid != other.fichaMedicaficmedid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ConsultafichaPK[ conFicId=" + conFicId + ", consultaMedicaconmedid=" + consultaMedicaconmedid + ", fichaMedicaficmedid=" + fichaMedicaficmedid + " ]";
    }
    
}
