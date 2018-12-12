/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.dao;

import java.util.List;
import java.util.ArrayList;
import gt.com.kinal.tickets.model.AtTicket;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jose
 */
public class TicketsDao {
    @PersistenceContext
    EntityManager em;
    
    public List<AtTicket> getTickets() {
        // logica para obtener tickets de bd
        Query queryTickets = em.createNamedQuery("AtTicket.findAll");
        List<AtTicket> tickets = queryTickets.getResultList();
        
        return tickets;
    }
    
    public AtTicket save(AtTicket ticket) {
        em.persist(ticket);
        return ticket;
    }
    
    public AtTicket get(Integer ticketId) {
        return em.find(AtTicket.class, ticketId);
    }
    
    public List<AtTicket> getTicketsByEstado(String estado) {
        Query queryTickets = em.createNamedQuery("AtTicket.findByEstado");
        queryTickets.setParameter("estado", estado);
        List<AtTicket> tickets = queryTickets.getResultList();
        return tickets;
    }
}
