/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import gt.com.kinal.tickets.dao.TecnicosDao;
import gt.com.kinal.tickets.dao.TicketsDao;
import gt.com.kinal.tickets.domain.Tecnico;
import gt.com.kinal.tickets.domain.Ticket;
import gt.com.kinal.tickets.model.AtTecnico;
import gt.com.kinal.tickets.model.AtTicket;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author jose
 */
@Stateless
public class TecnicosServiceImpl {
    @Inject
    TecnicosDao tecnicosDao;
    
    @Inject
    TicketsDao ticketsDao;
    
    public Integer asignTickets(Tecnico tecnico) {
        try {
            // buscar al AtTecnico con el correo enviado
            AtTecnico tecnicoEncontrado = tecnicosDao.getTecnicoByEmail(tecnico.getEmail());
            if(tecnicoEncontrado.getTickets() == null) {
                tecnicoEncontrado.setTickets(new ArrayList<>());
            }
            // asignar los tickets a tecnico
            for(Ticket ticket : tecnico.getTickets()) {
                AtTicket nuevoTicket = new AtTicket(ticket.getAsunto(), ticket.getDescripcion(), ticket.getEstado(), ticket.getFechaCreacion());
                ticketsDao.save(nuevoTicket);
                //tecnicoEncontrado.getAtTicketList().add(nuevoTicket);
                nuevoTicket.setTecnicoId(tecnicoEncontrado);
            }
            return 1;
        } catch(NoResultException e) {
            return 2;
        } catch(Exception e) {
            e.printStackTrace();
            return 3;
        }
        // enviar codigos de respuesta
        // 1 - tickets asignados
        // 2 - tecnico no encontrado
        // 3 - error en el servidor
    }
}
