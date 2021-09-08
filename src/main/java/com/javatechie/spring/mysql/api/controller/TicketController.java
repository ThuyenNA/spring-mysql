package com.javatechie.spring.mysql.api.controller;


import com.javatechie.spring.mysql.api.model.Ticket;
import com.javatechie.spring.mysql.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping("/tickets")
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @PostMapping(value = "/ticket")
    public void add(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }


    @GetMapping(value = "/tickets/{id}")
    public Ticket getATicket(@PathVariable Integer id){
        return ticketService.getATicket(id);
    }

    @DeleteMapping(value =  "/tickets/{id}")
    public  void deleteTicket(@PathVariable Integer id){
        ticketService.deleteTicket(id);
    }

    @PutMapping("/tickets/{id}")
    public  void updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket){
        ticketService.updateTicket(id,ticket);
    }
}
