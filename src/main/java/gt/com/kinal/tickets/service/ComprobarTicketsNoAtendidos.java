/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author jose
 */
@Singleton
public class ComprobarTicketsNoAtendidos {
    @Schedule(second = "*/5", minute = "*", hour = "*", dayOfWeek = "*", persistent = false)
    public void realizarComprobacion() {
        System.out.println("Comprobando tickets no atendidos.");
    }
}
