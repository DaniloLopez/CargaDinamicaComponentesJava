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
@Table(name = "sgd_campos_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdCamposDocumento.findAll", query = "SELECT s FROM SgdCamposDocumento s"),
    @NamedQuery(name = "SgdCamposDocumento.findByIdx", query = "SELECT s FROM SgdCamposDocumento s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdCamposDocumento.findByNombre", query = "SELECT s FROM SgdCamposDocumento s WHERE s.nombre = :nombre")})
public class SgdCamposDocumento implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdCamposDocumentoIdx")
    private List<SgdDatosDocumento> sgdDatosDocumentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdCamposDocumentoIdx")
    private List<SgdTipoDocumentoCampo> sgdTipoDocumentoCampoList;

    public SgdCamposDocumento() {
    }

    public SgdCamposDocumento(Integer idx) {
        this.idx = idx;
    }

    public SgdCamposDocumento(Integer idx, String nombre) {
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
    public List<SgdDatosDocumento> getSgdDatosDocumentoList() {
        return sgdDatosDocumentoList;
    }

    public void setSgdDatosDocumentoList(List<SgdDatosDocumento> sgdDatosDocumentoList) {
        this.sgdDatosDocumentoList = sgdDatosDocumentoList;
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
        if (!(object instanceof SgdCamposDocumento)) {
            return false;
        }
        SgdCamposDocumento other = (SgdCamposDocumento) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdCamposDocumento[ idx=" + idx + " ]";
    }
    
}
