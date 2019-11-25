/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")
    , @NamedQuery(name = "Vacuna.findByVacId", query = "SELECT v FROM Vacuna v WHERE v.vacId = :vacId")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vac_id")
    private Integer vacId;

    public Vacuna() {
    }

    public Vacuna(Integer vacId) {
        this.vacId = vacId;
    }

    public Integer getVacId() {
        return vacId;
    }

    public void setVacId(Integer vacId) {
        this.vacId = vacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacId != null ? vacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.vacId == null && other.vacId != null) || (this.vacId != null && !this.vacId.equals(other.vacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Vacuna[ vacId=" + vacId + " ]";
    }
    
}
