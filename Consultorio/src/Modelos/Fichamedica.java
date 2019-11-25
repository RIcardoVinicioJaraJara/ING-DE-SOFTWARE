/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

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
@Table(name = "fichamedica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichamedica.findAll", query = "SELECT f FROM Fichamedica f")
    , @NamedQuery(name = "Fichamedica.findByFicMedId", query = "SELECT f FROM Fichamedica f WHERE f.ficMedId = :ficMedId")})
public class Fichamedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fic_med_id")
    private Integer ficMedId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichamedica")
    private Collection<Consultaficha> consultafichaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichamedica")
    private Collection<EnfermedadFicha> enfermedadFichaCollection;

    public Fichamedica() {
    }

    public Fichamedica(Integer ficMedId) {
        this.ficMedId = ficMedId;
    }

    public Integer getFicMedId() {
        return ficMedId;
    }

    public void setFicMedId(Integer ficMedId) {
        this.ficMedId = ficMedId;
    }

    @XmlTransient
    public Collection<Consultaficha> getConsultafichaCollection() {
        return consultafichaCollection;
    }

    public void setConsultafichaCollection(Collection<Consultaficha> consultafichaCollection) {
        this.consultafichaCollection = consultafichaCollection;
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
        hash += (ficMedId != null ? ficMedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichamedica)) {
            return false;
        }
        Fichamedica other = (Fichamedica) object;
        if ((this.ficMedId == null && other.ficMedId != null) || (this.ficMedId != null && !this.ficMedId.equals(other.ficMedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Fichamedica[ ficMedId=" + ficMedId + " ]";
    }
    
}
