package com.codebuddies.ticketservice.controller;

import com.codebuddies.ticketservice.dto.BusTicketRequest;
import com.codebuddies.ticketservice.model.BusTicket;
import com.codebuddies.ticketservice.service.BusTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BusTicketController {
    private final BusTicketService busTicketService;


    public BusTicketController(BusTicketService busTicketService) {
        this.busTicketService = busTicketService;
    }


    @PostMapping("/tickets")
    public ResponseEntity<BusTicket> createBusTicket(@RequestBody BusTicketRequest busTicketRequest){
        BusTicket createdTicket = busTicketService.createTicket(busTicketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);

    }
}
