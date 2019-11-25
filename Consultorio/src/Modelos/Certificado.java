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
@Table(name = "certificado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c")
    , @NamedQuery(name = "Certificado.findByCerId", query = "SELECT c FROM Certificado c WHERE c.certificadoPK.cerId = :cerId")
    , @NamedQuery(name = "Certificado.findByConsultaMedicaconmedid", query = "SELECT c FROM Certificado c WHERE c.certificadoPK.consultaMedicaconmedid = :consultaMedicaconmedid")})
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CertificadoPK certificadoPK;
    @JoinColumn(name = "ConsultaMedica_con_med_id", referencedColumnName = "con_med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consultamedica consultamedica;

    public Certificado() {
    }

    public Certificado(CertificadoPK certificadoPK) {
        this.certificadoPK = certificadoPK;
    }

    public Certificado(int cerId, int consultaMedicaconmedid) {
        this.certificadoPK = new CertificadoPK(cerId, consultaMedicaconmedid);
    }

    public CertificadoPK getCertificadoPK() {
        return certificadoPK;
    }

    public void setCertificadoPK(CertificadoPK certificadoPK) {
        this.certificadoPK = certificadoPK;
    }

    public Consultamedica getConsultamedica() {
        return consultamedica;
    }

    public void setConsultamedica(Consultamedica consultamedica) {
        this.consultamedica = consultamedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificadoPK != null ? certificadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificado)) {
            return false;
        }
        Certificado other = (Certificado) object;
        if ((this.certificadoPK == null && other.certificadoPK != null) || (this.certificadoPK != null && !this.certificadoPK.equals(other.certificadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Certificado[ certificadoPK=" + certificadoPK + " ]";
    }
    
}
