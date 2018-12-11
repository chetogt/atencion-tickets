/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.soap;

import gt.com.kinal.tickets.domain.Tecnico;
import gt.com.kinal.tickets.service.TecnicosServiceImpl;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 *
 * @author jose
 */
@WebService
public class TicketsSoapResource {
    @Inject
    TecnicosServiceImpl tecnicosService;

    public Integer asignarTickets(Tecnico tecnico) {
        Integer codigoRespuesta = 3;
        codigoRespuesta = tecnicosService.asignTickets(tecnico);
        return codigoRespuesta;
    }
}
