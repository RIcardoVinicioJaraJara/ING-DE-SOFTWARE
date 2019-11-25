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
public class ConsultamedicaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "con_med_id")
    private int conMedId;
    @Basic(optional = false)
    @Column(name = "Turno_tur_id")
    private int turnoturid;

    public ConsultamedicaPK() {
    }

    public ConsultamedicaPK(int conMedId, int turnoturid) {
        this.conMedId = conMedId;
        this.turnoturid = turnoturid;
    }

    public int getConMedId() {
        return conMedId;
    }

    public void setConMedId(int conMedId) {
        this.conMedId = conMedId;
    }

    public int getTurnoturid() {
        return turnoturid;
    }

    public void setTurnoturid(int turnoturid) {
        this.turnoturid = turnoturid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) conMedId;
        hash += (int) turnoturid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultamedicaPK)) {
            return false;
        }
        ConsultamedicaPK other = (ConsultamedicaPK) object;
        if (this.conMedId != other.conMedId) {
            return false;
        }
        if (this.turnoturid != other.turnoturid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.ConsultamedicaPK[ conMedId=" + conMedId + ", turnoturid=" + turnoturid + " ]";
    }
    
}
