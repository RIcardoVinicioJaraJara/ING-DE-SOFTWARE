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
@Table(name = "consultaficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaficha.findAll", query = "SELECT c FROM Consultaficha c")
    , @NamedQuery(name = "Consultaficha.findByConFicId", query = "SELECT c FROM Consultaficha c WHERE c.conFicId = :conFicId")})
public class Consultaficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_fic_id")
    private Integer conFicId;
    @JoinColumn(name = "ConsultaMedica_con_med_id", referencedColumnName = "con_med_id")
    @ManyToOne(optional = false)
    private Consultamedica consultaMedicaconmedid;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id")
    @ManyToOne(optional = false)
    private Fichamedica fichaMedicaficmedid;

    public Consultaficha() {
    }

    public Consultaficha(Integer conFicId) {
        this.conFicId = conFicId;
    }

    public Integer getConFicId() {
        return conFicId;
    }

    public void setConFicId(Integer conFicId) {
        this.conFicId = conFicId;
    }

    public Consultamedica getConsultaMedicaconmedid() {
        return consultaMedicaconmedid;
    }

    public void setConsultaMedicaconmedid(Consultamedica consultaMedicaconmedid) {
        this.consultaMedicaconmedid = consultaMedicaconmedid;
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
        hash += (conFicId != null ? conFicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaficha)) {
            return false;
        }
        Consultaficha other = (Consultaficha) object;
        if ((this.conFicId == null && other.conFicId != null) || (this.conFicId != null && !this.conFicId.equals(other.conFicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Consultaficha[ conFicId=" + conFicId + " ]";
    }
    
}
