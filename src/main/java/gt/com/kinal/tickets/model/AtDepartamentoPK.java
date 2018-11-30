/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jose
 */
@Embeddable
public class AtDepartamentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_id")
    private int empresaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departamento_id")
    private int departamentoId;

    public AtDepartamentoPK() {
    }

    public AtDepartamentoPK(int empresaId, int departamentoId) {
        this.empresaId = empresaId;
        this.departamentoId = departamentoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresaId;
        hash += (int) departamentoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtDepartamentoPK)) {
            return false;
        }
        AtDepartamentoPK other = (AtDepartamentoPK) object;
        if (this.empresaId != other.empresaId) {
            return false;
        }
        if (this.departamentoId != other.departamentoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtDepartamentoPK[ empresaId=" + empresaId + ", departamentoId=" + departamentoId + " ]";
    }
    
}
