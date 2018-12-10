/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.views;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class TicketsBacking {
    String asunto;
    String descripcion;

    public TicketsBacking() {
    }
    
    public String crearTicket() {
	System.out.println("Asunto: " + asunto);
	System.out.println("Descripcion: " + descripcion);
	return "crear-ticket.xhtml";
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
