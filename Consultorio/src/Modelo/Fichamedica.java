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
@Table(name = "fichamedica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichamedica.findAll", query = "SELECT f FROM Fichamedica f")
    , @NamedQuery(name = "Fichamedica.findByFicMedId", query = "SELECT f FROM Fichamedica f WHERE f.ficMedId = :ficMedId")
    , @NamedQuery(name = "Fichamedica.findByFicMedFecha", query = "SELECT f FROM Fichamedica f WHERE f.ficMedFecha = :ficMedFecha")
    , @NamedQuery(name = "Fichamedica.findByFicMedHora", query = "SELECT f FROM Fichamedica f WHERE f.ficMedHora = :ficMedHora")
    , @NamedQuery(name = "Fichamedica.findByFicMedGrupoSanguineo", query = "SELECT f FROM Fichamedica f WHERE f.ficMedGrupoSanguineo = :ficMedGrupoSanguineo")
    , @NamedQuery(name = "Fichamedica.findByFicMedDiscapacidad", query = "SELECT f FROM Fichamedica f WHERE f.ficMedDiscapacidad = :ficMedDiscapacidad")})
public class Fichamedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fic_med_id")
    private Integer ficMedId;
    @Column(name = "fic_med_fecha")
    @Temporal(TemporalType.DATE)
    private Date ficMedFecha;
    @Column(name = "fic_med_hora")
    @Temporal(TemporalType.DATE)
    private Date ficMedHora;
    @Column(name = "fic_med_grupo_sanguineo")
    private String ficMedGrupoSanguineo;
    @Column(name = "fic_med_discapacidad")
    private String ficMedDiscapacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaMedicaficmedid")
    private Collection<Consultaficha> consultafichaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaMedicaficmedid")
    private Collection<VacunaFicha> vacunaFichaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaMedicaficmedid")
    private Collection<AlergiaFicha> alergiaFichaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaMedicaficmedid")
    private Collection<EnfermedadFicha> enfermedadFichaCollection;

    public Fichamedica() {
    }

    public Fichamedica(Integer ficMedId) {
        this.ficMedId = ficMedId;
    }

    public Integer getFicMedId() {
        return ficMedId;
    }

    public void setFicMedId(Integer ficMedId) {
        this.ficMedId = ficMedId;
    }

    public Date getFicMedFecha() {
        return ficMedFecha;
    }

    public void setFicMedFecha(Date ficMedFecha) {
        this.ficMedFecha = ficMedFecha;
    }

    public Date getFicMedHora() {
        return ficMedHora;
    }

    public void setFicMedHora(Date ficMedHora) {
        this.ficMedHora = ficMedHora;
    }

    public String getFicMedGrupoSanguineo() {
        return ficMedGrupoSanguineo;
    }

    public void setFicMedGrupoSanguineo(String ficMedGrupoSanguineo) {
        this.ficMedGrupoSanguineo = ficMedGrupoSanguineo;
    }

    public String getFicMedDiscapacidad() {
        return ficMedDiscapacidad;
    }

    public void setFicMedDiscapacidad(String ficMedDiscapacidad) {
        this.ficMedDiscapacidad = ficMedDiscapacidad;
    }

    @XmlTransient
    public Collection<Consultaficha> getConsultafichaCollection() {
        return consultafichaCollection;
    }

    public void setConsultafichaCollection(Collection<Consultaficha> consultafichaCollection) {
        this.consultafichaCollection = consultafichaCollection;
    }

    @XmlTransient
    public Collection<VacunaFicha> getVacunaFichaCollection() {
        return vacunaFichaCollection;
    }

    public void setVacunaFichaCollection(Collection<VacunaFicha> vacunaFichaCollection) {
        this.vacunaFichaCollection = vacunaFichaCollection;
    }

    @XmlTransient
    public Collection<AlergiaFicha> getAlergiaFichaCollection() {
        return alergiaFichaCollection;
    }

    public void setAlergiaFichaCollection(Collection<AlergiaFicha> alergiaFichaCollection) {
        this.alergiaFichaCollection = alergiaFichaCollection;
    }

    @XmlTransient
    public Collection<EnfermedadFicha> getEnfermedadFichaCollection() {
        return enfermedadFichaCollection;
    }

    public void setEnfermedadFichaCollection(Collection<EnfermedadFicha> enfermedadFichaCollection) {
        this.enfermedadFichaCollection = enfermedadFichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ficMedId != null ? ficMedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichamedica)) {
            return false;
        }
        Fichamedica other = (Fichamedica) object;
        if ((this.ficMedId == null && other.ficMedId != null) || (this.ficMedId != null && !this.ficMedId.equals(other.ficMedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Fichamedica[ ficMedId=" + ficMedId + " ]";
    }
    
}
