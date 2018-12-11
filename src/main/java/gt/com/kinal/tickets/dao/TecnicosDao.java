/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.dao;

import gt.com.kinal.tickets.model.AtTecnico;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jose
 */
public class TecnicosDao {
    @PersistenceContext
    EntityManager em;
    
    public AtTecnico getTecnicoByEmail(String email) {
        Query query = em.createNamedQuery("AtTecnico.findByEmail");
        query.setParameter("email", email);
        return (AtTecnico) query.getSingleResult();
    }
}
