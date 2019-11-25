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
public class RecetasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rec_id")
    private int recId;
    @Basic(optional = false)
    @Column(name = "ConsultaMedica_id")
    private int consultaMedicaid;

    public RecetasPK() {
    }

    public RecetasPK(int recId, int consultaMedicaid) {
        this.recId = recId;
        this.consultaMedicaid = consultaMedicaid;
    }

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getConsultaMedicaid() {
        return consultaMedicaid;
    }

    public void setConsultaMedicaid(int consultaMedicaid) {
        this.consultaMedicaid = consultaMedicaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recId;
        hash += (int) consultaMedicaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetasPK)) {
            return false;
        }
        RecetasPK other = (RecetasPK) object;
        if (this.recId != other.recId) {
            return false;
        }
        if (this.consultaMedicaid != other.consultaMedicaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.RecetasPK[ recId=" + recId + ", consultaMedicaid=" + consultaMedicaid + " ]";
    }
    
}
