package com.codebuddies.ticketservice.service;

import com.codebuddies.ticketservice.dto.BusTicketRequest;
import com.codebuddies.ticketservice.model.BusTicket;
import com.codebuddies.ticketservice.repository.BusTicketRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Service

public class BusTicketService {

    private final BusTicketRepository busTicketRepository;
    private static final String ACCOUNT_SID = "AC57e8706560c646094599256611987111";
    private static final String AUTH_TOKEN = "37e23b7a8680a70d5852e339d60579b5";




    public BusTicketService(BusTicketRepository busTicketRepository) {
        this.busTicketRepository = busTicketRepository;
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    //converting number to +265 format
    private String toE164Format(String phoneNumber){
        String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");

        if(cleanNumber.startsWith("0")){
            cleanNumber.substring(1);

        }
        String e164Format = "+265" + cleanNumber;

        return e164Format;
    }

    public BusTicket createTicket(BusTicketRequest busTicketRequest) throws IllegalAccessException {
        String e164FormattedNumber = toE164Format(busTicketRequest.getPhoneNumber());

//        if(!isValidPhoneNumber(e164FormattedNumber)){
//          throw new IllegalAccessException("Invalid phone number");
//      }
        BusTicket busTicket = new BusTicket(busTicketRequest);
        return busTicketRepository.save(busTicket);

    }
    //+12703419864
    // sending text to the customer 
    public void sendTicketText(String phoneNumber, BusTicket busTicket){
        String e164FormattedNumber = toE164Format(phoneNumber);

        String messageBody =
                "==============="
                +busTicket.getFullName() +
                "===============\n" +
                "book date =======" + busTicket.getCreatedDateTime() + "\n" +
                "bus ticket ======" + busTicket.getCode() + "\n";

        LocalDateTime validTime = LocalDateTime.now().plusWeeks(2);
        messageBody += "valid time =====" + validTime + "\n";

        Message message = Message.creator(
                new PhoneNumber(e164FormattedNumber),
                new PhoneNumber("+12703419864"),
                messageBody
        ).create();

        System.out.println("Message SID:" + message.getSid());

    }
    private boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber != null && phoneNumber.matches("^\\\\+\\\\d{1,15}$")){
            return true;
        }
        return false;
    }
}
