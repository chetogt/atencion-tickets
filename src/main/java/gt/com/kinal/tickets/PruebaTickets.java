/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets;

import gt.com.kinal.tickets.model.AtTicket;
import gt.com.kinal.tickets.model.AtTecnico;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
public class PruebaTickets {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketsPU");
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
        
        tx.commit();
        System.out.println("Transaccion ejecutada");
        em.close();
        emf.close();
    }
}
