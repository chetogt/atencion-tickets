/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.rs;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.service.TicketsServiceImpl;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Produces(MediaType.TEXT_PLAIN)
    public String getTickets() {
        List<AtTicket> tickets = ticketsService.getTickets();
        return "Tickets encontrados: " + tickets.size();
    }
}
