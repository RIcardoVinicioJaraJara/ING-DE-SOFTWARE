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
public class RecetamedicamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rec_med_id")
    private int recMedId;
    @Basic(optional = false)
    @Column(name = "Medicamento_med_id")
    private int medicamentomedid;
    @Basic(optional = false)
    @Column(name = "Recetas_rec_id")
    private int recetasrecid;

    public RecetamedicamentoPK() {
    }

    public RecetamedicamentoPK(int recMedId, int medicamentomedid, int recetasrecid) {
        this.recMedId = recMedId;
        this.medicamentomedid = medicamentomedid;
        this.recetasrecid = recetasrecid;
    }

    public int getRecMedId() {
        return recMedId;
    }

    public void setRecMedId(int recMedId) {
        this.recMedId = recMedId;
    }

    public int getMedicamentomedid() {
        return medicamentomedid;
    }

    public void setMedicamentomedid(int medicamentomedid) {
        this.medicamentomedid = medicamentomedid;
    }

    public int getRecetasrecid() {
        return recetasrecid;
    }

    public void setRecetasrecid(int recetasrecid) {
        this.recetasrecid = recetasrecid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recMedId;
        hash += (int) medicamentomedid;
        hash += (int) recetasrecid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetamedicamentoPK)) {
            return false;
        }
        RecetamedicamentoPK other = (RecetamedicamentoPK) object;
        if (this.recMedId != other.recMedId) {
            return false;
        }
        if (this.medicamentomedid != other.medicamentomedid) {
            return false;
        }
        if (this.recetasrecid != other.recetasrecid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.RecetamedicamentoPK[ recMedId=" + recMedId + ", medicamentomedid=" + medicamentomedid + ", recetasrecid=" + recetasrecid + " ]";
    }
    
}
