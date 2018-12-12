/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import gt.com.kinal.tickets.dao.TicketsDao;
import gt.com.kinal.tickets.model.AtTicket;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jose
 */
@Stateless
public class TicketsServiceImpl {
    @Inject
    TicketsDao ticketsDao;

    public List<AtTicket> getTickets() {
        return ticketsDao.getTickets();
    }
    
    public AtTicket createTicket(AtTicket ticket) {
        return ticketsDao.save(ticket);
    }

    public AtTicket closeTicket(Integer ticketId) {
        AtTicket ticket = ticketsDao.get(ticketId);
        ticket.setEstado("R");
        return ticket;
    }
    
    public AtTicket getTicket(Integer id) {
        return ticketsDao.get(id);
    }
    
    public AtTicket updateTicket(Integer id, AtTicket ticket) {
        // obtener ticket original
        AtTicket ticketEncontrado = ticketsDao.get(id);
        // comparar atributos para encontrar cambios
        // aplicar cambios
        ticketEncontrado.setAsunto(ticket.getAsunto());
        ticketEncontrado.setDescripcion(ticket.getDescripcion());
        return ticketEncontrado;
    }

    public List<AtTicket> getTicketsByEstado(String estado) {
        return ticketsDao.getTicketsByEstado(estado);
    }
}
