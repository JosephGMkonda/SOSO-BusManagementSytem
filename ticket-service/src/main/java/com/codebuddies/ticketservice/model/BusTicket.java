package com.codebuddies.ticketservice.model;


import com.codebuddies.ticketservice.dto.BusTicketRequest;
import com.codebuddies.ticketservice.utilities.PhoneNumberVerifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="b_ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private LocalDateTime createdDateTime;
    private  String Code;

    public BusTicket(BusTicketRequest busTicketRequest) throws IllegalAccessException {
        this.Code = TicketCodeGeneration.genarateCode();
        this.createdDateTime = LocalDateTime.now();
        this.fullName = busTicketRequest.getFullName();

        if (PhoneNumberVerifier.verifyPhoneNumber(busTicketRequest.getPhoneNumber())){
            this.phoneNumber = busTicketRequest.getPhoneNumber();

        }else {
            throw new IllegalAccessException("Invalid phone number");
        }
    }

}

//wb=b^)v*
