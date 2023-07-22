package com.codebuddies.ticketservice.service;

import com.codebuddies.ticketservice.dto.BusTicketRequest;
import com.codebuddies.ticketservice.model.BusTicket;
import com.codebuddies.ticketservice.repository.BusTicketRepository;
import org.springframework.stereotype.Service;

@Service

public class BusTicketService {

    private final BusTicketRepository busTicketRepository;


    public BusTicketService(BusTicketRepository busTicketRepository) {
        this.busTicketRepository = busTicketRepository;
    }

    public BusTicket createTicket(BusTicketRequest busTicketRequest) throws IllegalAccessException {
        BusTicket busTicket = null;
        try {
            busTicket = new BusTicket(busTicketRequest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return busTicketRepository.save(busTicket);
    }


}
