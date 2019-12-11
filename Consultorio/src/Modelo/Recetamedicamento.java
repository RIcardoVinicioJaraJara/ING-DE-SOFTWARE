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
@Table(name = "recetamedicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recetamedicamento.findAll", query = "SELECT r FROM Recetamedicamento r")
    , @NamedQuery(name = "Recetamedicamento.findByRecMedId", query = "SELECT r FROM Recetamedicamento r WHERE r.recMedId = :recMedId")
    , @NamedQuery(name = "Recetamedicamento.findByRecMedDosis", query = "SELECT r FROM Recetamedicamento r WHERE r.recMedDosis = :recMedDosis")})
public class Recetamedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_med_id")
    private Integer recMedId;
    @Column(name = "rec_med_dosis")
    private String recMedDosis;
    @JoinColumn(name = "Medicamento_med_id", referencedColumnName = "med_id")
    @ManyToOne(optional = false)
    private Medicamento medicamentomedid;
    @JoinColumn(name = "Recetas_rec_id", referencedColumnName = "rec_id")
    @ManyToOne(optional = false)
    private Recetas recetasrecid;

    public Recetamedicamento() {
    }

    public Recetamedicamento(Integer recMedId) {
        this.recMedId = recMedId;
    }

    public Integer getRecMedId() {
        return recMedId;
    }

    public void setRecMedId(Integer recMedId) {
        this.recMedId = recMedId;
    }

    public String getRecMedDosis() {
        return recMedDosis;
    }

    public void setRecMedDosis(String recMedDosis) {
        this.recMedDosis = recMedDosis;
    }

    public Medicamento getMedicamentomedid() {
        return medicamentomedid;
    }

    public void setMedicamentomedid(Medicamento medicamentomedid) {
        this.medicamentomedid = medicamentomedid;
    }

    public Recetas getRecetasrecid() {
        return recetasrecid;
    }

    public void setRecetasrecid(Recetas recetasrecid) {
        this.recetasrecid = recetasrecid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recMedId != null ? recMedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetamedicamento)) {
            return false;
        }
        Recetamedicamento other = (Recetamedicamento) object;
        if ((this.recMedId == null && other.recMedId != null) || (this.recMedId != null && !this.recMedId.equals(other.recMedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Recetamedicamento[ recMedId=" + recMedId + " ]";
    }
    
}
