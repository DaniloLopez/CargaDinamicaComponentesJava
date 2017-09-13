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
@Table(name = "sgd_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdDocumento.findAll", query = "SELECT s FROM SgdDocumento s"),
    @NamedQuery(name = "SgdDocumento.findByIdx", query = "SELECT s FROM SgdDocumento s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdDocumento.findByNombre", query = "SELECT s FROM SgdDocumento s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SgdDocumento.findByVisado", query = "SELECT s FROM SgdDocumento s WHERE s.visado = :visado"),
    @NamedQuery(name = "SgdDocumento.findByCreditos", query = "SELECT s FROM SgdDocumento s WHERE s.creditos = :creditos"),
    @NamedQuery(name = "SgdDocumento.findBySgdCategoriaIdx", query = "SELECT s FROM SgdDocumento s WHERE s.sgdCategoriaIdx = :sgdCategoriaIdx")})
public class SgdDocumento implements Serializable {

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
    @Column(name = "visado")
    private Boolean visado;
    @Column(name = "creditos")
    private Integer creditos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sgd_categoria_idx")
    private String sgdCategoriaIdx;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdDocumentoIdx")
    private List<SgdDatosDocumento> sgdDatosDocumentoList;
    @JoinColumn(name = "sgd_estudiante_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdEstudiante sgdEstudianteIdx;

    public SgdDocumento() {
    }

    public SgdDocumento(Integer idx) {
        this.idx = idx;
    }

    public SgdDocumento(Integer idx, String nombre, String sgdCategoriaIdx) {
        this.idx = idx;
        this.nombre = nombre;
        this.sgdCategoriaIdx = sgdCategoriaIdx;
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

    public Boolean getVisado() {
        return visado;
    }

    public void setVisado(Boolean visado) {
        this.visado = visado;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getSgdCategoriaIdx() {
        return sgdCategoriaIdx;
    }

    public void setSgdCategoriaIdx(String sgdCategoriaIdx) {
        this.sgdCategoriaIdx = sgdCategoriaIdx;
    }

    @XmlTransient
    public List<SgdDatosDocumento> getSgdDatosDocumentoList() {
        return sgdDatosDocumentoList;
    }

    public void setSgdDatosDocumentoList(List<SgdDatosDocumento> sgdDatosDocumentoList) {
        this.sgdDatosDocumentoList = sgdDatosDocumentoList;
    }

    public SgdEstudiante getSgdEstudianteIdx() {
        return sgdEstudianteIdx;
    }

    public void setSgdEstudianteIdx(SgdEstudiante sgdEstudianteIdx) {
        this.sgdEstudianteIdx = sgdEstudianteIdx;
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
        if (!(object instanceof SgdDocumento)) {
            return false;
        }
        SgdDocumento other = (SgdDocumento) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdDocumento[ idx=" + idx + " ]";
    }
    
}
