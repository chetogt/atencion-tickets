/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.model.AtTecnico;
import gt.com.kinal.tickets.service.TicketsServiceImpl;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jose
 */
public class PruebaTickets {
    TicketsServiceImpl ticketsService;
    
    public void probarEjb() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (SeContainer initialize = initializer.initialize()) {
            Instance<TicketsServiceImpl> instance = initialize.select(TicketsServiceImpl.class);

            TicketsServiceImpl ticketsService = instance.get();
            List<AtTicket> tickets = ticketsService.getTickets();
            System.out.println("Tickets encontrados: " + tickets.size());
        }
    }
    
    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        // todo lo que se encuentra acá está dentro de la transacción
        // INSERT
        AtTicket ticket = new AtTicket("Navegacion", "No puedo ingresar a pagina de Banguat (DEL)", "C", new Date());
        em.persist(ticket);
        
        // UPDATE
        AtTecnico tecnico = new AtTecnico("Jose Cordova", "jose@correo.com");
        em.persist(tecnico);
        ticket.setTecnicoId(tecnico);
        ticket.setEstado("A");
        
        // DELETE
        em.remove(ticket);
        
        // consulta utilizando NamedQueries
        Query queryTickets = em.createNamedQuery("AtTicket.findAll");
        List<AtTicket> tickets = queryTickets.getResultList();
        System.out.println("Tickets encontrados: " + tickets.size());
        
        // consulta utilizando dinamic queries
        String strQuery = "SELECT a FROM AtTicket a WHERE ";
        String strWhere = "a.estado = :estado";
        Long tecnicoId = 1L;
        if(tecnicoId != null) {
            strWhere += " AND a.tecnico.tecnicoId = :tecnicoId";
        }
        Query queryTicketsCreados = em.createQuery(strQuery + strWhere);
        queryTicketsCreados.setParameter("estado", "A");
        if(tecnicoId != null) {
            queryTicketsCreados.setParameter("tecnicoId", tecnicoId);
        }
        List<AtTicket> ticketsCreados = queryTicketsCreados.getResultList();
        System.out.println("Tickets creados: " + ticketsCreados.size());
        
        // consulta utilizando sql nativo
        String strQueryDos = "SELECT * FROM at_ticket WHERE estado = 'A'";
        Query queryTicketsAsignados = em.createNativeQuery(strQueryDos, AtTicket.class);
        List<AtTicket> ticketsAsignados = queryTicketsAsignados.getResultList();
        System.out.println("Tickets asignados: " + ticketsAsignados.size());
        
        // consulta utilizando criteria api
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AtTicket> criteriaQuery = builder.createQuery(AtTicket.class);
        Root<AtTicket> t = criteriaQuery.from(AtTicket.class);
        criteriaQuery.select(t).where(builder.equal(t.get("estado"), "S"));
        
        Query queryTicketsFallidos = em.createQuery(criteriaQuery);
        List<AtTicket> ticketsFallidos = queryTicketsFallidos.getResultList();
        System.out.println("Tickets fallidos: " + ticketsFallidos.size());
        
        tx.commit();
        System.out.println("Transaccion ejecutada");
        em.close();
        emf.close();*/
        
        PruebaTickets app = new PruebaTickets();
        app.probarEjb();
    }
}
