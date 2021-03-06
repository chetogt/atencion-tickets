/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "at_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTicket.findAll", query = "SELECT a FROM AtTicket a")
    , @NamedQuery(name = "AtTicket.findByTicketId", query = "SELECT a FROM AtTicket a WHERE a.ticketId = :ticketId")
    , @NamedQuery(name = "AtTicket.findByAsunto", query = "SELECT a FROM AtTicket a WHERE a.asunto = :asunto")
    , @NamedQuery(name = "AtTicket.findByDescripcion", query = "SELECT a FROM AtTicket a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AtTicket.findByEstado", query = "SELECT a FROM AtTicket a WHERE a.estado = :estado")
    , @NamedQuery(name = "AtTicket.findByFechaCreacion", query = "SELECT a FROM AtTicket a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "AtTicket.findByFechaSolucion", query = "SELECT a FROM AtTicket a WHERE a.fechaSolucion = :fechaSolucion")})
public class AtTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @Column(name = "asunto", nullable=false, length=50)
    private String asunto;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable=false, length=50)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado", nullable=false)
    private String estado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_solucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolucion;
    @JoinColumn(name = "tecnico_id", referencedColumnName = "tecnico_id")
    @ManyToOne
    private AtTecnico tecnico;

    public AtTicket() {
    }

    public AtTicket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public AtTicket(Integer ticketId, String asunto, String descripcion, String estado) {
        this.ticketId = ticketId;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public AtTicket(String asunto, String descripcion, String estado, Date fechaCreacion) {
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public AtTecnico getTecnico() {
        return tecnico;
    }

    public void setTecnicoId(AtTecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTicket)) {
            return false;
        }
        AtTicket other = (AtTicket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtTicket[ ticketId=" + ticketId + " ]";
    }
    
}
