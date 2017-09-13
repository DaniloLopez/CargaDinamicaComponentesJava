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
@Table(name = "sgd_datos_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdDatosDocumento.findAll", query = "SELECT s FROM SgdDatosDocumento s"),
    @NamedQuery(name = "SgdDatosDocumento.findByIdx", query = "SELECT s FROM SgdDatosDocumento s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdDatosDocumento.findByNombre", query = "SELECT s FROM SgdDatosDocumento s WHERE s.nombre = :nombre")})
public class SgdDatosDocumento implements Serializable {

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
    @JoinColumn(name = "sgd_campos_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdCamposDocumento sgdCamposDocumentoIdx;
    @JoinColumn(name = "sgd_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdDocumento sgdDocumentoIdx;
    @JoinColumn(name = "sgd_posgrado_tipo_documento_idx", referencedColumnName = "idx")
    @ManyToOne(optional = false)
    private SgdPosgradoTipoDocumento sgdPosgradoTipoDocumentoIdx;

    public SgdDatosDocumento() {
    }

    public SgdDatosDocumento(Integer idx) {
        this.idx = idx;
    }

    public SgdDatosDocumento(Integer idx, String nombre) {
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

    public SgdCamposDocumento getSgdCamposDocumentoIdx() {
        return sgdCamposDocumentoIdx;
    }

    public void setSgdCamposDocumentoIdx(SgdCamposDocumento sgdCamposDocumentoIdx) {
        this.sgdCamposDocumentoIdx = sgdCamposDocumentoIdx;
    }

    public SgdDocumento getSgdDocumentoIdx() {
        return sgdDocumentoIdx;
    }

    public void setSgdDocumentoIdx(SgdDocumento sgdDocumentoIdx) {
        this.sgdDocumentoIdx = sgdDocumentoIdx;
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
        if (!(object instanceof SgdDatosDocumento)) {
            return false;
        }
        SgdDatosDocumento other = (SgdDatosDocumento) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdDatosDocumento[ idx=" + idx + " ]";
    }
    
}
