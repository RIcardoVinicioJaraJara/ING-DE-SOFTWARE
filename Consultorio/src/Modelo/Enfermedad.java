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
@Table(name = "enfermedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedad.findAll", query = "SELECT e FROM Enfermedad e")
    , @NamedQuery(name = "Enfermedad.findByEnfId", query = "SELECT e FROM Enfermedad e WHERE e.enfId = :enfId")
    , @NamedQuery(name = "Enfermedad.findByEnfTipo", query = "SELECT e FROM Enfermedad e WHERE e.enfTipo = :enfTipo")})
public class Enfermedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enf_id")
    private Integer enfId;
    @Column(name = "enf_tipo")
    private String enfTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enfermedadenfid")
    private Collection<EnfermedadFicha> enfermedadFichaCollection;

    public Enfermedad() {
    }

    public Enfermedad(Integer enfId) {
        this.enfId = enfId;
    }

    public Integer getEnfId() {
        return enfId;
    }

    public void setEnfId(Integer enfId) {
        this.enfId = enfId;
    }

    public String getEnfTipo() {
        return enfTipo;
    }

    public void setEnfTipo(String enfTipo) {
        this.enfTipo = enfTipo;
    }

    @XmlTransient
    public Collection<EnfermedadFicha> getEnfermedadFichaCollection() {
        return enfermedadFichaCollection;
    }

    public void setEnfermedadFichaCollection(Collection<EnfermedadFicha> enfermedadFichaCollection) {
        this.enfermedadFichaCollection = enfermedadFichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enfId != null ? enfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedad)) {
            return false;
        }
        Enfermedad other = (Enfermedad) object;
        if ((this.enfId == null && other.enfId != null) || (this.enfId != null && !this.enfId.equals(other.enfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Enfermedad[ enfId=" + enfId + " ]";
    }
    
}
