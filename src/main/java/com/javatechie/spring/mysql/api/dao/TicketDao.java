package com.javatechie.spring.mysql.api.dao;

import com.javatechie.spring.mysql.api.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket,Integer> {

}
