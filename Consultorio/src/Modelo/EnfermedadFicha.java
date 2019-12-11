/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    , @NamedQuery(name = "EnfermedadFicha.findByIdEnfermedadFicha", query = "SELECT e FROM EnfermedadFicha e WHERE e.idEnfermedadFicha = :idEnfermedadFicha")})
public class EnfermedadFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEnfermedad_Ficha")
    private Integer idEnfermedadFicha;
    @JoinColumn(name = "Enfermedad_enf_id", referencedColumnName = "enf_id")
    @ManyToOne(optional = false)
    private Enfermedad enfermedadenfid;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id")
    @ManyToOne(optional = false)
    private Fichamedica fichaMedicaficmedid;

    public EnfermedadFicha() {
    }

    public EnfermedadFicha(Integer idEnfermedadFicha) {
        this.idEnfermedadFicha = idEnfermedadFicha;
    }

    public Integer getIdEnfermedadFicha() {
        return idEnfermedadFicha;
    }

    public void setIdEnfermedadFicha(Integer idEnfermedadFicha) {
        this.idEnfermedadFicha = idEnfermedadFicha;
    }

    public Enfermedad getEnfermedadenfid() {
        return enfermedadenfid;
    }

    public void setEnfermedadenfid(Enfermedad enfermedadenfid) {
        this.enfermedadenfid = enfermedadenfid;
    }

    public Fichamedica getFichaMedicaficmedid() {
        return fichaMedicaficmedid;
    }

    public void setFichaMedicaficmedid(Fichamedica fichaMedicaficmedid) {
        this.fichaMedicaficmedid = fichaMedicaficmedid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfermedadFicha != null ? idEnfermedadFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfermedadFicha)) {
            return false;
        }
        EnfermedadFicha other = (EnfermedadFicha) object;
        if ((this.idEnfermedadFicha == null && other.idEnfermedadFicha != null) || (this.idEnfermedadFicha != null && !this.idEnfermedadFicha.equals(other.idEnfermedadFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EnfermedadFicha[ idEnfermedadFicha=" + idEnfermedadFicha + " ]";
    }
    
}
