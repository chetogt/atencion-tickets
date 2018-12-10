/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author jose
 */
@Entity
@Table(name = "at_tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTecnico.findAll", query = "SELECT a FROM AtTecnico a")
    , @NamedQuery(name = "AtTecnico.findByTecnicoId", query = "SELECT a FROM AtTecnico a WHERE a.tecnicoId = :tecnicoId")
    , @NamedQuery(name = "AtTecnico.findByNombre", query = "SELECT a FROM AtTecnico a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtTecnico.findByEmail", query = "SELECT a FROM AtTecnico a WHERE a.email = :email")})
public class AtTecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tecnico_id")
    private Integer tecnicoId;
    @Basic(optional = false)
    @Column(name = "nombre", nullable=false, length=100)
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Column(name = "email", nullable=false, length=100)
    private String email;
    @OneToMany(mappedBy = "tecnico")
    private List<AtTicket> tickets;

    public AtTecnico() {
    }

    public AtTecnico(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public AtTecnico(Integer tecnicoId, String nombre, String email) {
        this.tecnicoId = tecnicoId;
        this.nombre = nombre;
        this.email = email;
    }
    
    public AtTecnico(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Integer getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<AtTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<AtTicket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecnicoId != null ? tecnicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTecnico)) {
            return false;
        }
        AtTecnico other = (AtTecnico) object;
        if ((this.tecnicoId == null && other.tecnicoId != null) || (this.tecnicoId != null && !this.tecnicoId.equals(other.tecnicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtTecnico[ tecnicoId=" + tecnicoId + " ]";
    }
    
}
