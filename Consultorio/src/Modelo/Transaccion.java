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
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByTraId", query = "SELECT t FROM Transaccion t WHERE t.traId = :traId")
    , @NamedQuery(name = "Transaccion.findByTraTotal", query = "SELECT t FROM Transaccion t WHERE t.traTotal = :traTotal")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tra_id")
    private Integer traId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tra_total")
    private Double traTotal;
    @JoinColumn(name = "Cuenta_cue_id1", referencedColumnName = "cue_id")
    @ManyToOne(optional = false)
    private Cuenta cuentacueid1;

    public Transaccion() {
    }

    public Transaccion(Integer traId) {
        this.traId = traId;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public Double getTraTotal() {
        return traTotal;
    }

    public void setTraTotal(Double traTotal) {
        this.traTotal = traTotal;
    }

    public Cuenta getCuentacueid1() {
        return cuentacueid1;
    }

    public void setCuentacueid1(Cuenta cuentacueid1) {
        this.cuentacueid1 = cuentacueid1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Transaccion[ traId=" + traId + " ]";
    }
    
}
