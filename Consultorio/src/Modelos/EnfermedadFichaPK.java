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
public class EnfermedadFichaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEnfermedad_Ficha")
    private int idEnfermedadFicha;
    @Basic(optional = false)
    @Column(name = "FichaMedica_fic_med_id")
    private int fichaMedicaficmedid;
    @Basic(optional = false)
    @Column(name = "Enfermedad_enf_id")
    private int enfermedadenfid;

    public EnfermedadFichaPK() {
    }

    public EnfermedadFichaPK(int idEnfermedadFicha, int fichaMedicaficmedid, int enfermedadenfid) {
        this.idEnfermedadFicha = idEnfermedadFicha;
        this.fichaMedicaficmedid = fichaMedicaficmedid;
        this.enfermedadenfid = enfermedadenfid;
    }

    public int getIdEnfermedadFicha() {
        return idEnfermedadFicha;
    }

    public void setIdEnfermedadFicha(int idEnfermedadFicha) {
        this.idEnfermedadFicha = idEnfermedadFicha;
    }

    public int getFichaMedicaficmedid() {
        return fichaMedicaficmedid;
    }

    public void setFichaMedicaficmedid(int fichaMedicaficmedid) {
        this.fichaMedicaficmedid = fichaMedicaficmedid;
    }

    public int getEnfermedadenfid() {
        return enfermedadenfid;
    }

    public void setEnfermedadenfid(int enfermedadenfid) {
        this.enfermedadenfid = enfermedadenfid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEnfermedadFicha;
        hash += (int) fichaMedicaficmedid;
        hash += (int) enfermedadenfid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfermedadFichaPK)) {
            return false;
        }
        EnfermedadFichaPK other = (EnfermedadFichaPK) object;
        if (this.idEnfermedadFicha != other.idEnfermedadFicha) {
            return false;
        }
        if (this.fichaMedicaficmedid != other.fichaMedicaficmedid) {
            return false;
        }
        if (this.enfermedadenfid != other.enfermedadenfid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.EnfermedadFichaPK[ idEnfermedadFicha=" + idEnfermedadFicha + ", fichaMedicaficmedid=" + fichaMedicaficmedid + ", enfermedadenfid=" + enfermedadenfid + " ]";
    }
    
}
