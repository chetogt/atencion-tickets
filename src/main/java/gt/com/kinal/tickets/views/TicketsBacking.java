/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.views;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.service.TicketsServiceImpl;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

    public TicketsBacking() {
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
        
	return "crear-ticket.jsf";
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
}
