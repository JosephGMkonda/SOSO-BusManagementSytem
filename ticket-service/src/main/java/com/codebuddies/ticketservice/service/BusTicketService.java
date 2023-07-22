package com.codebuddies.ticketservice.service;

import com.codebuddies.ticketservice.dto.BusTicketRequest;
import com.codebuddies.ticketservice.model.BusTicket;
import com.codebuddies.ticketservice.repository.BusTicketRepository;
import com.twilio.Twilio;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service

public class BusTicketService {

    private final BusTicketRepository busTicketRepository;
    private static final String ACCOUNT_SID = "AC57e8706560c646094599256611987111";
    private static final String AUTH_TOKEN = "01d0c8a94be8a68cd379f1b5bb5be9da";




    public BusTicketService(BusTicketRepository busTicketRepository) {
        this.busTicketRepository = busTicketRepository;
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public BusTicket createTicket(BusTicketRequest busTicketRequest) throws IllegalAccessException {
      if(!isValidPhoneNumber(busTicketRequest.getPhoneNumber())){
          throw new IllegalAccessException("Invalid phone number");
      }
        BusTicket busTicket = new BusTicket(busTicketRequest);
        return busTicketRepository.save(busTicket);

    }
    //+12703419864
    // sending text to the customer 
    public 
    private boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber != null && phoneNumber.matches("\\d{10}")){
            return true;
        }
        return false;
    }
}
