/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.views;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.service.TicketsServiceImpl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class TicketsBacking {
    @Inject
    TicketsServiceImpl ticketsService;
    
    String asunto;
    String descripcion;
    List<AtTicket> tickets;

    public TicketsBacking() {
    }
    
    @PostConstruct
    public void inicializarTickets() {
        tickets = ticketsService.getTickets();
    }

    public String crearTicket() {
	// validaciones
        // completar campos obligatorios
        AtTicket ticket = new AtTicket();
        ticket.setAsunto(asunto);
        ticket.setDescripcion(descripcion);
        ticket.setEstado("C");
        ticket.setFechaCreacion(new Date());
        ticketsService.createTicket(ticket);
        // limpiar campos
        asunto = null;
        descripcion = null;
        
        tickets = ticketsService.getTickets();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ticket creado exitosamente"));
        
	return "/protected/listado-tickets.jsf";
    }
    
    public String cerrarTicket() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer ticketId = Integer.valueOf(params.get("ticketId").toString());
        ticketsService.closeTicket(ticketId);

        tickets = ticketsService.getTickets();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ticket cerrado exitosamente"));
        
        return null;
    }
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
          request.logout();
          return "/login.jsf?faces-redirect=true";
        } catch (ServletException e) {
          e.printStackTrace();
          context.addMessage(null, new FacesMessage("Logout failed."));
        }
        return "/protected/listado-tickets.jsf";
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

    public List<AtTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<AtTicket> tickets) {
        this.tickets = tickets;
    }
}
