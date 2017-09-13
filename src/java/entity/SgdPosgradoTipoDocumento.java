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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "sgd_posgrado_tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdPosgradoTipoDocumento.findAll", query = "SELECT s FROM SgdPosgradoTipoDocumento s"),
    @NamedQuery(name = "SgdPosgradoTipoDocumento.findByIdx", query = "SELECT s FROM SgdPosgradoTipoDocumento s WHERE s.idx = :idx")})
public class SgdPosgradoTipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idx")
    private Integer idx;
    @JoinColumn(name = "sgd_posgrado_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdPosgrado sgdPosgradoIdx;
    @JoinColumn(name = "sgd_tipo_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdTipoDocumento sgdTipoDocumentoIdx;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdPosgradoTipoDocumentoIdx")
    private List<SgdDatosDocumento> sgdDatosDocumentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdPosgradoTipoDocumentoIdx")
    private List<SgdTipoDocumentoCampo> sgdTipoDocumentoCampoList;

    public SgdPosgradoTipoDocumento() {
    }

    public SgdPosgradoTipoDocumento(Integer idx) {
        this.idx = idx;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public SgdPosgrado getSgdPosgradoIdx() {
        return sgdPosgradoIdx;
    }

    public void setSgdPosgradoIdx(SgdPosgrado sgdPosgradoIdx) {
        this.sgdPosgradoIdx = sgdPosgradoIdx;
    }

    public SgdTipoDocumento getSgdTipoDocumentoIdx() {
        return sgdTipoDocumentoIdx;
    }

    public void setSgdTipoDocumentoIdx(SgdTipoDocumento sgdTipoDocumentoIdx) {
        this.sgdTipoDocumentoIdx = sgdTipoDocumentoIdx;
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
        if (!(object instanceof SgdPosgradoTipoDocumento)) {
            return false;
        }
        SgdPosgradoTipoDocumento other = (SgdPosgradoTipoDocumento) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdPosgradoTipoDocumento[ idx=" + idx + " ]";
    }
    
}
