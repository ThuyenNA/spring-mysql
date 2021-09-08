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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;
import java.util.Optional;

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

//    Các cách truyền tham số tới API

//    1.A Simple Mapping
//    Let's say that we have an endpoint /api/foos that takes a query parameter called id:
//    http://localhost:8080/api/foos?id=1
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

//    2.Specifying the Request Parameter Name
//    http://localhost:8080/api/foos?id=1&name=AnThuyen
    @PostMapping("/api/foos")
    @ResponseBody
    public String addFoos(@RequestParam("id") String fooId, @RequestParam String name) {
        return "ID: " + fooId + " Name: " + name;
    }

//    3.Optional Request Parameters
//    http://localhost:8080/api/foos2?id=acv
    @GetMapping("/api/foos2")
    @ResponseBody
    public String getFoos2(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }

//    3.1 Using Java 8 Optional
//    http://localhost:8080/api/foos3
    @GetMapping("/api/foos3")
    @ResponseBody
    public String getFoos3(@RequestParam Optional<String> id){
        return "ID: " + id.orElseGet(() -> "not provided");
    }

//    4. A Default Value for the Request Parameter
//    http://localhost:8080/api/foos4
    @GetMapping("/api/foos4")
    @ResponseBody
    public String getFoos4(@RequestParam(defaultValue = "test") String id) {
        return "ID: " + id;
    }

//    5. Mapping All Parameters
//    http://localhost:8080/api/foos2?id=123&name=AnThuyen
    @PostMapping("/api/foos2")
    @ResponseBody
    public String updateFoos(@RequestParam Map<String,String> allParams) {
        return "Parameters are " + allParams.entrySet();
    }

//     6. Mapping a Multi-Value Parameter
//    http://localhost:8080/api/foos5?id=1,2,3
    @GetMapping("/api/foos5")
    @ResponseBody
    public String getFoos5(@RequestParam List<String> id) {
        return "IDs are " + id;
    }
}
