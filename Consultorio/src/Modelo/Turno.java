/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
    , @NamedQuery(name = "Turno.findByTurId", query = "SELECT t FROM Turno t WHERE t.turId = :turId")
    , @NamedQuery(name = "Turno.findByTurHora", query = "SELECT t FROM Turno t WHERE t.turHora = :turHora")
    , @NamedQuery(name = "Turno.findByTurFecha", query = "SELECT t FROM Turno t WHERE t.turFecha = :turFecha")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tur_id")
    private Integer turId;
    @Column(name = "tur_hora")
    @Temporal(TemporalType.DATE)
    private Date turHora;
    @Column(name = "tur_fecha")
    @Temporal(TemporalType.DATE)
    private Date turFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnoturid")
    private Collection<Consultamedica> consultamedicaCollection;
    @JoinColumn(name = "Medico_med_id1", referencedColumnName = "med_id")
    @ManyToOne(optional = false)
    private Medico medicomedid1;
    @JoinColumn(name = "Paciente_pac_id", referencedColumnName = "pac_id")
    @ManyToOne(optional = false)
    private Paciente pacientepacid;

    public Turno() {
    }

    public Turno(Integer turId) {
        this.turId = turId;
    }

    public Integer getTurId() {
        return turId;
    }

    public void setTurId(Integer turId) {
        this.turId = turId;
    }

    public Date getTurHora() {
        return turHora;
    }

    public void setTurHora(Date turHora) {
        this.turHora = turHora;
    }

    public Date getTurFecha() {
        return turFecha;
    }

    public void setTurFecha(Date turFecha) {
        this.turFecha = turFecha;
    }

    @XmlTransient
    public Collection<Consultamedica> getConsultamedicaCollection() {
        return consultamedicaCollection;
    }

    public void setConsultamedicaCollection(Collection<Consultamedica> consultamedicaCollection) {
        this.consultamedicaCollection = consultamedicaCollection;
    }

    public Medico getMedicomedid1() {
        return medicomedid1;
    }

    public void setMedicomedid1(Medico medicomedid1) {
        this.medicomedid1 = medicomedid1;
    }

    public Paciente getPacientepacid() {
        return pacientepacid;
    }

    public void setPacientepacid(Paciente pacientepacid) {
        this.pacientepacid = pacientepacid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turId != null ? turId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.turId == null && other.turId != null) || (this.turId != null && !this.turId.equals(other.turId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Turno[ turId=" + turId + " ]";
    }
    
}
