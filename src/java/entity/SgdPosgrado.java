/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "sgd_posgrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdPosgrado.findAll", query = "SELECT s FROM SgdPosgrado s"),
    @NamedQuery(name = "SgdPosgrado.findByIdx", query = "SELECT s FROM SgdPosgrado s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdPosgrado.findByNombre", query = "SELECT s FROM SgdPosgrado s WHERE s.nombre = :nombre")})
public class SgdPosgrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idx")
    private Integer idx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdPosgradoIdx")
    private List<SgdPosgradoTipoDocumento> sgdPosgradoTipoDocumentoList;
    @JoinColumn(name = "sgd_facultad_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdFacultad sgdFacultadIdx;

    public SgdPosgrado() {
    }

    public SgdPosgrado(Integer idx) {
        this.idx = idx;
    }

    public SgdPosgrado(Integer idx, String nombre) {
        this.idx = idx;
        this.nombre = nombre;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<SgdPosgradoTipoDocumento> getSgdPosgradoTipoDocumentoList() {
        return sgdPosgradoTipoDocumentoList;
    }

    public void setSgdPosgradoTipoDocumentoList(List<SgdPosgradoTipoDocumento> sgdPosgradoTipoDocumentoList) {
        this.sgdPosgradoTipoDocumentoList = sgdPosgradoTipoDocumentoList;
    }

    public SgdFacultad getSgdFacultadIdx() {
        return sgdFacultadIdx;
    }

    public void setSgdFacultadIdx(SgdFacultad sgdFacultadIdx) {
        this.sgdFacultadIdx = sgdFacultadIdx;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idx != null ? idx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgdPosgrado)) {
            return false;
        }
        SgdPosgrado other = (SgdPosgrado) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdPosgrado[ idx=" + idx + " ]";
    }
    
}
