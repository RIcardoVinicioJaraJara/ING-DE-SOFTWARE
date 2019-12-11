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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "vacuna_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VacunaFicha.findAll", query = "SELECT v FROM VacunaFicha v")
    , @NamedQuery(name = "VacunaFicha.findByIdVacunaFicha", query = "SELECT v FROM VacunaFicha v WHERE v.idVacunaFicha = :idVacunaFicha")})
public class VacunaFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna_Ficha")
    private Integer idVacunaFicha;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id")
    @ManyToOne(optional = false)
    private Fichamedica fichaMedicaficmedid;
    @JoinColumn(name = "Vacuna_vac_id", referencedColumnName = "vac_id")
    @ManyToOne(optional = false)
    private Vacuna vacunavacid;

    public VacunaFicha() {
    }

    public VacunaFicha(Integer idVacunaFicha) {
        this.idVacunaFicha = idVacunaFicha;
    }

    public Integer getIdVacunaFicha() {
        return idVacunaFicha;
    }

    public void setIdVacunaFicha(Integer idVacunaFicha) {
        this.idVacunaFicha = idVacunaFicha;
    }

    public Fichamedica getFichaMedicaficmedid() {
        return fichaMedicaficmedid;
    }

    public void setFichaMedicaficmedid(Fichamedica fichaMedicaficmedid) {
        this.fichaMedicaficmedid = fichaMedicaficmedid;
    }

    public Vacuna getVacunavacid() {
        return vacunavacid;
    }

    public void setVacunavacid(Vacuna vacunavacid) {
        this.vacunavacid = vacunavacid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacunaFicha != null ? idVacunaFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacunaFicha)) {
            return false;
        }
        VacunaFicha other = (VacunaFicha) object;
        if ((this.idVacunaFicha == null && other.idVacunaFicha != null) || (this.idVacunaFicha != null && !this.idVacunaFicha.equals(other.idVacunaFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.VacunaFicha[ idVacunaFicha=" + idVacunaFicha + " ]";
    }
    
}
