package com.codebuddies.ticketservice.model;


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
    private LocalDateTime createdDateTime;

    public BusTicket(){
        this.Code = TicketCodeGeneration.genarateCode();
        this.createdDateTime = LocalDateTime.now();
    }

}
