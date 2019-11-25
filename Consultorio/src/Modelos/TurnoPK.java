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
public class TurnoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tur_id")
    private int turId;
    @Basic(optional = false)
    @Column(name = "Medico_med_id")
    private int medicomedid;
    @Basic(optional = false)
    @Column(name = "Paciente_pac_id")
    private int pacientepacid;

    public TurnoPK() {
    }

    public TurnoPK(int turId, int medicomedid, int pacientepacid) {
        this.turId = turId;
        this.medicomedid = medicomedid;
        this.pacientepacid = pacientepacid;
    }

    public int getTurId() {
        return turId;
    }

    public void setTurId(int turId) {
        this.turId = turId;
    }

    public int getMedicomedid() {
        return medicomedid;
    }

    public void setMedicomedid(int medicomedid) {
        this.medicomedid = medicomedid;
    }

    public int getPacientepacid() {
        return pacientepacid;
    }

    public void setPacientepacid(int pacientepacid) {
        this.pacientepacid = pacientepacid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) turId;
        hash += (int) medicomedid;
        hash += (int) pacientepacid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnoPK)) {
            return false;
        }
        TurnoPK other = (TurnoPK) object;
        if (this.turId != other.turId) {
            return false;
        }
        if (this.medicomedid != other.medicomedid) {
            return false;
        }
        if (this.pacientepacid != other.pacientepacid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.TurnoPK[ turId=" + turId + ", medicomedid=" + medicomedid + ", pacientepacid=" + pacientepacid + " ]";
    }
    
}
