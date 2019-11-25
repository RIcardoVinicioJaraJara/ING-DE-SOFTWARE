/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "enfermedad_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnfermedadFicha.findAll", query = "SELECT e FROM EnfermedadFicha e")
    , @NamedQuery(name = "EnfermedadFicha.findByIdEnfermedadFicha", query = "SELECT e FROM EnfermedadFicha e WHERE e.enfermedadFichaPK.idEnfermedadFicha = :idEnfermedadFicha")
    , @NamedQuery(name = "EnfermedadFicha.findByFichaMedicaficmedid", query = "SELECT e FROM EnfermedadFicha e WHERE e.enfermedadFichaPK.fichaMedicaficmedid = :fichaMedicaficmedid")
    , @NamedQuery(name = "EnfermedadFicha.findByEnfermedadenfid", query = "SELECT e FROM EnfermedadFicha e WHERE e.enfermedadFichaPK.enfermedadenfid = :enfermedadenfid")})
public class EnfermedadFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnfermedadFichaPK enfermedadFichaPK;
    @JoinColumn(name = "Enfermedad_enf_id", referencedColumnName = "enf_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Enfermedad enfermedad;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fichamedica fichamedica;

    public EnfermedadFicha() {
    }

    public EnfermedadFicha(EnfermedadFichaPK enfermedadFichaPK) {
        this.enfermedadFichaPK = enfermedadFichaPK;
    }

    public EnfermedadFicha(int idEnfermedadFicha, int fichaMedicaficmedid, int enfermedadenfid) {
        this.enfermedadFichaPK = new EnfermedadFichaPK(idEnfermedadFicha, fichaMedicaficmedid, enfermedadenfid);
    }

    public EnfermedadFichaPK getEnfermedadFichaPK() {
        return enfermedadFichaPK;
    }

    public void setEnfermedadFichaPK(EnfermedadFichaPK enfermedadFichaPK) {
        this.enfermedadFichaPK = enfermedadFichaPK;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Fichamedica getFichamedica() {
        return fichamedica;
    }

    public void setFichamedica(Fichamedica fichamedica) {
        this.fichamedica = fichamedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enfermedadFichaPK != null ? enfermedadFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfermedadFicha)) {
            return false;
        }
        EnfermedadFicha other = (EnfermedadFicha) object;
        if ((this.enfermedadFichaPK == null && other.enfermedadFichaPK != null) || (this.enfermedadFichaPK != null && !this.enfermedadFichaPK.equals(other.enfermedadFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.EnfermedadFicha[ enfermedadFichaPK=" + enfermedadFichaPK + " ]";
    }
    
}
