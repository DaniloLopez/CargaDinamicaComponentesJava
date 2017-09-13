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
@Table(name = "sgd_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgdEstudiante.findAll", query = "SELECT s FROM SgdEstudiante s"),
    @NamedQuery(name = "SgdEstudiante.findByIdx", query = "SELECT s FROM SgdEstudiante s WHERE s.idx = :idx"),
    @NamedQuery(name = "SgdEstudiante.findByNombre", query = "SELECT s FROM SgdEstudiante s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SgdEstudiante.findByApellido", query = "SELECT s FROM SgdEstudiante s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "SgdEstudiante.findByTotalCreditos", query = "SELECT s FROM SgdEstudiante s WHERE s.totalCreditos = :totalCreditos")})
public class SgdEstudiante implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "total_creditos")
    private Integer totalCreditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgdEstudianteIdx")
    private List<SgdDocumento> sgdDocumentoList;

    public SgdEstudiante() {
    }

    public SgdEstudiante(Integer idx) {
        this.idx = idx;
    }

    public SgdEstudiante(Integer idx, String nombre, String apellido) {
        this.idx = idx;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(Integer totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    @XmlTransient
    public List<SgdDocumento> getSgdDocumentoList() {
        return sgdDocumentoList;
    }

    public void setSgdDocumentoList(List<SgdDocumento> sgdDocumentoList) {
        this.sgdDocumentoList = sgdDocumentoList;
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
        if (!(object instanceof SgdEstudiante)) {
            return false;
        }
        SgdEstudiante other = (SgdEstudiante) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SgdEstudiante[ idx=" + idx + " ]";
    }
    
}
