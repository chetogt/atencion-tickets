/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.rs;

import gt.com.kinal.tickets.service.TicketsAssignedServiceImpl;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author jose
 */
@Path("tickets-state")
@SessionScoped
public class TicketsStateResource implements Serializable {
    @Inject
    TicketsAssignedServiceImpl ticketsAssignedService;
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String asignarTicket(@QueryParam(value = "asunto") String asunto) {
        ticketsAssignedService.asignarTicket(asunto);
        return "Ticket [" + asunto + "] ha sido asignado.";
    }
    
    @GET
    @Path("/asignados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getTicketsAsignados() {
        return ticketsAssignedService.ticketsAsignados();
    }
}
