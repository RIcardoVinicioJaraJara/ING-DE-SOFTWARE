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
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
    , @NamedQuery(name = "Turno.findByTurId", query = "SELECT t FROM Turno t WHERE t.turnoPK.turId = :turId")
    , @NamedQuery(name = "Turno.findByTurHora", query = "SELECT t FROM Turno t WHERE t.turHora = :turHora")
    , @NamedQuery(name = "Turno.findByTurFecha", query = "SELECT t FROM Turno t WHERE t.turFecha = :turFecha")
    , @NamedQuery(name = "Turno.findByMedicomedid", query = "SELECT t FROM Turno t WHERE t.turnoPK.medicomedid = :medicomedid")
    , @NamedQuery(name = "Turno.findByPacientepacid", query = "SELECT t FROM Turno t WHERE t.turnoPK.pacientepacid = :pacientepacid")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnoPK turnoPK;
    @Column(name = "tur_hora")
    @Temporal(TemporalType.DATE)
    private Date turHora;
    @Column(name = "tur_fecha")
    @Temporal(TemporalType.DATE)
    private Date turFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turno")
    private Collection<Consultamedica> consultamedicaCollection;
    @JoinColumn(name = "Medico_med_id", referencedColumnName = "med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "Paciente_pac_id", referencedColumnName = "pac_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Turno() {
    }

    public Turno(TurnoPK turnoPK) {
        this.turnoPK = turnoPK;
    }

    public Turno(int turId, int medicomedid, int pacientepacid) {
        this.turnoPK = new TurnoPK(turId, medicomedid, pacientepacid);
    }

    public TurnoPK getTurnoPK() {
        return turnoPK;
    }

    public void setTurnoPK(TurnoPK turnoPK) {
        this.turnoPK = turnoPK;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnoPK != null ? turnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.turnoPK == null && other.turnoPK != null) || (this.turnoPK != null && !this.turnoPK.equals(other.turnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Turno[ turnoPK=" + turnoPK + " ]";
    }
    
}
