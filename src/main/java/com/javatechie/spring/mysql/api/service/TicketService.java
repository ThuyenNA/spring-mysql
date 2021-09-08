package com.javatechie.spring.mysql.api.service;

import com.javatechie.spring.mysql.api.dao.TicketDao;
import com.javatechie.spring.mysql.api.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    public List<Ticket> getTickets(){
        return (List<Ticket>) ticketDao.findAll();
    }

    public  Ticket getATicket(Integer id){
        return ticketDao.findById(id).get();
    }

    public void addTicket(Ticket ticket){
        ticketDao.save(ticket);
    }

    public  void deleteTicket(Integer id){
        ticketDao.deleteById(id);
    }

    public void updateTicket(Integer id, Ticket ticket){
        ticketDao.save(ticket);
    }



}
