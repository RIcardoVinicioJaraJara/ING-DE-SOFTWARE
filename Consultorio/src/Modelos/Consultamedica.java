/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "consultamedica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultamedica.findAll", query = "SELECT c FROM Consultamedica c")
    , @NamedQuery(name = "Consultamedica.findByConMedId", query = "SELECT c FROM Consultamedica c WHERE c.consultamedicaPK.conMedId = :conMedId")
    , @NamedQuery(name = "Consultamedica.findByConMedHora", query = "SELECT c FROM Consultamedica c WHERE c.conMedHora = :conMedHora")
    , @NamedQuery(name = "Consultamedica.findByConMedFecha", query = "SELECT c FROM Consultamedica c WHERE c.conMedFecha = :conMedFecha")
    , @NamedQuery(name = "Consultamedica.findByTurnoturid", query = "SELECT c FROM Consultamedica c WHERE c.consultamedicaPK.turnoturid = :turnoturid")})
public class Consultamedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultamedicaPK consultamedicaPK;
    @Column(name = "con_med_hora")
    @Temporal(TemporalType.DATE)
    private Date conMedHora;
    @Column(name = "con_med_fecha")
    @Temporal(TemporalType.DATE)
    private Date conMedFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultamedica")
    private Collection<Consultaficha> consultafichaCollection;
    @JoinColumn(name = "Turno_tur_id", referencedColumnName = "tur_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turno turno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultamedica")
    private Collection<Certificado> certificadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultamedica")
    private Collection<Recetas> recetasCollection;

    public Consultamedica() {
    }

    public Consultamedica(ConsultamedicaPK consultamedicaPK) {
        this.consultamedicaPK = consultamedicaPK;
    }

    public Consultamedica(int conMedId, int turnoturid) {
        this.consultamedicaPK = new ConsultamedicaPK(conMedId, turnoturid);
    }

    public ConsultamedicaPK getConsultamedicaPK() {
        return consultamedicaPK;
    }

    public void setConsultamedicaPK(ConsultamedicaPK consultamedicaPK) {
        this.consultamedicaPK = consultamedicaPK;
    }

    public Date getConMedHora() {
        return conMedHora;
    }

    public void setConMedHora(Date conMedHora) {
        this.conMedHora = conMedHora;
    }

    public Date getConMedFecha() {
        return conMedFecha;
    }

    public void setConMedFecha(Date conMedFecha) {
        this.conMedFecha = conMedFecha;
    }

    @XmlTransient
    public Collection<Consultaficha> getConsultafichaCollection() {
        return consultafichaCollection;
    }

    public void setConsultafichaCollection(Collection<Consultaficha> consultafichaCollection) {
        this.consultafichaCollection = consultafichaCollection;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @XmlTransient
    public Collection<Certificado> getCertificadoCollection() {
        return certificadoCollection;
    }

    public void setCertificadoCollection(Collection<Certificado> certificadoCollection) {
        this.certificadoCollection = certificadoCollection;
    }

    @XmlTransient
    public Collection<Recetas> getRecetasCollection() {
        return recetasCollection;
    }

    public void setRecetasCollection(Collection<Recetas> recetasCollection) {
        this.recetasCollection = recetasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultamedicaPK != null ? consultamedicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultamedica)) {
            return false;
        }
        Consultamedica other = (Consultamedica) object;
        if ((this.consultamedicaPK == null && other.consultamedicaPK != null) || (this.consultamedicaPK != null && !this.consultamedicaPK.equals(other.consultamedicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Consultamedica[ consultamedicaPK=" + consultamedicaPK + " ]";
    }
    
}
