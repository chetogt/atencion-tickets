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
}
