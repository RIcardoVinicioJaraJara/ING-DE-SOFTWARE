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
@Table(name = "alergia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alergia.findAll", query = "SELECT a FROM Alergia a")
    , @NamedQuery(name = "Alergia.findByAleId", query = "SELECT a FROM Alergia a WHERE a.aleId = :aleId")
    , @NamedQuery(name = "Alergia.findByAleTipo", query = "SELECT a FROM Alergia a WHERE a.aleTipo = :aleTipo")
    , @NamedQuery(name = "Alergia.findByAleDescripcion", query = "SELECT a FROM Alergia a WHERE a.aleDescripcion = :aleDescripcion")})
public class Alergia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ale_id")
    private Integer aleId;
    @Column(name = "ale_tipo")
    private String aleTipo;
    @Column(name = "ale_descripcion")
    private String aleDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alergiaaleid")
    private Collection<AlergiaFicha> alergiaFichaCollection;

    public Alergia() {
    }

    public Alergia(Integer aleId) {
        this.aleId = aleId;
    }

    public Integer getAleId() {
        return aleId;
    }

    public void setAleId(Integer aleId) {
        this.aleId = aleId;
    }

    public String getAleTipo() {
        return aleTipo;
    }

    public void setAleTipo(String aleTipo) {
        this.aleTipo = aleTipo;
    }

    public String getAleDescripcion() {
        return aleDescripcion;
    }

    public void setAleDescripcion(String aleDescripcion) {
        this.aleDescripcion = aleDescripcion;
    }

    @XmlTransient
    public Collection<AlergiaFicha> getAlergiaFichaCollection() {
        return alergiaFichaCollection;
    }

    public void setAlergiaFichaCollection(Collection<AlergiaFicha> alergiaFichaCollection) {
        this.alergiaFichaCollection = alergiaFichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aleId != null ? aleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergia)) {
            return false;
        }
        Alergia other = (Alergia) object;
        if ((this.aleId == null && other.aleId != null) || (this.aleId != null && !this.aleId.equals(other.aleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Alergia[ aleId=" + aleId + " ]";
    }
    
}
