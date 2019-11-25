/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByMedId", query = "SELECT m FROM Medico m WHERE m.medicoPK.medId = :medId")
    , @NamedQuery(name = "Medico.findByPersonaperid", query = "SELECT m FROM Medico m WHERE m.medicoPK.personaperid = :personaperid")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicoPK medicoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private Collection<Turno> turnoCollection;
    @JoinColumn(name = "Persona_per_id", referencedColumnName = "per_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private Collection<Cuenta> cuentaCollection;

    public Medico() {
    }

    public Medico(MedicoPK medicoPK) {
        this.medicoPK = medicoPK;
    }

    public Medico(int medId, int personaperid) {
        this.medicoPK = new MedicoPK(medId, personaperid);
    }

    public MedicoPK getMedicoPK() {
        return medicoPK;
    }

    public void setMedicoPK(MedicoPK medicoPK) {
        this.medicoPK = medicoPK;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoPK != null ? medicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.medicoPK == null && other.medicoPK != null) || (this.medicoPK != null && !this.medicoPK.equals(other.medicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Medico[ medicoPK=" + medicoPK + " ]";
    }
    
}
