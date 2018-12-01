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

/**
 *
 * @author jose
 */
public class TicketsDao {
    public List<AtTicket> getTickets() {
        // logica para obtener tickets de bd
        AtTicket ticket = new AtTicket("Navegacion", "No puedo ver la pagina del banguat", "C", new Date());
        List<AtTicket> tickets = new ArrayList<>();
        tickets.add(ticket);
        return tickets;
    }
}
