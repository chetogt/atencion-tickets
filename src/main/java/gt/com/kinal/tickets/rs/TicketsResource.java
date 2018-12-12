/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.rs;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.service.TicketsServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jose
 */
@Path("tickets")
public class TicketsResource {
    @Inject
    TicketsServiceImpl ticketsService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AtTicket> getTickets(@HeaderParam(value="auth") String authorization, @QueryParam(value="estado") String estado) {
        List<AtTicket> tickets = new ArrayList<>();
        if(authorization != null && authorization.equals("ABCDEFGHIJK")) {
            if(estado != null) {
                tickets = ticketsService.getTicketsByEstado(estado);
            } else {
                tickets = ticketsService.getTickets();
            }
        }

        return tickets;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AtTicket createTicket(AtTicket ticket) {
        return ticketsService.createTicket(ticket);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AtTicket getTicket(@PathParam(value="id") Integer idTicket) {
        return ticketsService.getTicket(idTicket);
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AtTicket updateTicket(@PathParam(value="id") Integer idTicket, AtTicket ticket) {
        return ticketsService.updateTicket(idTicket, ticket);
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AtTicket closeTicket(@PathParam(value="id") Integer idTicket) {
        return ticketsService.closeTicket(idTicket);
    }
}
