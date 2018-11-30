/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "at_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtDepartamento.findAll", query = "SELECT a FROM AtDepartamento a")
    , @NamedQuery(name = "AtDepartamento.findByEmpresaId", query = "SELECT a FROM AtDepartamento a WHERE a.atDepartamentoPK.empresaId = :empresaId")
    , @NamedQuery(name = "AtDepartamento.findByDepartamentoId", query = "SELECT a FROM AtDepartamento a WHERE a.atDepartamentoPK.departamentoId = :departamentoId")
    , @NamedQuery(name = "AtDepartamento.findByNombre", query = "SELECT a FROM AtDepartamento a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtDepartamento.findByTelefono", query = "SELECT a FROM AtDepartamento a WHERE a.telefono = :telefono")})
public class AtDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtDepartamentoPK atDepartamentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;

    public AtDepartamento() {
    }

    public AtDepartamento(AtDepartamentoPK atDepartamentoPK) {
        this.atDepartamentoPK = atDepartamentoPK;
    }

    public AtDepartamento(AtDepartamentoPK atDepartamentoPK, String nombre) {
        this.atDepartamentoPK = atDepartamentoPK;
        this.nombre = nombre;
    }

    public AtDepartamento(int empresaId, int departamentoId) {
        this.atDepartamentoPK = new AtDepartamentoPK(empresaId, departamentoId);
    }

    public AtDepartamentoPK getAtDepartamentoPK() {
        return atDepartamentoPK;
    }

    public void setAtDepartamentoPK(AtDepartamentoPK atDepartamentoPK) {
        this.atDepartamentoPK = atDepartamentoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atDepartamentoPK != null ? atDepartamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtDepartamento)) {
            return false;
        }
        AtDepartamento other = (AtDepartamento) object;
        if ((this.atDepartamentoPK == null && other.atDepartamentoPK != null) || (this.atDepartamentoPK != null && !this.atDepartamentoPK.equals(other.atDepartamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtDepartamento[ atDepartamentoPK=" + atDepartamentoPK + " ]";
    }
    
}
