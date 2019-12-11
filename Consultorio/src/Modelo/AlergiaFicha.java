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
@Table(name = "alergia_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlergiaFicha.findAll", query = "SELECT a FROM AlergiaFicha a")
    , @NamedQuery(name = "AlergiaFicha.findByIdAlergiaFicha", query = "SELECT a FROM AlergiaFicha a WHERE a.idAlergiaFicha = :idAlergiaFicha")})
public class AlergiaFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlergia_Ficha")
    private Integer idAlergiaFicha;
    @JoinColumn(name = "Alergia_ale_id", referencedColumnName = "ale_id")
    @ManyToOne(optional = false)
    private Alergia alergiaaleid;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id")
    @ManyToOne(optional = false)
    private Fichamedica fichaMedicaficmedid;

    public AlergiaFicha() {
    }

    public AlergiaFicha(Integer idAlergiaFicha) {
        this.idAlergiaFicha = idAlergiaFicha;
    }

    public Integer getIdAlergiaFicha() {
        return idAlergiaFicha;
    }

    public void setIdAlergiaFicha(Integer idAlergiaFicha) {
        this.idAlergiaFicha = idAlergiaFicha;
    }

    public Alergia getAlergiaaleid() {
        return alergiaaleid;
    }

    public void setAlergiaaleid(Alergia alergiaaleid) {
        this.alergiaaleid = alergiaaleid;
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
        hash += (idAlergiaFicha != null ? idAlergiaFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlergiaFicha)) {
            return false;
        }
        AlergiaFicha other = (AlergiaFicha) object;
        if ((this.idAlergiaFicha == null && other.idAlergiaFicha != null) || (this.idAlergiaFicha != null && !this.idAlergiaFicha.equals(other.idAlergiaFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.AlergiaFicha[ idAlergiaFicha=" + idAlergiaFicha + " ]";
    }
    
}
