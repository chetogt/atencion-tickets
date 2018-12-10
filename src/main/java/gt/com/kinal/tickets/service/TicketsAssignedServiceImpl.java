/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author jose
 */
@Stateful
public class TicketsAssignedServiceImpl {
    List<String> tickets = new ArrayList<>();
    
    public void asignarTicket(String asunto) {
        tickets.add(asunto);
    }
    
    public List<String> ticketsAsignados() {
        return tickets;
    }
}
