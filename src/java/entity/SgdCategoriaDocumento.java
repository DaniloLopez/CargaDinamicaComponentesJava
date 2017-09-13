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
@Table(name = "sgd_categoria_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdCategoriaDocumento.findAll", query = "SELECT s FROM SgdCategoriaDocumento s"),
    @NamedQuery(name = "SgdCategoriaDocumento.findByIdx", query = "SELECT s FROM SgdCategoriaDocumento s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdCategoriaDocumento.findByNombre", query = "SELECT s FROM SgdCategoriaDocumento s WHERE s.nombre = :nombre")})
public class SgdCategoriaDocumento implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdCategoriaDocumentoIdx")
    private List<SgdTipoDocumentoCampo> sgdTipoDocumentoCampoList;

    public SgdCategoriaDocumento() {
    }

    public SgdCategoriaDocumento(Integer idx) {
        this.idx = idx;
    }

    public SgdCategoriaDocumento(Integer idx, String nombre) {
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
    public List<SgdTipoDocumentoCampo> getSgdTipoDocumentoCampoList() {
        return sgdTipoDocumentoCampoList;
    }

    public void setSgdTipoDocumentoCampoList(List<SgdTipoDocumentoCampo> sgdTipoDocumentoCampoList) {
        this.sgdTipoDocumentoCampoList = sgdTipoDocumentoCampoList;
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
        if (!(object instanceof SgdCategoriaDocumento)) {
            return false;
        }
        SgdCategoriaDocumento other = (SgdCategoriaDocumento) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdCategoriaDocumento[ idx=" + idx + " ]";
    }
    
}
