/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "recetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recetas.findAll", query = "SELECT r FROM Recetas r")
    , @NamedQuery(name = "Recetas.findByRecId", query = "SELECT r FROM Recetas r WHERE r.recId = :recId")
    , @NamedQuery(name = "Recetas.findByRecDosis", query = "SELECT r FROM Recetas r WHERE r.recDosis = :recDosis")
    , @NamedQuery(name = "Recetas.findByRecFrecuencia", query = "SELECT r FROM Recetas r WHERE r.recFrecuencia = :recFrecuencia")})
public class Recetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_id")
    private Integer recId;
    @Column(name = "rec_dosis")
    private String recDosis;
    @Column(name = "rec_frecuencia")
    private String recFrecuencia;
    @JoinColumn(name = "ConsultaMedica_con_med_id", referencedColumnName = "con_med_id")
    @ManyToOne(optional = false)
    private Consultamedica consultaMedicaconmedid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetasrecid")
    private Collection<Recetamedicamento> recetamedicamentoCollection;

    public Recetas() {
    }

    public Recetas(Integer recId) {
        this.recId = recId;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecDosis() {
        return recDosis;
    }

    public void setRecDosis(String recDosis) {
        this.recDosis = recDosis;
    }

    public String getRecFrecuencia() {
        return recFrecuencia;
    }

    public void setRecFrecuencia(String recFrecuencia) {
        this.recFrecuencia = recFrecuencia;
    }

    public Consultamedica getConsultaMedicaconmedid() {
        return consultaMedicaconmedid;
    }

    public void setConsultaMedicaconmedid(Consultamedica consultaMedicaconmedid) {
        this.consultaMedicaconmedid = consultaMedicaconmedid;
    }

    @XmlTransient
    public Collection<Recetamedicamento> getRecetamedicamentoCollection() {
        return recetamedicamentoCollection;
    }

    public void setRecetamedicamentoCollection(Collection<Recetamedicamento> recetamedicamentoCollection) {
        this.recetamedicamentoCollection = recetamedicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recId != null ? recId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.recId == null && other.recId != null) || (this.recId != null && !this.recId.equals(other.recId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Recetas[ recId=" + recId + " ]";
    }
    
}
