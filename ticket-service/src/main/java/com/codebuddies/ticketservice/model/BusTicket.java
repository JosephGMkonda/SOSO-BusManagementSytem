package com.codebuddies.ticketservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="b_ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusTicket {

}
