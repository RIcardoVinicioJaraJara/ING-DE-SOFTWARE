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
@Table(name = "consultaficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaficha.findAll", query = "SELECT c FROM Consultaficha c")
    , @NamedQuery(name = "Consultaficha.findByConFicId", query = "SELECT c FROM Consultaficha c WHERE c.consultafichaPK.conFicId = :conFicId")
    , @NamedQuery(name = "Consultaficha.findByConsultaMedicaconmedid", query = "SELECT c FROM Consultaficha c WHERE c.consultafichaPK.consultaMedicaconmedid = :consultaMedicaconmedid")
    , @NamedQuery(name = "Consultaficha.findByFichaMedicaficmedid", query = "SELECT c FROM Consultaficha c WHERE c.consultafichaPK.fichaMedicaficmedid = :fichaMedicaficmedid")})
public class Consultaficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultafichaPK consultafichaPK;
    @JoinColumn(name = "ConsultaMedica_con_med_id", referencedColumnName = "con_med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consultamedica consultamedica;
    @JoinColumn(name = "FichaMedica_fic_med_id", referencedColumnName = "fic_med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fichamedica fichamedica;

    public Consultaficha() {
    }

    public Consultaficha(ConsultafichaPK consultafichaPK) {
        this.consultafichaPK = consultafichaPK;
    }

    public Consultaficha(int conFicId, int consultaMedicaconmedid, int fichaMedicaficmedid) {
        this.consultafichaPK = new ConsultafichaPK(conFicId, consultaMedicaconmedid, fichaMedicaficmedid);
    }

    public ConsultafichaPK getConsultafichaPK() {
        return consultafichaPK;
    }

    public void setConsultafichaPK(ConsultafichaPK consultafichaPK) {
        this.consultafichaPK = consultafichaPK;
    }

    public Consultamedica getConsultamedica() {
        return consultamedica;
    }

    public void setConsultamedica(Consultamedica consultamedica) {
        this.consultamedica = consultamedica;
    }

    public Fichamedica getFichamedica() {
        return fichamedica;
    }

    public void setFichamedica(Fichamedica fichamedica) {
        this.fichamedica = fichamedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultafichaPK != null ? consultafichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaficha)) {
            return false;
        }
        Consultaficha other = (Consultaficha) object;
        if ((this.consultafichaPK == null && other.consultafichaPK != null) || (this.consultafichaPK != null && !this.consultafichaPK.equals(other.consultafichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Consultaficha[ consultafichaPK=" + consultafichaPK + " ]";
    }
    
}
