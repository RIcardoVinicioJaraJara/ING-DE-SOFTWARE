/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Recetas.findByRecId", query = "SELECT r FROM Recetas r WHERE r.recetasPK.recId = :recId")
    , @NamedQuery(name = "Recetas.findByConsultaMedicaid", query = "SELECT r FROM Recetas r WHERE r.recetasPK.consultaMedicaid = :consultaMedicaid")})
public class Recetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecetasPK recetasPK;
    @JoinColumn(name = "ConsultaMedica_id", referencedColumnName = "con_med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consultamedica consultamedica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetas")
    private Collection<Recetamedicamento> recetamedicamentoCollection;

    public Recetas() {
    }

    public Recetas(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public Recetas(int recId, int consultaMedicaid) {
        this.recetasPK = new RecetasPK(recId, consultaMedicaid);
    }

    public RecetasPK getRecetasPK() {
        return recetasPK;
    }

    public void setRecetasPK(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public Consultamedica getConsultamedica() {
        return consultamedica;
    }

    public void setConsultamedica(Consultamedica consultamedica) {
        this.consultamedica = consultamedica;
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
        hash += (recetasPK != null ? recetasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.recetasPK == null && other.recetasPK != null) || (this.recetasPK != null && !this.recetasPK.equals(other.recetasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Recetas[ recetasPK=" + recetasPK + " ]";
    }
    
}
