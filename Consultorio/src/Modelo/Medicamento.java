/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByMedId", query = "SELECT m FROM Medicamento m WHERE m.medId = :medId")
    , @NamedQuery(name = "Medicamento.findByMedFechaCaducidad", query = "SELECT m FROM Medicamento m WHERE m.medFechaCaducidad = :medFechaCaducidad")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "med_id")
    private Integer medId;
    @Column(name = "med_fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date medFechaCaducidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentomedid")
    private Collection<Recetamedicamento> recetamedicamentoCollection;

    public Medicamento() {
    }

    public Medicamento(Integer medId) {
        this.medId = medId;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public Date getMedFechaCaducidad() {
        return medFechaCaducidad;
    }

    public void setMedFechaCaducidad(Date medFechaCaducidad) {
        this.medFechaCaducidad = medFechaCaducidad;
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
        hash += (medId != null ? medId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.medId == null && other.medId != null) || (this.medId != null && !this.medId.equals(other.medId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Medicamento[ medId=" + medId + " ]";
    }
    
}
