package com.codebuddies.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusTicketRequest {
    private String fullName;
    private String phoneNumber;
}
