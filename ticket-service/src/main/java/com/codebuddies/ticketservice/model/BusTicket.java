package com.codebuddies.ticketservice.model;


import com.codebuddies.ticketservice.dto.BusTicketRequest;
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

    public BusTicket(BusTicketRequest busTicketRequest){
        this.Code = TicketCodeGeneration.genarateCode();
        this.createdDateTime = LocalDateTime.now();
        this.fullName = busTicketRequest.getFullName();
    }

}

//wb=b^)v*
