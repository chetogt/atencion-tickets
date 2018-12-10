/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author jose
 */
@Singleton
@Startup
public class ComprobarTicketsNoAsignados {
    @Resource
    TimerService timerService;

    @PostConstruct
    public void initialize() {
        ScheduleExpression schedule = new ScheduleExpression();
        schedule.hour("*").minute("*").second("*/10");
        timerService.createCalendarTimer(schedule);
    }

    @Timeout
    public void programmaticTimeout(Timer timer) {
        System.out.println("Comprobando tickets no asignados...");
    }
}
