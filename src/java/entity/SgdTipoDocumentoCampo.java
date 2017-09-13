/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danilo
 */
@Entity
@Table(name = "sgd_tipo_documento_campo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdTipoDocumentoCampo.findAll", query = "SELECT s FROM SgdTipoDocumentoCampo s"),
    @NamedQuery(name = "SgdTipoDocumentoCampo.findByIdx", query = "SELECT s FROM SgdTipoDocumentoCampo s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdTipoDocumentoCampo.findByValorCampo", query = "SELECT s FROM SgdTipoDocumentoCampo s WHERE s.valorCampo = :valorCampo"),
    @NamedQuery(name = "SgdTipoDocumentoCampo.findByValidacion", query = "SELECT s FROM SgdTipoDocumentoCampo s WHERE s.validacion = :validacion")})
public class SgdTipoDocumentoCampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idx")
    private Integer idx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "valor_campo")
    private String valorCampo;
    @Size(max = 60)
    @Column(name = "validacion")
    private String validacion;
    @JoinColumn(name = "sgd_campos_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdCamposDocumento sgdCamposDocumentoIdx;
    @JoinColumn(name = "sgd_categoria_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdCategoriaDocumento sgdCategoriaDocumentoIdx;
    @JoinColumn(name = "sgd_posgrado_tipo_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdPosgradoTipoDocumento sgdPosgradoTipoDocumentoIdx;

    public SgdTipoDocumentoCampo() {
    }

    public SgdTipoDocumentoCampo(Integer idx) {
        this.idx = idx;
    }

    public SgdTipoDocumentoCampo(Integer idx, String valorCampo) {
        this.idx = idx;
        this.valorCampo = valorCampo;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getValorCampo() {
        return valorCampo;
    }

    public void setValorCampo(String valorCampo) {
        this.valorCampo = valorCampo;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public SgdCamposDocumento getSgdCamposDocumentoIdx() {
        return sgdCamposDocumentoIdx;
    }

    public void setSgdCamposDocumentoIdx(SgdCamposDocumento sgdCamposDocumentoIdx) {
        this.sgdCamposDocumentoIdx = sgdCamposDocumentoIdx;
    }

    public SgdCategoriaDocumento getSgdCategoriaDocumentoIdx() {
        return sgdCategoriaDocumentoIdx;
    }

    public void setSgdCategoriaDocumentoIdx(SgdCategoriaDocumento sgdCategoriaDocumentoIdx) {
        this.sgdCategoriaDocumentoIdx = sgdCategoriaDocumentoIdx;
    }

    public SgdPosgradoTipoDocumento getSgdPosgradoTipoDocumentoIdx() {
        return sgdPosgradoTipoDocumentoIdx;
    }

    public void setSgdPosgradoTipoDocumentoIdx(SgdPosgradoTipoDocumento sgdPosgradoTipoDocumentoIdx) {
        this.sgdPosgradoTipoDocumentoIdx = sgdPosgradoTipoDocumentoIdx;
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
        if (!(object instanceof SgdTipoDocumentoCampo)) {
            return false;
        }
        SgdTipoDocumentoCampo other = (SgdTipoDocumentoCampo) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdTipoDocumentoCampo[ idx=" + idx + " ]";
    }
    
}
