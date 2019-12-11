/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "certificado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c")
    , @NamedQuery(name = "Certificado.findByCerId", query = "SELECT c FROM Certificado c WHERE c.cerId = :cerId")
    , @NamedQuery(name = "Certificado.findByDescripcion", query = "SELECT c FROM Certificado c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Certificado.findByDesde", query = "SELECT c FROM Certificado c WHERE c.desde = :desde")
    , @NamedQuery(name = "Certificado.findByHasta", query = "SELECT c FROM Certificado c WHERE c.hasta = :hasta")})
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cer_id")
    private Integer cerId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @JoinColumn(name = "ConsultaMedica_con_med_id", referencedColumnName = "con_med_id")
    @ManyToOne(optional = false)
    private Consultamedica consultaMedicaconmedid;

    public Certificado() {
    }

    public Certificado(Integer cerId) {
        this.cerId = cerId;
    }

    public Integer getCerId() {
        return cerId;
    }

    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Consultamedica getConsultaMedicaconmedid() {
        return consultaMedicaconmedid;
    }

    public void setConsultaMedicaconmedid(Consultamedica consultaMedicaconmedid) {
        this.consultaMedicaconmedid = consultaMedicaconmedid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cerId != null ? cerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificado)) {
            return false;
        }
        Certificado other = (Certificado) object;
        if ((this.cerId == null && other.cerId != null) || (this.cerId != null && !this.cerId.equals(other.cerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Certificado[ cerId=" + cerId + " ]";
    }
    
}
