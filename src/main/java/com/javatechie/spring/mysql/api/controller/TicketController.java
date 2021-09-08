package com.javatechie.spring.mysql.api.controller;

import com.javatechie.spring.mysql.api.dao.TicketDao;
import com.javatechie.spring.mysql.api.model.Ticket;
import com.javatechie.spring.mysql.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping("/tickets")
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tickets")
    public void add(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Ticket getATicket(@PathVariable Integer id){
        return ticketService.getATicket(id);
    }
    @RequestMapping(value =  "/students/{id}", method = RequestMethod.DELETE)
    public  void deleteTicket(@PathVariable Integer id){
        ticketService.deleteTicket(id);
    }
    @RequestMapping(value =  "/students/{id}", method = RequestMethod.DELETE)
    public  void updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket){
        ticketService.updateTicket(id,ticket);
    }
}
