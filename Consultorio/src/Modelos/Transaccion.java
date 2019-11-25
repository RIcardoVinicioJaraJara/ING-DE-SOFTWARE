/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
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
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByTraId", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.traId = :traId")
    , @NamedQuery(name = "Transaccion.findByCuentacueid", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.cuentacueid = :cuentacueid")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @JoinColumn(name = "Cuenta_cue_id", referencedColumnName = "cue_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(int traId, int cuentacueid) {
        this.transaccionPK = new TransaccionPK(traId, cuentacueid);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
