/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "recetamedicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recetamedicamento.findAll", query = "SELECT r FROM Recetamedicamento r")
    , @NamedQuery(name = "Recetamedicamento.findByRecMedId", query = "SELECT r FROM Recetamedicamento r WHERE r.recetamedicamentoPK.recMedId = :recMedId")
    , @NamedQuery(name = "Recetamedicamento.findByRecMedDosis", query = "SELECT r FROM Recetamedicamento r WHERE r.recMedDosis = :recMedDosis")
    , @NamedQuery(name = "Recetamedicamento.findByMedicamentomedid", query = "SELECT r FROM Recetamedicamento r WHERE r.recetamedicamentoPK.medicamentomedid = :medicamentomedid")
    , @NamedQuery(name = "Recetamedicamento.findByRecetasrecid", query = "SELECT r FROM Recetamedicamento r WHERE r.recetamedicamentoPK.recetasrecid = :recetasrecid")})
public class Recetamedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecetamedicamentoPK recetamedicamentoPK;
    @Column(name = "rec_med_dosis")
    private String recMedDosis;
    @JoinColumn(name = "Medicamento_med_id", referencedColumnName = "med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "Recetas_rec_id", referencedColumnName = "rec_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recetas recetas;

    public Recetamedicamento() {
    }

    public Recetamedicamento(RecetamedicamentoPK recetamedicamentoPK) {
        this.recetamedicamentoPK = recetamedicamentoPK;
    }

    public Recetamedicamento(int recMedId, int medicamentomedid, int recetasrecid) {
        this.recetamedicamentoPK = new RecetamedicamentoPK(recMedId, medicamentomedid, recetasrecid);
    }

    public RecetamedicamentoPK getRecetamedicamentoPK() {
        return recetamedicamentoPK;
    }

    public void setRecetamedicamentoPK(RecetamedicamentoPK recetamedicamentoPK) {
        this.recetamedicamentoPK = recetamedicamentoPK;
    }

    public String getRecMedDosis() {
        return recMedDosis;
    }

    public void setRecMedDosis(String recMedDosis) {
        this.recMedDosis = recMedDosis;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Recetas getRecetas() {
        return recetas;
    }

    public void setRecetas(Recetas recetas) {
        this.recetas = recetas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recetamedicamentoPK != null ? recetamedicamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetamedicamento)) {
            return false;
        }
        Recetamedicamento other = (Recetamedicamento) object;
        if ((this.recetamedicamentoPK == null && other.recetamedicamentoPK != null) || (this.recetamedicamentoPK != null && !this.recetamedicamentoPK.equals(other.recetamedicamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Recetamedicamento[ recetamedicamentoPK=" + recetamedicamentoPK + " ]";
    }
    
}
