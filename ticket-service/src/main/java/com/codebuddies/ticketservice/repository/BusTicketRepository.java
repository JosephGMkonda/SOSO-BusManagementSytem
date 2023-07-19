package com.codebuddies.ticketservice.repository;

import com.codebuddies.ticketservice.model.BusTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusTicketRepository extends JpaRepository<BusTicket, Long> {

}
